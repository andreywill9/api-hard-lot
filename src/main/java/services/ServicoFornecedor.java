package services;

import controller.dto.FornecedorDto;
import domain.Fornecedor;
import infraestructure.RepositorioEndereco;
import infraestructure.RepositorioFornecedor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoFornecedor {

  @Inject
  RepositorioFornecedor repositorioFornecedor;

  @Inject
  RepositorioEndereco repositorioEndereco;

  @Transactional
  public Response cadastrar(FornecedorDto dto) {
    try {
      repositorioFornecedor.verificarCnpj(dto.getCnpj(), null);
      repositorioFornecedor.cadastrar(FornecedorDto.paraDomain(dto));
      return Response.ok().build();
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Response buscarTodosFornecedores(Integer paginaAtual) {
    try {
      return Response.ok(
          repositorioFornecedor.buscarPaginado(paginaAtual).stream().map(FornecedorDto::instanciarDeDomain)
              .collect(Collectors.toList())
      ).build();
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  public Response editarFornecedor(FornecedorDto dto, Long idFornecedor) {
    try {
      Fornecedor fornecedor = repositorioFornecedor.buscarPorId(idFornecedor);
      repositorioFornecedor.verificarCnpj(dto.getCnpj(), idFornecedor);
      Fornecedor fornecedorAlterado = FornecedorDto.paraDomain(dto);
      repositorioFornecedor.alterar(fornecedor, fornecedorAlterado);
      repositorioEndereco.alterarEndereco(fornecedor.getEndereco(), fornecedorAlterado.getEndereco());
      return Response.ok().build();
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  public Response alterarStatusFornecedor(Long idFornecedor) {
    try {
      Fornecedor fornecedor = repositorioFornecedor.buscarPorId(idFornecedor);
      repositorioFornecedor.alterarStatus(fornecedor);
      return Response.ok().build();
    } catch (WebApplicationException we) {
      throw  we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public Response excluirFornecedor(Long idFornecedor) {
    try {
      Fornecedor fornecedor = repositorioFornecedor.buscarPorId(idFornecedor);
      repositorioFornecedor.excluir(fornecedor);
      repositorioEndereco.excluirPorFornecedor(fornecedor);
      return Response.ok().build();
    } catch (WebApplicationException we) {
      throw  we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  public List<Fornecedor> buscarFornecedoresPorId(List<Long> ids) {
    return repositorioFornecedor.buscarPorIds(ids);
  }
}
