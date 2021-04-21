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

}
