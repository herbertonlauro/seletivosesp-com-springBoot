package com.seletivosespspring.services;

import com.seletivosespspring.dto.PessoaDTO;
import com.seletivosespspring.mappers.PessoaMapper;
import com.seletivosespspring.models.Pessoa;
import com.seletivosespspring.repository.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaMapper pessoaMapper;

    public List<PessoaDTO> listarTodasPessoas(int page, int size) {
        List<Pessoa> pessoas = pessoaRepository.findAll(PageRequest.of(page, size)).getContent();
        return pessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public PessoaDTO salvarPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        pessoaRepository.save(pessoa);
        return pessoaMapper.toDTO(pessoa);
    }

    @Transactional
    public PessoaDTO atualizarPessoa(Long id, PessoaDTO pessoaDTO) throws ChangeSetPersister.NotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        pessoaMapper.partialUpdate(pessoaDTO, pessoa);
        return pessoaMapper.toDTO(pessoa);
    }
    @Transactional
    public void deletarPessoa(Long id) throws ChangeSetPersister.NotFoundException {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        pessoaRepository.delete(pessoa);
    }

}
