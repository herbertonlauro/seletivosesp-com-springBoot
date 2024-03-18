package com.seletivosespspring.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.seletivosespspring.model.Pessoa}
 */
@Value
public class PessoaDto implements Serializable {

    Long id;
    LocalDate cadastradoem;
    LocalDate nascimento;
    String cpf;
    String email;
    String mae;
    String pai;
    String rg;
    String telefone;
}