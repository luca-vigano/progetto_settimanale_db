package lucavig.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lucavig.entities.Stampa;
import lucavig.exceptions.NotFoundISBN;

import java.util.List;

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
        if (found == null) throw new NotFoundISBN(stampaISBN);
        return found;
    }

    public void deleteStampaFromISBN (long stampaISBN) {
        Stampa stampaDaCancellare = this.findByISBN(stampaISBN);

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.remove(stampaDaCancellare);

        transaction.commit();

        System.out.println("La stampa " + stampaDaCancellare.getTitolo() + " è stato eliminata correttamente");
    }


    public List<Stampa> searchByPubbYear(int anno){
        TypedQuery<Stampa> query = entityManager.createQuery("SELECT s FROM Stampa s WHERE s.annoDiPubblicazione = :anno", Stampa.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    public List<Stampa> searchByAuthor(String autore){
        TypedQuery<Stampa> query = entityManager.createQuery("SELECT s FROM Stampa s WHERE s.autore = :autore", Stampa.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    public List<Stampa> searchByTitle(String titolo){
        TypedQuery<Stampa> query = entityManager.createQuery("SELECT s FROM Stampa s WHERE s.titolo LIKE :titolo", Stampa.class);
        query.setParameter("titolo","%" + titolo + "%");
        return query.getResultList();
    }
}
