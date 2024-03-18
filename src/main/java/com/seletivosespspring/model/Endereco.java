package com.seletivosespspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "numero")
    private Integer numero;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idpessoa")
    private Pessoa idpessoa;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "logradouro")
    private String logradouro;

}