package infraestructure.repository;

import domain.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositorioMarca implements PanacheRepository<Marca> {
}
