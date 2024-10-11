package lucavig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucavig.dao.PrestitoDAO;
import lucavig.dao.StampaDAO;
import lucavig.dao.UtenteDAO;
import lucavig.entities.*;
import lucavig.exceptions.NotFoundISBN;

import java.time.LocalDate;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("librarydb");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        StampaDAO sd = new StampaDAO(em);
        UtenteDAO ud = new UtenteDAO(em);
        PrestitoDAO pd = new PrestitoDAO(em);

//        Libri l1 = new Libri("il signore degli anelli 1",2010,500,"J. R. R. Tolkien","romanzo");
//        Libri l2 = new Libri("harry potter",2015,1000," J. K. Rowling","romanzo");
//        Libri l3 = new Libri("il signore degli anelli 2",2012,503,"J. R. R. Tolkien","romanzo");
//        Libri l4 = new Libri("harry potter 2 ",2019,1000," J. K. Rowling","romanzo");
//
//        Riviste r1=new Riviste("caccia e pesca", 2023,50, Periodicita.MENSILE);
//        Riviste r2=new Riviste("ricettario", 2023,50, Periodicita.SETTIMANALE);
//        Riviste r3=new Riviste("taglia e cuci", 2023,50, Periodicita.SEMESTRALE);

//        Utente aldo = new Utente("Aldo", "Baglio", LocalDate.of(1960,5,21));
//        Utente giovanni = new Utente("Giovanni", "Storti", LocalDate.of(1957,7,11));
//        Utente giacomo = new Utente("Giacomo", "Poretti", LocalDate.of(1955,9,2));
//

//        ud.save(aldo);
//        ud.save(giacomo);
//        ud.save(giovanni);

        //AGGIUNTA ELEMENTI AL CATALOGO
//        sd.save(l1);
//        sd.save(l2);
//        sd.save(l3);
//        sd.save(l4);
//        sd.save(r1);
//        sd.save(r2);
//        sd.save(r3);

//        try {
        //   RICERCA PER ISBN
//            Stampa fromDb = sd.findByISBN(2);
//            System.out.println(fromDb);
//
        // RIMOZIONE PER ISBN
//            sd.deleteStampaFromISBN(1);
//
//        } catch (NotFoundISBN ex) {
//            System.out.println(ex.getMessage());
//        }

        // RICERCA PER ANNO DI PUBBLICAZIONE
//        sd.searchByPubbYear(2023).forEach(System.out::println);

        // RICERCA PER AUTORE
//        sd.searchByAuthor(" J. K. Rowling").forEach(System.out::println);
//
//        RICERCA PER  TITOLO
//        sd.searchByTitle(" potter").forEach(System.out::println);



//        Utente aldoFromDb = ud.findById(1);
//        Utente giovanniFromDb = ud.findById(1);
//        Utente giacomoFromDb = ud.findById(1);
//        Stampa stampafromDb1 = sd.findByISBN(2);
//        Stampa stampafromDb2 = sd.findByISBN(4);
//        Stampa stampafromDb3 = sd.findByISBN(5);
//        Stampa stampafromDb4 = sd.findByISBN(7);
//        Prestito prestitoAldo1 = new Prestito(aldoFromDb,stampafromDb1,LocalDate.of(2024,9,1),LocalDate.of(2024,9,28));
//        Prestito prestitoAldo2 = new Prestito(aldoFromDb,stampafromDb2,LocalDate.of(2024,10,10));
//        Prestito prestitoGiovanni = new Prestito(giovanniFromDb,stampafromDb3,LocalDate.of(2024,8,9));
//        Prestito prestitoGiacomo = new Prestito(giacomoFromDb,stampafromDb4,LocalDate.of(2024,5,1),LocalDate.of(2024,5,20));
//
//        pd.save(prestitoAldo1);
//        pd.save(prestitoAldo2);
//        pd.save(prestitoGiovanni);
//        pd.save(prestitoGiacomo);

        pd.trovaLibriDaTessera(1).forEach(System.out::println);

        em.close();
        emf.close();

    }
}
