package domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "marca")
public class Marca extends ObjetoDominio {

  private String nome;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "marca")
  private List<Produto> produtos;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
