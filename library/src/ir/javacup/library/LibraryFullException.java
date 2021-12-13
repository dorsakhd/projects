package ir.javacup.library;

public class LibraryFullException extends Exception {

    public LibraryFullException() {
    }

    public LibraryFullException(String message) {
        super(message);
    }

    public LibraryFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryFullException(Throwable cause) {
        super(cause);
    }

    public LibraryFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
