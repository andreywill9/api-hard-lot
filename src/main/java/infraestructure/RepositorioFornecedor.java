package infraestructure;

import domain.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioFornecedor implements PanacheRepository<Fornecedor> {

  @Transactional
  public void cadastrar(Fornecedor fornecedor) {
    try {
      persist(fornecedor);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public void verificarCnpj(String cnpj, Long idFornecedor) {
    if (idFornecedor == null) verificarCnpjCadastro(cnpj);
    else verificarCnpjEdicao(cnpj, idFornecedor);
  }

  private void verificarCnpjCadastro(String cnpj) {
    try {
      if (find("cnpj = ?1", cnpj).firstResult() != null)
        throw new WebApplicationException("Este CNPJ já existe", Response.Status.CONFLICT);
    }
    catch (WebApplicationException we) {
      throw we;
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  private void verificarCnpjEdicao(String cnpj, Long idFornecedor) {
    try {
      if (find("cnpj = ?1 AND id <> ?2", cnpj, idFornecedor).firstResult() != null)
        throw new WebApplicationException("Este CNPJ já existe", Response.Status.CONFLICT);
    }
    catch (WebApplicationException we) {
      throw we;
    }
    catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public List<Fornecedor> buscarTodos() {
    try {
      return findAll().list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Fornecedor buscarPorId(Long id) {
    try {
      return findById(id);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
