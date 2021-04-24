package controller;

import controller.dto.FornecedorDto;
import services.ServicoFornecedor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("fornecedor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorController {

  @Inject
  ServicoFornecedor servicoFornecedor;

  @POST
  public Response cadastrarFornecedor(FornecedorDto dto) {
    return servicoFornecedor.cadastrar(dto);
  }

  @GET
  public Response buscarTodos(@QueryParam("pagina") Integer pagina) {
    return servicoFornecedor.buscarTodosForncedores(pagina);
  }

}
