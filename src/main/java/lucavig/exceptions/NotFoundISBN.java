package lucavig.exceptions;

public class NotFoundISBN extends RuntimeException {
    public NotFoundISBN(long isbn) {
        super("La stampa con isbn n. " + isbn + " non è stata trovata");
    }
}
