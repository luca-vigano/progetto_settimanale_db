package lucavig.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lucavig.entities.Stampa;
import lucavig.entities.Utente;
import lucavig.exceptions.NotFoundISBN;

import java.util.List;

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

    public Utente findById (long id) {
        Utente found = entityManager.find(Utente.class, id);
        if (found == null) throw new NotFoundISBN(id);
        return found;
    }

}
