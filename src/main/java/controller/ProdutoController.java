package controller;

import controller.dto.ProdutoDto;
import services.ServicoProduto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoController {

  @Inject
  ServicoProduto servicoProduto;

  @POST
  public Response cadastrarProduto(ProdutoDto dto) {
    return servicoProduto.cadastrar(dto);
  }

  @GET
  public Response buscarPaginado(@QueryParam("pagina") Integer pagina) {
    return servicoProduto.obterPaginado(pagina);
  }

}
