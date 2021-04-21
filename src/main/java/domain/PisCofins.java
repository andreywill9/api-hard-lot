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

}
