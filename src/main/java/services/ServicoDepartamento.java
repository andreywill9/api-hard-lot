package services;

import controller.dto.DepartamentoDto;
import domain.Departamento;
import infraestructure.RepositorioDepartamento;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoDepartamento {

  @Inject
  RepositorioDepartamento repositorioDepartamento;

  public Response buscarTodos() {
    try {
      return Response.ok(
          repositorioDepartamento.buscarTodos().stream().map(DepartamentoDto::instanicarDeDomain).collect(Collectors.toList())
      ).build();
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  protected Departamento buscarOuCadastrar(DepartamentoDto dto) {
    Departamento departamento = repositorioDepartamento.departamentoJaExiste(dto.getNome());
    if (departamento != null) return departamento;
    departamento = DepartamentoDto.paraDomain(dto);
    repositorioDepartamento.cadastrar(departamento);
    return departamento;
  }
}
