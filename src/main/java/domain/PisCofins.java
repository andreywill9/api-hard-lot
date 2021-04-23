package domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "pis_cofins")
public class PisCofins extends ObjetoDominio{

  private String descricao;

  @Column(name = "aliquota_pis")
  private BigDecimal aliquotaPis;

  @Column(name = "aliquota_cofins")
  private BigDecimal aliquotaCofins;

  @OneToMany(mappedBy = "pisCofins")
  private List<Produto> produtos;

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getAliquotaPis() {
    return aliquotaPis;
  }

  public void setAliquotaPis(BigDecimal aliquotaPis) {
    this.aliquotaPis = aliquotaPis;
  }

  public BigDecimal getAliquotaCofins() {
    return aliquotaCofins;
  }

  public void setAliquotaCofins(BigDecimal aliquotaCofins) {
    this.aliquotaCofins = aliquotaCofins;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }
}
