package com.seletivosespspring.mappers;

import com.seletivosespspring.dto.EnderecoDto;
import com.seletivosespspring.model.Endereco;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface EnderecoMapper {
    Endereco toEntity(EnderecoDto enderecoDto);

    EnderecoDto toDto(Endereco endereco);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Endereco partialUpdate(EnderecoDto enderecoDto, @org.mapstruct.MappingTarget Endereco endereco);
}