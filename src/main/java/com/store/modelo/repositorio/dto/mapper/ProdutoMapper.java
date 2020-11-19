package com.store.modelo.repositorio.dto.mapper;

import com.store.modelo.repositorio.dto.ProdutoDto;
import com.store.modelo.repositorio.entidade.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Interface respons?vel por implementar MapperStruct no mapeamento entre Produto e ProdutoDto.
 */
@Mapper
public interface ProdutoMapper extends GenericMapper<Produto, ProdutoDto> {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

}
