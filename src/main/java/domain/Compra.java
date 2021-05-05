package domain;

import domain.enums.StatusCompra;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.List;

public class Compra extends ObjetoDominio {

  @ManyToOne()
  @JoinColumn(name = "fornecedor_id")
  private Fornecedor fornecedor;

  private BigDecimal total;

  private StatusCompra status;

  @OneToMany(mappedBy = "compra")
  private List<ItemCompra> itens;

  @ManyToOne()
  @JoinColumn(name = "colaborador_id")
  private Colaborador colaborador;

  public Fornecedor getFornecedor() {
    return fornecedor;
  }

  public void setFornecedor(Fornecedor fornecedor) {
    this.fornecedor = fornecedor;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public StatusCompra getStatus() {
    return status;
  }

  public void setStatus(StatusCompra status) {
    this.status = status;
  }

  public List<ItemCompra> getItens() {
    return itens;
  }

  public void setItens(List<ItemCompra> itens) {
    this.itens = itens;
  }

  public Colaborador getColaborador() {
    return colaborador;
  }

  public void setColaborador(Colaborador colaborador) {
    this.colaborador = colaborador;
  }
}
