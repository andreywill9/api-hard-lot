package controller.dto;

import domain.PisCofins;

import java.math.BigDecimal;

public class PisCofinsDto {

  private Long id;

  private String descricao;

  private BigDecimal aliquotaPis;

  private BigDecimal aliquotaCofins;

  public static PisCofinsDto instanciarDeDomain(PisCofins pisCofins) {
    PisCofinsDto dto = new PisCofinsDto();
    dto.id = pisCofins.getId();
    dto.descricao = pisCofins.getDescricao();
    dto.aliquotaPis = pisCofins.getAliquotaPis();
    dto.aliquotaCofins = pisCofins.getAliquotaCofins();
    return dto;
  }

  public PisCofinsDto() {}

  public PisCofinsDto(Long id, String descricao, BigDecimal aliquotaPis, BigDecimal aliquotaCofins) {
    this.id = id;
    this.descricao = descricao;
    this.aliquotaPis = aliquotaPis;
    this.aliquotaCofins = aliquotaCofins;
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

  public BigDecimal getAliquotaPis() {
    return aliquotaPis;
  }

  public void setAliquotaPis(BigDecimal aliquotaPis) {
    this.aliquotaPis = aliquotaPis;
  }

  public BigDecimal getAliquotaCofins() {
    return aliquotaCofins;
  }

  public void setAliquotaCofins(BigDecimal aliquotaCofins) {
    this.aliquotaCofins = aliquotaCofins;
  }
}
