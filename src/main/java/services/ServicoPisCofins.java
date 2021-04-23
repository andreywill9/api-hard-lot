package services;

import controller.dto.PisCofinsDto;
import domain.PisCofins;
import infraestructure.RepositorioPisCofins;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoPisCofins {

  @Inject
  RepositorioPisCofins repositorioPisCofins;

  public Response obterTodos() {
    try {
      return Response.ok(
          repositorioPisCofins.obterTodos().stream().map(PisCofinsDto::instanciarDeDomain).collect(Collectors.toList())
      ).build();
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  protected PisCofins obterPorId(Long idPisCofins) {
    return repositorioPisCofins.buscarPorId(idPisCofins);
  }

}
