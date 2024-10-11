package lucavig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lucavig.dao.StampaDAO;
import lucavig.entities.Libri;
import lucavig.entities.Periodicita;
import lucavig.entities.Riviste;



public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("librarydb");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();
        StampaDAO sd = new StampaDAO(em);

        Libri l1 = new Libri("il signore degli anelli 1",2010,500,"J. R. R. Tolkien","romanzo");
        Libri l2 = new Libri("harry potter",2015,1000," J. K. Rowling","romanzo");
        Libri l3 = new Libri("il signore degli anelli 2",2012,503,"J. R. R. Tolkien","romanzo");
        Libri l4 = new Libri("harry potter 2 ",2019,1000," J. K. Rowling","romanzo");

        Riviste r1=new Riviste("caccia e pesca", 2023,50, Periodicita.MENSILE);
        Riviste r2=new Riviste("ricettario", 2023,50, Periodicita.SETTIMANALE);
        Riviste r3=new Riviste("taglia e cuci", 2023,50, Periodicita.SEMESTRALE);

//        sd.save(l1);
//        sd.save(l2);
//        sd.save(l3);
//        sd.save(l4);
//        sd.save(r1);
//        sd.save(r2);
//        sd.save(r3);

    }
}
