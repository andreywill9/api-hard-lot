package controller.dto;

import domain.Fornecedor;

public class FornecedorDto {

  private Long id;

  private String razaoSocial;

  private String nomeFantasia;

  private String cnpj;

  private String telefone;

  private String email;

  private Boolean status;

  private EnderecoDto endereco;

  public static Fornecedor paraDomain(FornecedorDto dto) {
    Fornecedor fornecedor = new Fornecedor();
    fornecedor.setId(dto.getId());
    fornecedor.setRazaoSocial(dto.razaoSocial);
    fornecedor.setNomeFantasia(dto.nomeFantasia);
    fornecedor.setCnpj(dto.cnpj);
    fornecedor.setEmail(dto.email);
    fornecedor.setTelefone(dto.telefone);
    fornecedor.setStatus(dto.status == null || dto.status);
    fornecedor.setEndereco(EnderecoDto.paraDomain(dto.endereco));
    return fornecedor;
  }

  public static FornecedorDto instanciarDeDomain(Fornecedor fornecedor) {
    FornecedorDto dto = new FornecedorDto();
    dto.id = fornecedor.getId();
    dto.razaoSocial = fornecedor.getRazaoSocial();
    dto.nomeFantasia = fornecedor.getNomeFantasia();
    dto.cnpj = fornecedor.getCnpj();
    dto.email = fornecedor.getEmail();
    dto.telefone = fornecedor.getTelefone();
    dto.status = fornecedor.getStatus();
    dto.endereco = EnderecoDto.instanciarDeDomain(fornecedor.getEndereco());
    return dto;
  }

  public FornecedorDto() {}

  public FornecedorDto(Long id, String razaoSocial, String nomeFantasia, String cnpj, String telefone, String email, EnderecoDto endereco) {
    this.id = id;
    this.razaoSocial = razaoSocial;
    this.nomeFantasia = nomeFantasia;
    this.cnpj = cnpj;
    this.telefone = telefone;
    this.email = email;
    this.endereco = endereco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  public EnderecoDto getEndereco() {
    return endereco;
  }

  public void setEndereco(EnderecoDto endereco) {
    this.endereco = endereco;
  }

  public Boolean isStatus() {
    return status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }
}
