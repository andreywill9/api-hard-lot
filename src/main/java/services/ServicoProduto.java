package services;

import controller.dto.FornecedorDto;
import controller.dto.ProdutoDto;
import domain.*;
import infraestructure.RepositorioProduto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoProduto {

  @Inject
  RepositorioProduto repositorioProduto;

  @Inject
  ServicoMarca servicoMarca;

  @Inject
  ServicoDepartamento servicoDepartamento;

  @Inject
  ServicoPisCofins servicoPisCofins;

  @Inject
  ServicoIcms servicoIcms;

  @Inject
  ServicoFornecedor servicoFornecedor;

  @Transactional
  public Response cadastrar(ProdutoDto dto) {
    try {
      if (dto.getCodigoBarras() != null) {
        repositorioProduto.verificarCodigoBarras(dto.getCodigoBarras(), null);
      }
      PisCofins pisCofins = dto.getIdPisCofins() != null ?
          servicoPisCofins.obterPorId(dto.getIdPisCofins()) :
          null;
      Icms icms = dto.getIdIcms() != null ?
          servicoIcms.obterPorId(dto.getIdIcms()) :
          null;
      List<Fornecedor> fornecedores = dto.getFornecedores() != null ?
          servicoFornecedor.buscarFornecedoresPorId(dto.getFornecedores().stream().map(FornecedorDto::getId).collect(Collectors.toList())) :
          new ArrayList<>();
      Marca marca = dto.getMarca() != null ?
          servicoMarca.buscarOuCadastrar(dto.getMarca()) :
          null;
      repositorioProduto.cadastrar(ProdutoDto.paraDominio(dto, pisCofins, icms, fornecedores, marca, obterDepartamentos(dto)));
      return Response.ok().build();
    } catch (WebApplicationException e) {
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }

  private List<Departamento> obterDepartamentos(ProdutoDto dto) {
    return dto.getDepartamentos() == null || dto.getDepartamentos().isEmpty() ?
        new ArrayList<>() :
        dto.getDepartamentos().stream().map(servicoDepartamento::buscarOuCadastrar).collect(Collectors.toList());
  }

  public Response obterPaginado(Integer pagina) {
    try {
      return Response.ok(
          repositorioProduto.buscarPaginado(pagina).stream().map(ProdutoDto::instanciarDeDominio).collect(Collectors.toList())
      ).build();
    } catch (WebApplicationException we) {
      throw we;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
    }
  }


}
