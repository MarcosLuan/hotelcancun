package exception;

import org.jboss.logging.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class WebApplicationExceptionError extends WebApplicationException {
    private static final Logger LOGGER = Logger.getLogger(WebApplicationExceptionError.class);
    private static final long serialVersionUID = 1L;
    private static final int STATUS_CODE = 400;
    public WebApplicationExceptionError(String msg,String msgLog) {
        super(msg, STATUS_CODE);
        LOGGER.info(msgLog);
        throw new WebApplicationException(Response
                .status(Response.Status.BAD_REQUEST)
                .type(MediaType.TEXT_PLAIN)
                .entity(msg)
                .build());
    }
}

