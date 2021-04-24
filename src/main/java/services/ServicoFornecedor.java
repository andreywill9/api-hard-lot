package services;

import controller.dto.FornecedorDto;
import domain.Fornecedor;
import infraestructure.RepositorioFornecedor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoFornecedor {

  @Inject
  RepositorioFornecedor repositorioFornecedor;

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

  public Response buscarTodosForncedores() {
    try {
      return Response.ok(
          repositorioFornecedor.buscarTodos().stream().map(
              FornecedorDto::instanciarDeDomain
          ).collect(Collectors.toList())
      ).build();
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }
}
