package infraestructure;

import domain.Preco;
import domain.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RepositorioPreco implements PanacheRepository<Preco> {

  @Transactional
  public void excluirPorProduto(Produto produto) {
    try {
      delete("produto = ?1", produto);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
