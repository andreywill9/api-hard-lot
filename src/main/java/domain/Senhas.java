package domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity(name = "senhas")
public class Senhas extends ObjetoDominio {

  @OneToOne()
  @JoinColumn(name = "colaborador_id")
  private Colaborador colaborador;

  @Lob
  private String senha;

  public Colaborador getColaborador() {
    return colaborador;
  }

  public void setColaborador(Colaborador colaborador) {
    this.colaborador = colaborador;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }
}
