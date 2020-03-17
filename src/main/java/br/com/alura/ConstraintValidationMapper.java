package br.com.alura;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.alura.dto.MensagemErroDto;

@Provider
public class ConstraintValidationMapper implements ExceptionMapper<ConstraintViolationException>{

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		return Response.status(Status.BAD_REQUEST)
					   .entity(MensagemErroDto.build(exception.getConstraintViolations()
							   								  .stream()
							   								  .map(c -> c.getMessage())
							   								  .collect(Collectors.toList()))).build();
	}

}
