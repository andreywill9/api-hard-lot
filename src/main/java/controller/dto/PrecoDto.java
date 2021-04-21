package controller.dto;

import domain.enums.TipoPreco;

import java.math.BigDecimal;

public class PrecoDto {

  private BigDecimal valor;

  private TipoPreco tipoPreco;

  private String inicioPromocao;

  private String fimPromocao;

}
