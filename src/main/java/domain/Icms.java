package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "icms")
public class Icms extends ObjetoDominio{

  private String descricao;

  @Column(name = "aliquota_pis")
  private BigDecimal aliquota;

  @OneToMany(mappedBy = "icms")
  private List<Produto> produtos;

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getAliquota() {
    return aliquota;
  }

  public void setAliquota(BigDecimal aliquota) {
    this.aliquota = aliquota;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }
}
