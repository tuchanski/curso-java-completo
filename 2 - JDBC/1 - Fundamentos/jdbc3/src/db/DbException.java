package db;

public class DbException extends RuntimeException {

    // Since it extends RuntimeException, there isn't urge to treat the exception. May choose when treat it or not.

    private static final long serialVersionUID = 1L;

    public DbException(String message) {
        super(message);
    }
}
