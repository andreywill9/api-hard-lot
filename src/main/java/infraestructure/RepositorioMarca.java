package infraestructure;

import domain.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioMarca implements PanacheRepository<Marca> {

  @Transactional
  public void cadastrar(Marca marca) {
    try {
      persist(marca);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public List<Marca> buscarTodas() {
    try {
      return findAll().list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Marca buscarPorId(Long id) {
    try {
      return findById(id);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Marca marcaJaExiste(String nome) {
    try {
      return find("nome LIKE ?1", nome).firstResult();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
