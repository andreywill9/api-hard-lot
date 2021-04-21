package domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class ObjetoDominio {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  Long id;

  @CreationTimestamp
  @Temporal(TemporalType.TIMESTAMP)
  Date inclusao;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getInclusao() {
    return inclusao;
  }

  public void setInclusao(Date inclusao) {
    this.inclusao = inclusao;
  }
}
