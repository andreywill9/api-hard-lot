package domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "item_venda")
public class ItemVenda extends ObjetoDominio {

  @ManyToOne
  @Column(name = "venda_id")
  Venda venda;

  @OneToOne()
  @JoinColumn(name = "produto_id", referencedColumnName = "id")
  Produto produto;

  BigDecimal valorUnitario;

  Integer quantidade;

  BigDecimal total;

  public ItemVenda(Venda venda, Produto produto, BigDecimal valorUnitario, Integer quantidade, BigDecimal total) {
    this.venda = venda;
    this.produto = produto;
    this.valorUnitario = valorUnitario;
    this.quantidade = quantidade;
    this.total = total;
  }

  public Venda getVenda() {
    return venda;
  }

  public void setVenda(Venda venda) {
    this.venda = venda;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public BigDecimal getValorUnitario() {
    return valorUnitario;
  }

  public void setValorUnitario(BigDecimal valorUnitario) {
    this.valorUnitario = valorUnitario;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }
}
