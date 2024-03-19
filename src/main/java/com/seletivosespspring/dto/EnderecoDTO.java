package com.seletivosespspring.dto;

import com.seletivosespspring.models.Pessoa;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.seletivosespspring.models.Endereco}
 */
@Value
public class EnderecoDTO implements Serializable {
    Long id;
    Integer numero;
    Pessoa idpessoa;
    String bairro;
    String cep;
    String cidade;
    String estado;
    String logradouro;
}