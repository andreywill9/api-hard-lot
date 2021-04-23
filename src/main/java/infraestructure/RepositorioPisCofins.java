package infraestructure;

import domain.PisCofins;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioPisCofins implements PanacheRepository<PisCofins> {

  public PisCofins buscarPorId(Long idPisCofins) {
    try {
      return findById(idPisCofins);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public List<PisCofins> obterTodos() {
    try {
      return findAll().firstResult();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
