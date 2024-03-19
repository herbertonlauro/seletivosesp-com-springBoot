package com.seletivosespspring.mappers;

import com.seletivosespspring.dto.EnderecoDTO;
import com.seletivosespspring.models.Endereco;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface EnderecoMapper {
    Endereco toEntity(EnderecoDTO enderecoDto);

    EnderecoDTO toDTO(Endereco endereco);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Endereco partialUpdate(EnderecoDTO enderecoDto, @org.mapstruct.MappingTarget Endereco endereco);
}