package infraestructure;

import domain.Departamento;
import domain.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioDepartamento implements PanacheRepository<Departamento> {

  @Transactional

  public void cadastrar(Departamento departamento) {
    try {
      persist(departamento);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public List<Departamento> buscarTodos() {
    try {
      return findAll().list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Departamento buscarPorId(Long id) {
    try {
      return findById(id);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Departamento departamentoJaExiste(String nome) {
    try {
      return find("nome LIKE ?1", nome).firstResult();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }
}
