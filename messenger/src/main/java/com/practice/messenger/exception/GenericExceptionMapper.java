package com.practice.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.practice.messenger.model.ErrorMessage;


@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage error = new ErrorMessage(exception.getMessage(), 500, "blah blah");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(error)
				.build();
	}

}
