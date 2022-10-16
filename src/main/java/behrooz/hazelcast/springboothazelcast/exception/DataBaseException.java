
package behrooz.hazelcast.springboothazelcast.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DataBaseException extends ResponseStatusException {
    public DataBaseException(String reason) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason);
    }

    public DataBaseException(String reason, Throwable cause) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, reason, cause);
    }
}