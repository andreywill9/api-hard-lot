package controller;

import controller.dto.ClienteDto;
import services.ServicoCliente;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteController {

  @Inject
  ServicoCliente servicoCliente;

  @POST
  public Response cadastrarCliente(ClienteDto dto) {
    return servicoCliente.cadastrar(dto);
  }

  @GET
  public Response buscarTodos(@QueryParam("pagina") Integer pagina) {
    return servicoCliente.buscarTodosClientes(pagina);
  }

  @PUT
  @Path("/{id}")
  public Response editarCliente(@PathParam("id") Long idCliente, ClienteDto dto) {
    return servicoCliente.editarCliente(dto, idCliente);
  }
}
