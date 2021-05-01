package infraestructure;

import domain.Preco;
import domain.Produto;
import domain.enums.TipoPreco;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class RepositorioPreco implements PanacheRepository<Preco> {

  @Transactional
  public void excluirPorProduto(Produto produto, TipoPreco tipo) {
    try {
      delete("produto = ?1 AND tipoPreco = ?2", produto, tipo);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  public void atualizarPrecos(Produto produtoAlterado) {
   try {
     Preco precoPadrao = find("produto = ?1 AND tipoProduto = ?2", produtoAlterado, TipoPreco.COMUM)
         .firstResult();
     Preco precoPromocional = find("produto = ?1 AND tipoPreco = ?2", produtoAlterado, TipoPreco.PROMOCIONAL)
         .firstResult();
     tratarPrecoPadrao(precoPadrao, produtoAlterado.obterPrecoPorTipo(TipoPreco.COMUM), produtoAlterado);
     tratarPrecoPromocional(precoPromocional, produtoAlterado.obterPrecoPorTipo(TipoPreco.PROMOCIONAL), produtoAlterado);
   } catch (Exception e) {
     e.printStackTrace();
     throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
   }
  }

  @Transactional
  private void tratarPrecoPadrao(Preco precoPadrao, Preco precoAlterado, Produto produto) {
    if (precoPadrao == null && precoAlterado == null) return;
    if (precoPadrao == null) {
      cadastrarNovoPreco(precoAlterado);
      return;
    }
    if (precoAlterado == null) {
      excluirPorProduto(produto, TipoPreco.COMUM);
      return;
    }
    precoPadrao.setValor(precoAlterado.getValor());
  }

  @Transactional
  private void tratarPrecoPromocional(Preco precoPromocional, Preco precoAlterado, Produto produto) {
    if (precoPromocional == null && precoAlterado == null) return;
    if (precoPromocional == null) {
      cadastrarNovoPreco(precoAlterado);
      return;
    }
    if (precoAlterado == null) {
      excluirPorProduto(produto, TipoPreco.PROMOCIONAL);
      return;
    }
    precoPromocional.setValor(precoAlterado.getValor());
    precoPromocional.setInicioPromocao(precoAlterado.getInicioPromocao());
    precoPromocional.setFimPromocao(precoAlterado.getFimPromocao());
  }

  @Transactional
  public void cadastrarNovoPreco(Preco novoPreco) {
    try {
      persist(novoPreco);
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }
}
