package lucavig.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lucavig.entities.Prestito;
import lucavig.entities.Stampa;

import java.util.List;


public class PrestitoDAO {

    private final EntityManager entityManager;

    public PrestitoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save (Prestito prestito) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(prestito);
        transaction.commit();

        System.out.println("Il prestito di " + prestito.getStampa() + " è stato salvato correttamente");
    }

    public List<Stampa> trovaLibriDaTessera(long tesseraId) {
        TypedQuery<Stampa> query = entityManager.createQuery("SELECT s FROM Prestito p JOIN p.stampa s WHERE p.utente.numeroDiTessera = :tesseraId AND p.dataRestituzioneEffettiva IS NULL", Stampa.class);
        query.setParameter("tesseraId", tesseraId);
        return query.getResultList();
    }
}
