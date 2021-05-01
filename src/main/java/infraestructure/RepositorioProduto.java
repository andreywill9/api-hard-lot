package infraestructure;

import domain.Departamento;
import domain.Fornecedor;
import domain.Produto;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

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

  public Produto buscarPorId(Long idProduto) {
    try {
      Produto produto = find("id = ?1", idProduto).firstResult();
      if (produto == null) throw new WebApplicationException("O produto não existe", Response.Status.NOT_FOUND);
      return produto;
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  public void excluirProduto(Produto produto) {
    try {
      delete("id = ?1", produto.getId());
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  public void editarProduto(Produto produto, Produto produtoAlterado) {
    produto.setNome(produtoAlterado.getNome());
    produto.setDescricao(produtoAlterado.getDescricao());
    produto.setPisCofins(produtoAlterado.getPisCofins());
    produto.setIcms(produtoAlterado.getIcms());
    produto.setMarca(produtoAlterado.getMarca());
    produto.setCodigoBarras(produtoAlterado.getCodigoBarras());
    produto.setPeso(produtoAlterado.getPeso());
    List<Departamento> departamentosRemover = produto.getDepartamentos().stream()
        .filter(departamento -> !produtoAlterado.getDepartamentos().contains(departamento)).collect(Collectors.toList());
    List<Departamento> departamentosAdicionar = produtoAlterado.getDepartamentos().stream()
        .filter(departamento -> !produto.getDepartamentos().contains(departamento)).collect(Collectors.toList());
    produto.getDepartamentos().removeAll(departamentosRemover);
    produto.getDepartamentos().addAll(departamentosAdicionar);
    List<Fornecedor> fornecedoresRemover = produto.getFornecedores().stream()
        .filter(fornecedor -> !produtoAlterado.getFornecedores().contains(fornecedor)).collect(Collectors.toList());
    List<Fornecedor> fornecedoresAdicionar = produtoAlterado.getFornecedores().stream()
        .filter(fornecedor -> !produto.getFornecedores().contains(fornecedor)).collect(Collectors.toList());
    produto.getFornecedores().removeAll(fornecedoresRemover);
    produto.getFornecedores().addAll(fornecedoresAdicionar);
  }
}
