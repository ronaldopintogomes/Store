package com.store.modelo.repositorio.entidade;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "PRODUTO")
public class Produto extends GenericEntity<String>{

    @Id
    private String id;

    @Column
    private String nome;

    @Column
    private Long codigo;

    @Column
    @OneToOne(mappedBy = "produtos", orphanRemoval = true)
    private Filial filial;
}