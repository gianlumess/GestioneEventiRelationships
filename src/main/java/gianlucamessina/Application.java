package gianlucamessina;

import gianlucamessina.dao.EventoDao;
import gianlucamessina.dao.LocationDao;
import gianlucamessina.dao.PersonaDao;
import gianlucamessina.entities.Evento;
import gianlucamessina.entities.Location;
import gianlucamessina.entities.Persona;
import gianlucamessina.enums.PersonaSesso;
import gianlucamessina.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE_U1_S3_L3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);
        PersonaDao pd = new PersonaDao(em);
        LocationDao ld = new LocationDao(em);

        //-----------------------------SAVE---------------------------
        Evento compleanno = new Evento("festa di compleanno", LocalDate.of(2024, 9, 12), "non scordatevi i regali!", TipoEvento.PRIVATO, 40);
        Evento party = new Evento("techno party", LocalDate.of(2024, 10, 06), "serata solo musica techno", TipoEvento.PUBBLICO, 200);
        Persona giovanni = new Persona("Giovanni", "Storti", "giovanni.storti@gmail.com", LocalDate.of(1972, 04, 13), PersonaSesso.M);
        Location numberOne = new Location("Number One", "Brescia");
        //ed.save(compleanno);
        //ed.save(party);

        //pd.save(giovanni);

        //ld.save(numberOne);


        //-----------------------------GET BY ID---------------------------
       /* try {
            Evento partyBYId = ed.getById(102);
            System.out.println(partyBYId);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }*/

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
