package com.seletivosespspring.repository;

import com.seletivosespspring.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContaining(String nome);

    @Query("SELECT p FROM Pessoa p WHERE (:nome IS NULL OR UPPER(p.nome) LIKE CONCAT('%', UPPER(:nome), '%'))" +
            " OR (:mae IS NULL OR UPPER(p.mae) LIKE CONCAT('%', UPPER(:mae), '%'))" +
            " OR (:nascimento IS NULL OR p.nascimento = :nascimento)")
    List<Pessoa> filtrarNomeMaeNascimento(@Param("nome") String nome,
                                          @Param("mae") String mae,
                                          @Param("nascimento") LocalDate nascimento);
}

