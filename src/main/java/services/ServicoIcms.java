package services;

import controller.dto.IcmsDto;
import domain.Icms;
import infraestructure.RepositorioIcms;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoIcms {

  @Inject
  RepositorioIcms repositorioIcms;

  public Response obterTodos() {
    try {
      return Response.ok(
          repositorioIcms.buscarTodosIcms().stream().map(IcmsDto::instanciarDeDominio).collect(Collectors.toList())
      ).build();
    } catch (Exception e) {
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  protected Icms obterPorId(Long idIcms) {
    return repositorioIcms.buscarPorId(idIcms);
  }

}
