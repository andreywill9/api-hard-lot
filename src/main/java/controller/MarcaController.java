package controller;

import services.ServicoMarca;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("marcas")
@Produces(MediaType.APPLICATION_JSON)
public class MarcaController {

  @Inject
  ServicoMarca serviceMarca;

  @GET
  public Response buscarMarcas() {
    return serviceMarca.buscarTodasMarcas();
  }

}
