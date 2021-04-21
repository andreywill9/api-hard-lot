package domain;


import domain.enums.TipoPreco;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "preco")
public class Preco extends ObjetoDominio {

  private BigDecimal valor;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  private TipoPreco tipoPreco;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "inicio_promocao")
  private Date inicioPromocao;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "fim_promocao")
  private Date fimPromocao;

  public Preco() {}

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public TipoPreco getTipoPreco() {
    return tipoPreco;
  }

  public void setTipoPreco(TipoPreco tipoPreco) {
    this.tipoPreco = tipoPreco;
  }

  public Date getInicioPromocao() {
    return inicioPromocao;
  }

  public void setInicioPromocao(Date inicioPromocao) {
    this.inicioPromocao = inicioPromocao;
  }

  public Date getFimPromocao() {
    return fimPromocao;
  }

  public void setFimPromocao(Date fimPromocao) {
    this.fimPromocao = fimPromocao;
  }
}
