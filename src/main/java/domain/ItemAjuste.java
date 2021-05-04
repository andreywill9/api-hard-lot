package domain;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity(name = "item_ajuste")
public class ItemAjuste extends ObjetoDominio {

  @ManyToOne()
  @JoinTable(name = "ajuste_id")
  private AjusteEstoque ajuste;

  @ManyToOne()
  @JoinTable(name = "produto_id")
  private Produto produto;

  private Integer quantidade;

  public AjusteEstoque getAjuste() {
    return ajuste;
  }

  public void setAjuste(AjusteEstoque ajuste) {
    this.ajuste = ajuste;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }
}
