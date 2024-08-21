package gianlucamessina.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Il record con ID: " + id + " non è stato trovato");
    }
}
