package domain;

import javax.persistence.*;
import java.util.List;

@Entity(name = "fornecedor")
public class Fornecedor extends ObjetoDominio {

  @Column(name = "razao_social")
  private String razaoSocial;

  @Column(name = "nome_fantasia")
  private String nomeFantasia;

  private String cnpj;

  private String telefone;

  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private Endereco endereco;

  @ManyToMany(mappedBy = "fornecedores")
  private List<Produto> produtos;

  private Boolean status;

  @OneToMany(mappedBy = "fornecedor")
  private List<Compra> compras;

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public void setRazaoSocial(String razaoSocial) {
    this.razaoSocial = razaoSocial;
  }

  public String getNomeFantasia() {
    return nomeFantasia;
  }

  public void setNomeFantasia(String nomeFantasia) {
    this.nomeFantasia = nomeFantasia;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
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

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
