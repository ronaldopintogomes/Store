package com.store.servico.impl;

import com.store.modelo.repositorio.dao.InterfaceFilialDao;
import com.store.modelo.repositorio.entidade.Filial;
import com.store.servico.inter.AbstractGenericServicePersistence;
import com.store.servico.inter.InterfaceFilialService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class FilialService extends AbstractGenericServicePersistence<InterfaceFilialDao, Filial, Long> implements InterfaceFilialService {



}
