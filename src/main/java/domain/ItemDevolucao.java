package domain;

import domain.enums.StatusItemDevolucao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity(name = "item_devolucao")
public class ItemDevolucao extends ObjetoDominio {

  @ManyToOne
  @JoinColumn(name = "devolucao_id")
  private Devolucao devolucao;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  private StatusItemDevolucao status;

  private String descricao;

  private BigDecimal precoUnitario;

  public Devolucao getDevolucao() {
    return devolucao;
  }

  public void setDevolucao(Devolucao devolucao) {
    this.devolucao = devolucao;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public StatusItemDevolucao getStatus() {
    return status;
  }

  public void setStatus(StatusItemDevolucao status) {
    this.status = status;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPrecoUnitario() {
    return precoUnitario;
  }

  public void setPrecoUnitario(BigDecimal precoUnitario) {
    this.precoUnitario = precoUnitario;
  }
}
