package controller.dto;

import domain.Departamento;

public class DepartamentoDto {

  private Long id;

  private String nome;

  public static DepartamentoDto instanicarDeDomain(Departamento departamento) {
    DepartamentoDto dto = new DepartamentoDto();
    dto.id = departamento.getId();
    dto.nome = departamento.getNome();
    return dto;
  }

  public static Departamento paraDomain(DepartamentoDto dto) {
    Departamento departamento = new Departamento();
    departamento.setId(dto.id);
    departamento.setNome(dto.nome);
    return departamento;
  }

  public DepartamentoDto() {}

  public DepartamentoDto(Long id, String nome) {
    this.id = id;
    this.nome = nome;
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
}
