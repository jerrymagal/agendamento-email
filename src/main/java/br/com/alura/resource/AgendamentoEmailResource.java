package br.com.alura.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.alura.business.AgendamentoEmailBusiness;
import br.com.alura.entity.AgendamentoEmail;
import br.com.alura.exception.BusinessException;

@Path("/agendamento-email")
public class AgendamentoEmailResource {

	@Inject
	private AgendamentoEmailBusiness business;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarAgendamentoEmail() {
		return Response.ok(business.listarAgendamentos()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response salvar(AgendamentoEmail agendamentoEmail) throws BusinessException {

		business.salvar(agendamentoEmail);
		return Response.status(Status.CREATED).build();
	}

}
