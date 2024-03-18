package com.seletivosespspring.dto;

import com.seletivosespspring.model.Pessoa;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.seletivosespspring.model.Endereco}
 */
@Value
public class EnderecoDto implements Serializable {
    Long id;
    Integer numero;
    Pessoa idpessoa;
    String bairro;
    String cep;
    String cidade;
    String estado;
    String logradouro;
}