package poc.jersey.demo.server.exceptions.exception;

public class BusinessException extends RuntimeException {

    private static final String EXCEPTION_MESSAGE = "business exception happen";

    public BusinessException() {
        super(EXCEPTION_MESSAGE);
    }
}
