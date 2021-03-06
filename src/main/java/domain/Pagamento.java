package domain;

import domain.enums.FormaPagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity(name = "pagamento")
public class Pagamento extends ObjetoDominio{

  @ManyToOne
  @JoinColumn(name = "venda_id")
  Venda venda;

  @Column(name = "forma_pagamento")
  FormaPagamento forma;

  BigDecimal valor;

  Integer parcelas;

  public Venda getVenda() {
    return venda;
  }

  public void setVenda(Venda venda) {
    this.venda = venda;
  }

  public FormaPagamento getForma() {
    return forma;
  }

  public void setForma(FormaPagamento forma) {
    this.forma = forma;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public Integer getParcelas() {
    return parcelas;
  }

  public void setParcelas(Integer parcelas) {
    this.parcelas = parcelas;
  }
}
