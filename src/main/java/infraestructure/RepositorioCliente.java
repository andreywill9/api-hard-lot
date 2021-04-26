package infraestructure;

import domain.Cliente;
import domain.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioCliente implements PanacheRepository<Cliente> {

    @Transactional
    public void cadastrar(Cliente cliente) {
        try {
            persist(cliente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public void verificarCpf(String cpf, Long idCliente) {
        if (idCliente == null) verificarCpfCadastro(cpf);
        else verificarCpfEdicao(cpf, idCliente);
    }

    private void verificarCpfCadastro(String cpf) {
        try {
            if (find("cpf = ?1", cpf).firstResult() != null)
                throw new WebApplicationException("CPF já cadastrado",
                        Response.Status.CONFLICT);
        } catch (WebApplicationException we) {
            throw we;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    private void verificarCpfEdicao(String cpf, Long idCliente) {
        try {
            if (find("cpf = ?1 AND id = ?2", cpf, idCliente).firstResult() != null)
                throw new WebApplicationException("CPF já cadastrado",
                        Response.Status.CONFLICT);
        } catch (WebApplicationException we) {
            throw we;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.CONFLICT);
        }
    }

    public List<Cliente> buscarPaginado(Integer numeroPagina) {
        try {
            return findAll().page(Page.of(numeroPagina, 10)).list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public Cliente buscarPorId(Long idCliente) {
        try {
            Cliente cliente = find("id = ?1", idCliente).firstResult();
            if (cliente == null) throw new WebApplicationException("Cliente não cadastrado", Response.Status.NOT_FOUND);
            return cliente;
        } catch (WebApplicationException we) {
            throw we;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public Cliente buscarPorCpf(String cpf) {
        try {
            Cliente cliente = find("cpf = ?1", cpf).firstResult();
            if (cliente == null) throw new WebApplicationException("Cliente não cadastrado", Response.Status.NOT_FOUND);
            return cliente;
        } catch (WebApplicationException we) {
            throw we;
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }
}
