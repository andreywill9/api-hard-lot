package infraestructure;

import domain.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
public class RepositorioFornecedor implements PanacheRepository<Fornecedor> {

    @Transactional
    public void cadastrar(Fornecedor fornecedor) {
        try {
            persist(fornecedor);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Fornecedor> buscarTodos() {
        try {
            return findAll().list();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public Fornecedor buscarPorId(Long id) {
        try {
            return findById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    public Fornecedor FornecedorJaExiste(String nome) {
        try {
            return find("nome LIKE ?1", nome).firstResult();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

}
