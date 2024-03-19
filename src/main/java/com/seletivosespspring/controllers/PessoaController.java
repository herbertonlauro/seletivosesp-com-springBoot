package com.seletivosespspring.controllers;

import com.seletivosespspring.dto.PessoaDTO;
import com.seletivosespspring.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public List<PessoaDTO> listar(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "size", defaultValue = "10") int size) {
        return pessoaService.listarTodasPessoas(page, size);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> criar(@RequestBody PessoaDTO pessoaDTO){
        PessoaDTO pessoa = pessoaService.salvarPessoa(pessoaDTO);
        return ResponseEntity.created(URI.create("/pessoa")).body(pessoa);
    }
    @PutMapping("{id}")
    public PessoaDTO atualizar(){
    return null;
    }

}
