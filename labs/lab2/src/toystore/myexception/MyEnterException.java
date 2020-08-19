package toystore.myexception;

public class MyEnterException extends Exception {
    public MyEnterException() {
    }

    public MyEnterException(String message) {
        super(message);
    }

    public MyEnterException(String message, Throwable cause) {
        super(message, cause);
    }
}
