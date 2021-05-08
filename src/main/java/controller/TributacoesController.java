package controller;

import services.ServicoIcms;
import services.ServicoPisCofins;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("tributacoes")
@Produces(MediaType.APPLICATION_JSON)
public class TributacoesController {

  @Inject
  ServicoPisCofins servicePisCofins;

  @Inject
  ServicoIcms serviceIcms;

  @GET
  @Path("/pisCofins")
  public Response buscarPisCofins() {
    return servicePisCofins.obterTodos();
  }

  @GET
  @Path("/icms")
  public Response buscarIcms() {
    return serviceIcms.obterTodos();
  }

}
