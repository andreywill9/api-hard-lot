package controller.dto;

import domain.Produto;

import java.math.BigDecimal;
import java.util.List;

public class ProdutoDto {

  private Long id;

  private String nome;

  private MarcaDto marca;

  private BigDecimal peso;

  private List<PrecoDto> precos;

  private String codigoBarras;

  private List<DepartamentoDto> departamentos;

  private List<FornecedorDto> fornecedores;

  private Integer estoque;

  private String descricao;

  private PisCofinsDto pisCofins;

  private IcmsDto icms;

  public ProdutoDto() {}

  public static Produto paraDominio(ProdutoDto dto) {
    //TODO outros atributos
    Produto produto = new Produto();
    produto.setId(dto.id);
    produto.setNome(dto.nome);
    produto.setPeso(dto.peso);
    produto.setCodigoBarras(dto.codigoBarras);
    produto.setDescricao(dto.descricao);
    return produto;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public MarcaDto getMarca() {
    return marca;
  }

  public void setMarca(MarcaDto marca) {
    this.marca = marca;
  }

  public BigDecimal getPeso() {
    return peso;
  }

  public void setPeso(BigDecimal peso) {
    this.peso = peso;
  }

  public List<PrecoDto> getPrecos() {
    return precos;
  }

  public void setPrecos(List<PrecoDto> precos) {
    this.precos = precos;
  }

  public String getCodigoBarras() {
    return codigoBarras;
  }

  public void setCodigoBarras(String codigoBarras) {
    this.codigoBarras = codigoBarras;
  }

  public List<DepartamentoDto> getDepartamentos() {
    return departamentos;
  }

  public void setDepartamentos(List<DepartamentoDto> departamentos) {
    this.departamentos = departamentos;
  }

  public List<FornecedorDto> getFornecedores() {
    return fornecedores;
  }

  public void setFornecedores(List<FornecedorDto> fornecedores) {
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

  public PisCofinsDto getPisCofins() {
    return pisCofins;
  }

  public void setPisCofins(PisCofinsDto pisCofins) {
    this.pisCofins = pisCofins;
  }

  public IcmsDto getIcms() {
    return icms;
  }

  public void setIcms(IcmsDto icms) {
    this.icms = icms;
  }
}
