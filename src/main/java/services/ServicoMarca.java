package services;

import controller.dto.MarcaDto;
import domain.Marca;
import infraestructure.RepositorioMarca;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoMarca {

  @Inject
  RepositorioMarca repositorioMarca;

  public Response buscarTodasMarcas() {
    try {
      return Response.ok(
          repositorioMarca.buscarTodas().stream().map(MarcaDto::instanciarDeDomain).collect(Collectors.toList())
      ).build();
    } catch (WebApplicationException we) {
      throw we;
    } catch(Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  @Transactional
  protected Marca buscarOuCadastrar(MarcaDto dto) {
    Marca marca = repositorioMarca.marcaJaExiste(dto.getNome());
    if (marca != null) return marca;
    marca = MarcaDto.paraDominio(dto);
    repositorioMarca.cadastrar(marca);
    return marca;
  }

}
