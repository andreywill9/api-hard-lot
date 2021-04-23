package infraestructure;

import domain.Icms;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioIcms implements PanacheRepository<Icms> {

  public Icms buscarPorId(Long idIcms) {
    try {
      return findById(idIcms);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public List<Icms> buscarTodosIcms() {
    try {
      return findAll().list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }
}
