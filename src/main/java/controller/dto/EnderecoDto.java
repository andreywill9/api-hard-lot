package controller.dto;

import domain.Endereco;

public class EnderecoDto {

  private Long id;

  private String cep;

  private String logradouro;

  private String uf;

  private String cidade;

  private String bairro;

  private Integer numero;

  private String complemento;

  public static Endereco paraDomain(EnderecoDto dto) {
    Endereco endereco = new Endereco();
    endereco.setId(dto.id);
    endereco.setCep(dto.cep);
    endereco.setLogradouro(dto.logradouro);
    endereco.setUf(dto.uf);
    endereco.setCidade(dto.cidade);
    endereco.setBairro(dto.bairro);
    endereco.setNumero(dto.numero);
    endereco.setComplemento(dto.complemento);
    return endereco;
  }

  public static EnderecoDto instanciarDeDomain(Endereco endereco) {
    EnderecoDto dto = new EnderecoDto();
    dto.id = endereco.getId();
    dto.cep = endereco.getCep();
    dto.logradouro = endereco.getLogradouro();
    dto.uf = endereco.getUf();
    dto.cidade = endereco.getCidade();
    dto.bairro = endereco.getBairro();
    dto.numero = endereco.getNumero();
    dto.complemento = endereco.getComplemento();
    return dto;
  }

  public EnderecoDto() {}

  public EnderecoDto(String cep, String logradouro, String uf, String cidade, String bairro, Integer numero, String complemento) {
    this.cep = cep;
    this.logradouro = logradouro;
    this.uf = uf;
    this.cidade = cidade;
    this.bairro = bairro;
    this.numero = numero;
    this.complemento = complemento;
  }

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
}
