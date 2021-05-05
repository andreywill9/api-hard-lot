package domain;

import domain.enums.Cargo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "colaborador")
public class Colaborador extends ObjetoDominio{

  @Column(name = "nome_completo")
  private String nomeCompleto;

  private String cpf;

  private String telefone;

  private String email;

  @Column(name = "salario_base")
  private BigDecimal salarioBase;

  private Cargo cargo;

  private BigDecimal comissao;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "endereco_id", referencedColumnName = "id")
  private Endereco endereco;

  @OneToMany(mappedBy = "colaborador")
  private List<Venda> vendas;

  @OneToMany(mappedBy = "colaborador")
  private List<AjusteEstoque> ajustes;

  @OneToMany(mappedBy = "colaborador")
  private List<Compra> compras;

  @OneToMany(mappedBy = "colaborador")
  private List<Devolucao> devolucoes;

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

  public BigDecimal getSalarioBase() {
    return salarioBase;
  }

  public void setSalarioBase(BigDecimal salarioBase) {
    this.salarioBase = salarioBase;
  }

  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }

  public BigDecimal getComissao() {
    return comissao;
  }

  public void setComissao(BigDecimal comissao) {
    this.comissao = comissao;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public List<AjusteEstoque> getAjustes() {
    return ajustes;
  }

  public void setAjustes(List<AjusteEstoque> ajustes) {
    this.ajustes = ajustes;
  }

  public List<Compra> getCompras() {
    return compras;
  }

  public void setCompras(List<Compra> compras) {
    this.compras = compras;
  }

  public List<Devolucao> getDevolucoes() {
    return devolucoes;
  }

  public void setDevolucoes(List<Devolucao> devolucoes) {
    this.devolucoes = devolucoes;
  }

  public List<Venda> getVendas() {
    return vendas;
  }

  public void setVendas(List<Venda> vendas) {
    this.vendas = vendas;
  }
}
