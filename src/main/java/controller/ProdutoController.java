package controller;

import controller.dto.ProdutoDto;
import infraestructure.ServicoProduto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
  public Response cadastrarProduto(ProdutoDto json) {
    return servicoProduto.cadastrar(json);
  }

}
