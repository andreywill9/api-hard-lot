package infraestructure;

import domain.Endereco;
import domain.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RepositorioEndereco implements PanacheRepository<Endereco> {

  @Transactional
  public void alterarEndereco(Endereco endereco, Endereco enderecoAlterado) {
    try {
      endereco.setCep(enderecoAlterado.getCep());
      endereco.setUf(enderecoAlterado.getUf());
      endereco.setCidade(enderecoAlterado.getCidade());
      endereco.setBairro(enderecoAlterado.getBairro());
      endereco.setLogradouro(enderecoAlterado.getLogradouro());
      endereco.setNumero(enderecoAlterado.getNumero());
      endereco.setComplemento(enderecoAlterado.getComplemento());
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  public void excluirPorFornecedor(Fornecedor fornecedor) {
    try {
      delete("fornecedor = ?1", fornecedor);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

}
