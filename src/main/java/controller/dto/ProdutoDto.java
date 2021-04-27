package controller.dto;

import domain.*;
import domain.enums.TipoPreco;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDto {

  private Long id;

  private String nome;

  private MarcaDto marca;

  private BigDecimal peso;

  private BigDecimal precoComum;

  private BigDecimal precoPromocional;

  private String inicioDataPromocao;

  private String fimDataPromocao;

  private String codigoBarras;

  private List<DepartamentoDto> departamentos;

  private List<FornecedorDto> fornecedores;

  private Integer estoque;

  private String descricao;

  private Long idPisCofins;

  private Long idIcms;

  private Boolean status;

  public ProdutoDto() {}

  public static Produto paraDominio(ProdutoDto dto, PisCofins pisCofins, Icms icms, List<Fornecedor> fornecedores, Marca marca, List<Departamento> departamentos) throws ParseException {
    Produto produto = new Produto();
    produto.setId(dto.id);
    produto.setNome(dto.nome);
    produto.setPeso(dto.peso);
    produto.setCodigoBarras(dto.codigoBarras);
    produto.setDescricao(dto.descricao);
    produto.setFornecedores(fornecedores);
    produto.setEstoque(dto.estoque);
    produto.setPisCofins(pisCofins);
    produto.setIcms(icms);
    produto.setMarca(marca);
    produto.setDepartamentos(departamentos);
    List<Preco> precos = new ArrayList<>();
    if (dto.precoComum != null) {
      precos.add(Preco.precoComum(dto.precoComum, produto));
    }
    if (dto.precoPromocional != null) {
      Date inicioPromocao = new SimpleDateFormat("dd/MM/yyyy").parse(dto.inicioDataPromocao);
      Date fimPromocao = new SimpleDateFormat("dd/MM/yyyy").parse(dto.fimDataPromocao);
      precos.add(Preco.precoPromocional(dto.precoPromocional, produto, inicioPromocao, fimPromocao));
    }
    produto.setStatus(dto.status == null || dto.status);
    produto.setPrecos(precos);
    return produto;
  }

  public static ProdutoDto instanciarDeDominio(Produto produto) {
    ProdutoDto dto = new ProdutoDto();
    dto.setId(produto.getId());
    dto.setNome(produto.getNome());
    if (produto.getMarca() != null ) dto.setMarca(MarcaDto.instanciarDeDomain(produto.getMarca()));
    dto.setPeso(produto.getPeso());
    Preco precoPadrao = produto.obterPrecoPorTipo(TipoPreco.COMUM);
    Preco precoPromocional = produto.obterPrecoPorTipo(TipoPreco.PROMOCIONAL);
    if (precoPadrao != null) dto.setPrecoComum(precoPadrao.getValor());
    if (precoPromocional != null) {
      dto.setPrecoPromocional(precoPromocional.getValor());
      dto.setInicioDataPromocao(new SimpleDateFormat("dd/MM/yyyy").format(precoPromocional.getInicioPromocao()));
      dto.setFimDataPromocao(new SimpleDateFormat("dd/MM/yyyy").format(precoPromocional.getFimPromocao()));
    }
    dto.setCodigoBarras(produto.getCodigoBarras());
    dto.setDepartamentos(produto.getDepartamentos().stream().map(DepartamentoDto::instanicarDeDomain).collect(Collectors.toList()));
    dto.setFornecedores(produto.getFornecedores().stream().map(FornecedorDto::instanciarDeDomain).collect(Collectors.toList()));
    dto.setEstoque(produto.getEstoque());
    dto.setDescricao(produto.getDescricao());
    dto.setStatus(produto.getStatus());
    // TODO PIS COFINS E ICMS
    return dto;
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

  public BigDecimal getPrecoComum() {
    return precoComum;
  }

  public void setPrecoComum(BigDecimal precoComum) {
    this.precoComum = precoComum;
  }

  public BigDecimal getPrecoPromocional() {
    return precoPromocional;
  }

  public void setPrecoPromocional(BigDecimal precoPromocional) {
    this.precoPromocional = precoPromocional;
  }

  public String getInicioDataPromocao() {
    return inicioDataPromocao;
  }

  public void setInicioDataPromocao(String inicioDataPromocao) {
    this.inicioDataPromocao = inicioDataPromocao;
  }

  public String getFimDataPromocao() {
    return fimDataPromocao;
  }

  public void setFimDataPromocao(String fimDataPromocao) {
    this.fimDataPromocao = fimDataPromocao;
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

  public Long getIdPisCofins() {
    return idPisCofins;
  }

  public void setIdPisCofins(Long idPisCofins) {
    this.idPisCofins = idPisCofins;
  }

  public Long getIdIcms() {
    return idIcms;
  }

  public void setIdIcms(Long idIcms) {
    this.idIcms = idIcms;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
