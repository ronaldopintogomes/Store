package com.store.modelo.repositorio.dao;

import com.store.modelo.repositorio.entidade.Filial;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface representa a camada de persistência da entidade Filial. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface InterfaceFilialDao extends JpaRepository<Filial, Long> {

}
