package com.store.modelo.repositorio.dao;


import com.store.modelo.repositorio.entidade.Filial;
import com.store.modelo.repositorio.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Interface representa a camada de persistência da entidade Produto. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface InterfaceProdutoDao extends JpaRepository<Produto, String> {

    @Query("Select p from Produto p where p.nome = :nome")
    public List<Produto> listaProdutoNome(@Param("nome") String nome);

    @Query("Select p from Produto p where p.codigo = :codigo")
    public List<Produto> listaProdutoCodigo(@Param("codigo") Long codigo);

    @Query("Select p from Produto p where p.filial.cnpj = :cnpj")
    public List<Produto> listaProdutoFilial(@Param("cnpj") String cnpj);
}
