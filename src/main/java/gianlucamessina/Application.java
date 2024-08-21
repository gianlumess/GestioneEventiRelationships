package gianlucamessina;

import gianlucamessina.dao.EventoDao;
import gianlucamessina.dao.LocationDao;
import gianlucamessina.dao.PartecipazioneDao;
import gianlucamessina.dao.PersonaDao;
import gianlucamessina.entities.Evento;
import gianlucamessina.entities.Location;
import gianlucamessina.entities.Partecipazione;
import gianlucamessina.entities.Persona;
import gianlucamessina.enums.PersonaSesso;
import gianlucamessina.enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.UUID;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("BE_U1_S3_L3");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EventoDao ed = new EventoDao(em);
        PersonaDao pd = new PersonaDao(em);
        LocationDao ld = new LocationDao(em);
        PartecipazioneDao pard = new PartecipazioneDao(em);

        //-----------------------------SAVE---------------------------
        Persona chiaraFromDb = pd.getById(UUID.fromString("36c446cd-4b18-49eb-bd67-e7668350c3e2"));
        Evento partyFromDb = ed.getById(UUID.fromString("89671aa5-9c23-45c0-bf39-ea44b78399f7"));
        Location numberoOneFromDb = ld.getById(UUID.fromString("3d6e0eaf-0e0c-429f-b8e9-95340c3a2194"));
        Location colosseoFromDb = ld.getById(UUID.fromString("db230459-c0a4-472e-ba78-a5ad6ad95b5e"));

        Evento compleanno = new Evento("festa di compleanno", LocalDate.of(2024, 9, 12), "non scordatevi i regali!", TipoEvento.PRIVATO, 40, numberoOneFromDb);
        Evento party = new Evento("techno party", LocalDate.of(2024, 10, 06), "serata solo musica techno", TipoEvento.PUBBLICO, 200, colosseoFromDb);
        Persona giovanni = new Persona("Giovanni", "Storti", "giovanni.storti@gmail.com", LocalDate.of(1972, 04, 13), PersonaSesso.M);
        Persona chiara = new Persona("Chiara", "Soretti", "chiara.soretti@gmail.com", LocalDate.of(2001, 10, 01), PersonaSesso.F);
        Location numberOne = new Location("Number One", "Brescia");
        Location teatroMassimo = new Location("Teatro Massimo", "Palermo");
        Location colosseo = new Location("Colosseo", "Roma");

        Partecipazione partecipazione1 = new Partecipazione(chiaraFromDb, partyFromDb);


        //ed.save(compleanno);
        //ed.save(party);

        //pd.save(giovanni);
        //pd.save(chiara);

        //ld.save(numberOne);
        //ld.save(teatroMassimo);
        //ld.save(colosseo);

        //pard.save(partecipazione1);


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
