package com.store.modelo.repositorio.dto.mapper;

import com.store.modelo.repositorio.dto.FilialDto;
import com.store.modelo.repositorio.entidade.Filial;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Interface respons?vel por implementar MapperStruct no mapeamento entre Filial e FilialDto.
 */
@Mapper
public interface FilialMapper extends GenericMapper<Filial, FilialDto> {

    FilialMapper INSTANCE = Mappers.getMapper(FilialMapper.class);

}
