package gianlucamessina;

import gianlucamessina.dao.EventoDao;
import gianlucamessina.entities.Evento;
import gianlucamessina.entities.TipoEvento;
import gianlucamessina.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE_U1_S3_L3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);

        //-----------------------------SAVE---------------------------
        Evento compleanno = new Evento("festa di compleanno", LocalDate.of(2024, 9, 12), "non scordatevi i regali!", TipoEvento.PRIVATO, 40);
        Evento party = new Evento("techno party", LocalDate.of(2024, 10, 06), "serata solo musica techno", TipoEvento.PUBBLICO, 200);
        //ed.save(compleanno);
        //ed.save(party);


        //-----------------------------GET BY ID---------------------------
        try {
            Evento partyBYId = ed.getById(102);
            System.out.println(partyBYId);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        //-----------------------------DELETE---------------------------

       /* try {
            ed.deleteById(152);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }*/


        em.close();
        emf.close();
    }
}
