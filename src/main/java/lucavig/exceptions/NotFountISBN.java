package lucavig.exceptions;

public class NotFountISBN extends RuntimeException {
    public NotFountISBN(long isbn) {
        super("La stampa con isbn n. " + isbn + " non è stata trovata");
    }
}
