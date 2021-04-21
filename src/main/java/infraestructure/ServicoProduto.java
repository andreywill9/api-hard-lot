package infraestructure;

import controller.dto.ProdutoDto;
import infraestructure.repository.RepositorioProduto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class ServicoProduto {

  @Inject
  RepositorioProduto repositorioProduto;

  public Response cadastrar(ProdutoDto json) {
    try {
      // TODO validar
      repositorioProduto.cadastrar(ProdutoDto.paraDominio(json));
      return Response.ok().build();
    } catch (WebApplicationException e) {
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
