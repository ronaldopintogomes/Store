package com.store.modelo.repositorio.dto;

import com.store.modelo.enumeracao.EnumTipoFilial;
import com.store.modelo.repositorio.entidade.GenericEntity;
import lombok.Data;

@Data
public class FilialDto extends GenericEntity<Long> {

    private Long id;
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private EnumTipoFilial tipoFilial;

}
