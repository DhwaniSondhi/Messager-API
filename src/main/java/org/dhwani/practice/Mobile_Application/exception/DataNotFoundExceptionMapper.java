package org.dhwani.practice.Mobile_Application.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.dhwani.practice.Mobile_Application.model.ErrorMessage;


@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) { 
		return Response.status(Status.NOT_FOUND)
						.entity(new ErrorMessage(404,exception.getMessage(),""))
						.build();
	}

}
