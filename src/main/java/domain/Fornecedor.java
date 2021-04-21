package domain;

import javax.persistence.*;
import java.util.List;

@Entity(name = "fornecedor")
public class Fornecedor extends ObjetoDominio {

  @Column(name = "razao_social")
  private String razaoSocial;

  @Column(name = "nome_fantasia")
  private String nomeFantasia;

  private String cnpj;

  private String telefone;

  private String email;

  @ManyToOne
  @JoinColumn(name = "endereco_id")
  private Endereco endereco;

  @ManyToMany(mappedBy = "fornecedores")
  private List<Produto> produtos;

}
