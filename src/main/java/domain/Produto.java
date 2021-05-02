package domain;

import domain.enums.TipoPreco;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "produto")
public class Produto extends ObjetoDominio {

  private String nome;

  @ManyToOne
  @JoinColumn(name = "marca_id")
  private Marca marca;

  private BigDecimal peso;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
  private List<Preco> precos;

  @Column(name = "codigo_barras", unique = true)
  private String codigoBarras;

  @ManyToMany()
  @JoinTable(
      name = "produto_departamento",
      joinColumns = @JoinColumn(name = "produto_id"),
      inverseJoinColumns = @JoinColumn(name = "departamento_id")
  )
  private List<Departamento> departamentos;

  @ManyToMany()
  @JoinTable(
      name = "produto_fornecedores",
      joinColumns = @JoinColumn(name = "produto_id"),
      inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
  )
  private List<Fornecedor> fornecedores;

  private Integer estoque;

  private String descricao;

  @ManyToOne
  @JoinColumn(name = "pis_cofins_id")
  private PisCofins pisCofins;

  @ManyToOne
  @JoinColumn(name = "icms_id")
  private Icms icms;

  private Boolean status;

  @Lob
  private String imagem;

  public Produto() {}

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Marca getMarca() {
    return marca;
  }

  public void setMarca(Marca marca) {
    this.marca = marca;
  }

  public BigDecimal getPeso() {
    return peso;
  }

  public void setPeso(BigDecimal peso) {
    this.peso = peso;
  }

  public List<Preco> getPrecos() {
    return precos;
  }

  public void setPrecos(List<Preco> precos) {
    this.precos = precos;
  }

  public String getCodigoBarras() {
    return codigoBarras;
  }

  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

  public List<Departamento> getDepartamentos() {
    return departamentos;
  }

  public void setDepartamentos(List<Departamento> departamentos) {
    this.departamentos = departamentos;
  }

  public List<Fornecedor> getFornecedores() {
    return fornecedores;
  }

  public void setFornecedores(List<Fornecedor> fornecedores) {
    this.fornecedores = fornecedores;
  }

  public Integer getEstoque() {
    return estoque;
  }

  public void setEstoque(Integer estoque) {
    this.estoque = estoque;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public PisCofins getPisCofins() {
    return pisCofins;
  }

  public void setPisCofins(PisCofins pisCofins) {
    this.pisCofins = pisCofins;
  }

  public Icms getIcms() {
    return icms;
  }

  public void setIcms(Icms icms) {
    this.icms = icms;
  }

  public Preco obterPrecoPorTipo(TipoPreco tipoPreco) {
    return getPrecos().stream().filter(preco -> preco.getTipoPreco().equals(tipoPreco)).findFirst().orElse(null);
  }

  public Boolean getStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }
}
