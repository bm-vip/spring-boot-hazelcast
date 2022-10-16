package behrooz.hazelcast.springboothazelcast.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlreadyExistsException extends ResponseStatusException {
  public AlreadyExistsException(String reason) {
    super(HttpStatus.BAD_REQUEST, reason);
  }

  public AlreadyExistsException(String reason, Throwable cause) {
    super(HttpStatus.BAD_REQUEST, reason, cause);
  }
}
