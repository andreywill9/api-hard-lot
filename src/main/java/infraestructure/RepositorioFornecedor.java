package infraestructure;

import domain.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

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

  @Transactional
  public void alterar(Fornecedor fornecedor, Fornecedor fornecedorAlterado) {
    try {
      fornecedor.setNomeFantasia(fornecedorAlterado.getNomeFantasia());
      fornecedor.setRazaoSocial(fornecedorAlterado.getRazaoSocial());
      fornecedor.setCnpj(fornecedorAlterado.getCnpj());
      fornecedor.setTelefone(fornecedorAlterado.getTelefone());
      fornecedor.setEmail(fornecedorAlterado.getEmail());
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  public void alterarStatus(Fornecedor fornecedor) {
    try {
      fornecedor.setStatus(!fornecedor.getStatus());
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

  public List<Fornecedor> buscarPaginado(Integer numeroPagina) {
    try {
      return findAll().page(Page.of(numeroPagina, 10)).list();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Fornecedor buscarPorId(Long idFornecedor) {
    try {
      Fornecedor fornecedor = find("id = ?1", idFornecedor).firstResult();
      if (fornecedor == null) throw new WebApplicationException("O Fornecedor não existe", Response.Status.NOT_FOUND);
      return fornecedor;
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
