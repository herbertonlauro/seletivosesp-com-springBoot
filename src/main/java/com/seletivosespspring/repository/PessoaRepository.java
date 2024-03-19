package com.seletivosespspring.repository;

import com.seletivosespspring.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    List<Pessoa> findByNomeContaining(String nome);

    Optional<Pessoa> findByCpfContaining(String cpf);

    @Query("SELECT p FROM Pessoa p WHERE (:nome IS NULL OR UPPER(p.nome) LIKE CONCAT('%', UPPER(:nome), '%'))" +
            " OR (:mae IS NULL OR UPPER(p.mae) LIKE CONCAT('%', UPPER(:mae), '%'))" +
            " OR (:nascimento IS NULL OR p.nascimento = :nascimento)")
    List<Pessoa> filtrarNomeMaeNascimento(@Param("nome") String nome,
                                          @Param("mae") String mae,
                                          @Param("nascimento") LocalDate nascimento);
}

