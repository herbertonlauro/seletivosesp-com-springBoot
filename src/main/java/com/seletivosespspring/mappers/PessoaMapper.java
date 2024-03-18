package com.seletivosespspring.mappers;

import com.seletivosespspring.dto.PessoaDto;
import com.seletivosespspring.model.Pessoa;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PessoaMapper {
    Pessoa toEntity(PessoaDto pessoaDto);

    PessoaDto toDto(Pessoa pessoa);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Pessoa partialUpdate(PessoaDto pessoaDto, @MappingTarget Pessoa pessoa);
}