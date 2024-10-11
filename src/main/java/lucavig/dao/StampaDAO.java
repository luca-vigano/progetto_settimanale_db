package lucavig.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lucavig.entities.Stampa;
import lucavig.exceptions.NotFountISBN;

public class StampaDAO {

    private final EntityManager entityManager;


    public StampaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Stampa stampa) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(stampa);
        transaction.commit();

        System.out.println("La stampa con titolo" + stampa.getTitolo() + " è stata salvata correttamente");
    }

    public Stampa findByISBN (long stampaISBN) {
        Stampa found = entityManager.find(Stampa.class, stampaISBN);
        if (found == null) throw new NotFountISBN(stampaISBN);
        return found;
    }

    public void deleteStampa (long stampaISBN) {
        Stampa stampaDaCancellare = this.findByISBN(stampaISBN);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.remove(stampaDaCancellare);

        transaction.commit();

        System.out.println("La stampa " + stampaDaCancellare.getTitolo() + " è stato eliminata correttamente");
    }


}
