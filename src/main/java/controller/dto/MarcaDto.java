package controller.dto;

import domain.Marca;

public class MarcaDto {

  private Long id;

  private String nome;

  public static MarcaDto instanciarDeDomain(Marca marca) {
    MarcaDto dto = new MarcaDto();
    dto.id = marca.getId();
    dto.nome = marca.getNome();
    return dto;
  }

  public static Marca paraDominio(MarcaDto dto) {
    Marca marca = new Marca();
    marca.setId(dto.id);
    marca.setNome(dto.nome);
    return marca;
  }

  public MarcaDto() {}

  public MarcaDto(Long id, String nome) {
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
