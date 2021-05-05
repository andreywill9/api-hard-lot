package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "venda")
public class Venda extends ObjetoDominio {

  @ManyToOne
  @JoinColumn(name = "cliente_id")
  private Cliente cliente;

  private BigDecimal total;

  @Column(name = "valor_pago")
  private BigDecimal valorPago;

  private BigDecimal troco;

  @OneToMany(mappedBy = "venda")
  private List<ItemVenda> itens;

  @OneToMany(mappedBy = "venda")
  private List<Pagamento> pagamentos;

  @ManyToOne()
  @JoinColumn(name = "colaborador_id")
  private Colaborador colaborador;

  public Venda(Cliente cliente, BigDecimal total, BigDecimal valorPago, BigDecimal troco, List<ItemVenda> itens, List<Pagamento> pagamentos) {
    this.cliente = cliente;
    this.total = total;
    this.valorPago = valorPago;
    this.troco = troco;
    this.itens = itens;
    this.pagamentos = pagamentos;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public BigDecimal getValorPago() {
    return valorPago;
  }

  public void setValorPago(BigDecimal valorPago) {
    this.valorPago = valorPago;
  }

  public BigDecimal getTroco() {
    return troco;
  }

  public void setTroco(BigDecimal troco) {
    this.troco = troco;
  }

  public List<ItemVenda> getItens() {
    return itens;
  }

  public void setItens(List<ItemVenda> itens) {
    this.itens = itens;
  }

  public List<Pagamento> getPagamentos() {
    return pagamentos;
  }

  public void setPagamentos(List<Pagamento> pagamentos) {
    this.pagamentos = pagamentos;
  }

  public Colaborador getColaborador() {
    return colaborador;
  }

  public void setColaborador(Colaborador colaborador) {
    this.colaborador = colaborador;
  }
}
