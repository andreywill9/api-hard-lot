package domain;

import domain.enums.StatusDevolucao;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "devolucao")
public class Devolucao extends ObjetoDominio {

  @ManyToOne()
  @JoinColumn(name = "venda_id")
  private Venda venda;

  private StatusDevolucao status;

  // TODO COLABORADOR

  private String descricao;

  @OneToMany(mappedBy = "devolucao")
  private List<ItemDevolucao> itens;

  public Venda getVenda() {
    return venda;
  }

  public void setVenda(Venda venda) {
    this.venda = venda;
  }

  public StatusDevolucao getStatus() {
    return status;
  }

  public void setStatus(StatusDevolucao status) {
    this.status = status;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public List<ItemDevolucao> getItens() {
    return itens;
  }

  public void setItens(List<ItemDevolucao> itens) {
    this.itens = itens;
  }
}
