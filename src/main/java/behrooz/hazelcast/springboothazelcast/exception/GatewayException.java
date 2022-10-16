package behrooz.hazelcast.springboothazelcast.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;

@SuppressWarnings("serial")
public class GatewayException extends Exception {

    private static final Log log = LogFactory.getLog(GatewayException.class);

    private Object[] args;

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public GatewayException() {
        super();
    }

    public GatewayException(String message) {
        super(message);
        if (log.isErrorEnabled()) {
            log.error("Exception: " + message);
        }
    }

    public GatewayException(String message, Throwable cause) {
        super(message, cause);
        if (log.isErrorEnabled()) {
            log.error("Exception: " + message);
        }
    }

    public GatewayException(String message, Object... args) {
        this(message);
        this.args = args;
    }

    public GatewayException(String message, Throwable cause, Object... args) {
        this(message, cause);
        this.args = args;
    }

    public Object getMessageArgs() {
        if (args != null) {
            return Arrays.asList(getMessage(), Arrays.asList(args));
        }
        return getMessage();
    }
}
