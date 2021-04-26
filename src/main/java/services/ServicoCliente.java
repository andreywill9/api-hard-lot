package services;

import controller.dto.ClienteDto;
import domain.Cliente;
import infraestructure.RepositorioCliente;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.stream.Collectors;

@ApplicationScoped
public class ServicoCliente {

    @Inject
    RepositorioCliente repositorioCliente;

    @Transactional
    public Response cadastrar(ClienteDto dto) {
        try {
            repositorioCliente.verificarCpf(dto.getCpf(), null);
            repositorioCliente.cadastrar(ClienteDto.paraDomain(dto));
            return Response.ok().build();
        } catch (WebApplicationException we) {
            throw we;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public Response buscarTodosClientes(Integer paginaAtual){
        try {
            return Response.ok(
                    repositorioCliente.buscarPaginado(paginaAtual).stream().map(
                            ClienteDto::instanciarDeDomain).collect(Collectors.toList())
            ).build();
        }catch (WebApplicationException we){
            throw  we;
        }catch (Exception e){
            e.printStackTrace();
            throw  new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public Response editarCliente(ClienteDto dto, long idCliente){
        try{
            Cliente cliente = repositorioCliente.buscarPorId(idCliente);
            repositorioCliente.verificarCpf(dto.getCpf(), idCliente);
            Cliente.editarCliente(cliente, ClienteDto.paraDomain(dto));
            return Response.ok().build();
        }catch (WebApplicationException we) {
            throw we;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
