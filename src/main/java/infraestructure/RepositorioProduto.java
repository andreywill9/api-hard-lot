package infraestructure;

import domain.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioProduto implements PanacheRepository<Produto> {

  @Transactional
  public void cadastrar(Produto produto) {
    try {
      persist(produto);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public void verificarCodigoBarras(String codigoBarras, Long idProduto) {
    if (idProduto == null) {
      verificarCodigoBarrasCadastro(codigoBarras);
    } else {
      verificarCodigoBarrasEdicao(codigoBarras, idProduto);
    }
  }

  private void verificarCodigoBarrasCadastro(String codigoBarras) {
    try {
      Produto produto = find("codigoBarras = ?1", codigoBarras).firstResult();
      if (produto != null) throw new WebApplicationException(Response.Status.CONFLICT);
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  private void verificarCodigoBarrasEdicao(String codigoBarras, Long idProduto) {
    try {
      Produto produto = find("codigoBarras = ?1 AND id <> ?2", codigoBarras, idProduto).firstResult();
      if (produto != null) throw new WebApplicationException(Response.Status.CONFLICT);
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public List<Produto> buscarPaginado(Integer pagina) {
    try {
      return findAll().page(Page.of(pagina, 10)).list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
