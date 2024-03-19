package com.seletivosespspring.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.seletivosespspring.models.Pessoa}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO implements Serializable {

    Long id;
    LocalDate cadastradoem;
    LocalDate nascimento;
    String nome;
    String cpf;
    String email;
    String mae;
    String pai;
    String rg;
    String telefone;
}