package domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "endereco")
public class Endereco extends ObjetoDominio {

  private String cep;

  private String logradouro;

  private String uf;

  private String cidade;

  private String bairro;

  private Integer numero;

  private String complemento;

  @OneToMany(mappedBy = "endereco")
  private List<Fornecedor> fornecedores;

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public List<Fornecedor> getFornecedores() {
    return fornecedores;
  }

  public void setFornecedores(List<Fornecedor> fornecedores) {
    this.fornecedores = fornecedores;
  }
}
