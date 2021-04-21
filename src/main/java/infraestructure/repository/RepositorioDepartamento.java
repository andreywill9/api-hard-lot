package infraestructure.repository;

import domain.Departamento;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RepositorioDepartamento implements PanacheRepository<Departamento> {
}
