package com.seletivosespspring.mappers;

import com.seletivosespspring.dto.PessoaDTO;
import com.seletivosespspring.models.Pessoa;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PessoaMapper {
    Pessoa toEntity(PessoaDTO pessoaDto);

    PessoaDTO toDTO(Pessoa pessoa);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pessoa partialUpdate(PessoaDTO pessoaDto, @MappingTarget Pessoa pessoa);
}