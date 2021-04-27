package domain;

import javax.persistence.*;

@Entity(name = "cliente")
public class Cliente extends ObjetoDominio {

  @Column(name = "nome_completo")
  private String nomeCompleto;

  private String cpf;

  private String telefone;

  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private Endereco endereco;

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public static void editarCliente(Cliente cliente, Cliente alterado) {
    cliente.setNomeCompleto(alterado.getNomeCompleto());
    cliente.setCpf(alterado.getCpf());
    cliente.setEmail(alterado.getEmail());
    cliente.setTelefone(alterado.getTelefone());
  }
}
