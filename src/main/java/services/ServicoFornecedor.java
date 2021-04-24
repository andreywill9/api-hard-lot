package services;

import controller.dto.FornecedorDto;
import controller.dto.MarcaDto;
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
    RepositorioFornecedor RepositorioFornecedor;

    public Response buscarTodosForncedores() {
        try {
            return Response.ok(
                    RepositorioFornecedor.buscarTodos().stream().map
                            (FornecedorDto::instanciarDeDomain).collect
                            (Collectors.toList())).build();
        } catch (WebApplicationException we) {
            throw  we;
        } catch (Exception e){
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    protected Fornecedor buscarOuCadastrar(FornecedorDto dto){
        Fornecedor fornecedor = RepositorioFornecedor.FornecedorJaExiste
                (dto.getNomeFantasia());
        if (fornecedor != null) return fornecedor;
        fornecedor = FornecedorDto.paraDomain(dto);
        RepositorioFornecedor.cadastrar(fornecedor);
        return  fornecedor;
    }
}
