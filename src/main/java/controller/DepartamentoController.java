package controller;

import services.ServicoDepartamento;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("departamentos")
@Produces(MediaType.APPLICATION_JSON)
public class DepartamentoController {

  @Inject
  ServicoDepartamento serviceDepartamento;

  @GET
  public Response buscarDepartamentos() {
    return serviceDepartamento.buscarTodos();
  }

}
