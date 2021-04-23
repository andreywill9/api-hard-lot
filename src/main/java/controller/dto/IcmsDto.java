package controller.dto;

import domain.Icms;

import java.math.BigDecimal;

public class IcmsDto {

  private Long id;

  private String descricao;

  private BigDecimal aliquota;

  public static IcmsDto instanciarDeDominio(Icms icms) {
    IcmsDto dto = new IcmsDto();
    dto.id = icms.getId();
    dto.descricao = icms.getDescricao();
    dto.aliquota = icms.getAliquota();
    return dto;
  }

  public IcmsDto() { }

  public IcmsDto(Long id, String descricao, BigDecimal aliquota) {
    this.id = id;
    this.descricao = descricao;
    this.aliquota = aliquota;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getAliquota() {
    return aliquota;
  }

  public void setAliquota(BigDecimal aliquota) {
    this.aliquota = aliquota;
  }
}
