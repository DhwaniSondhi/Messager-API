/*
 * package org.dhwani.practice.Mobile_Application.exception;
 * 
 * import javax.ws.rs.core.Response; import javax.ws.rs.core.Response.Status;
 * import javax.ws.rs.ext.ExceptionMapper; import javax.ws.rs.ext.Provider;
 * 
 * import org.dhwani.practice.Mobile_Application.model.ErrorMessage;
 * 
 * @Provider public class GenericExceptionMapper implements
 * ExceptionMapper<Throwable> {
 * 
 * @Override public Response toResponse(Throwable exception) { return
 * Response.status(Status.INTERNAL_SERVER_ERROR) .entity(new
 * ErrorMessage(500,exception.getMessage(),"")) .build(); }
 * 
 * }
 */