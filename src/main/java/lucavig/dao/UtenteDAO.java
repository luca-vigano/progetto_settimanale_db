package lucavig.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucavig.entities.Stampa;
import lucavig.entities.Utente;

public class UtenteDAO {

    private final EntityManager entityManager;

    public UtenteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save (Utente utente) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(utente);
        transaction.commit();

        System.out.println("L'utente " + utente.getNome() + " è stato salvato correttamente");
    }
}
