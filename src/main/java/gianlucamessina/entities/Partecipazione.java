package gianlucamessina.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private UUID id;
    @OneToOne
    @JoinColumn(name = "persona", nullable = false)
    private Persona persona;
    @OneToOne
    @JoinColumn(name = "evento", nullable = false)
    private Evento evento;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Evento evento) {
        this.persona = persona;
        this.evento = evento;
    }

    public UUID getId() {
        return id;
    }


    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                '}';
    }
}
