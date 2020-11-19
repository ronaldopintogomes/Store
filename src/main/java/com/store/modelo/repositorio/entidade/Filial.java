package com.store.modelo.repositorio.entidade;

import com.store.modelo.enumeracao.EnumTipoFilial;
import lombok.Data;
import lombok.Singular;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "FILIAL")
@SequenceGenerator(name = "FILIAL_SEQ", sequenceName = "FILIAL_SEQ", allocationSize = 1)
public class Filial extends GenericEntity<Long> {

    @Id
    @GeneratedValue(generator = "FILIAL_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String razaoSocial;

    @CNPJ
    @Column
    private String cnpj;

    @Column
    private String endereco;

    @Column
    private EnumTipoFilial tipoFilial;

    @Column
    @Singular
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="produto_id", referencedColumnName = "id")
    private List<Produto> produtos;
}