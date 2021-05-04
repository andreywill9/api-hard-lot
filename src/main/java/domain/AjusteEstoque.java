package domain;

import domain.enums.StatusAjuste;
import domain.enums.TipoAjuste;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "ajuste_estoque")
public class AjusteEstoque extends ObjetoDominio {

  private String descricao;

  private String motivo;

  // TODO COLABORADOR

  @Column(name = "tipo_ajuste")
  private TipoAjuste tipoAjuste;

  private StatusAjuste status;

  @OneToMany(mappedBy = "ajuste")
  private List<ItemAjuste> itens;

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public TipoAjuste getTipoAjuste() {
    return tipoAjuste;
  }

  public void setTipoAjuste(TipoAjuste tipoAjuste) {
    this.tipoAjuste = tipoAjuste;
  }

  public StatusAjuste getStatus() {
    return status;
  }

  public void setStatus(StatusAjuste status) {
    this.status = status;
  }

  public List<ItemAjuste> getItens() {
    return itens;
  }

  public void setItens(List<ItemAjuste> itens) {
    this.itens = itens;
  }
}
