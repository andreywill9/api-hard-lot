package controller;

import controller.dto.FornecedorDto;
import services.ServicoFornecedor;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("fornecedor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorController {

  @Inject
  ServicoFornecedor servicoFornecedor;

  @POST
  public Response cadastrarFornecedor(FornecedorDto dto) {
    return servicoFornecedor.cadastrar(dto);
  }

}
