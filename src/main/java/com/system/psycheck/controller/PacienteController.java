package com.system.psycheck.controller;

import com.system.psycheck.model.dto.DadosAtualizacaoPaciente;
import com.system.psycheck.model.dto.DadosCadastroPaciente;
import com.system.psycheck.model.dto.DadosListagemPessoas;
import com.system.psycheck.model.entity.Genero;
import com.system.psycheck.model.entity.Paciente;
import com.system.psycheck.model.entity.PessoaFisica;
import com.system.psycheck.model.repository.GeneroRepository;
import com.system.psycheck.model.repository.PacienteRepository;
import com.system.psycheck.model.repository.PessoaFisicaRepository;
import com.system.psycheck.model.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        Paciente paciente = new Paciente(dados);
        pacienteRepository.save (paciente);
        System.out.println(paciente);
    }

    @GetMapping("/pessoas")
    public Page<DadosListagemPessoas> listar(@PageableDefault() Pageable paginacao) {
        return pessoaRepository.findAll(paginacao).map(DadosListagemPessoas :: new);
    }

    @GetMapping("/{id}")
    public Page<DadosListagemPessoas> DadosPaciente(@PageableDefault() Pageable paginacao) {
        return pessoaRepository.findAll(paginacao).map(DadosListagemPessoas :: new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoPaciente dados) {
        Paciente paciente = new Paciente();
        paciente = pacienteRepository.getReferenceById(dados.codPaciente());
        paciente.atualizar(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        Paciente paciente = new Paciente();
        paciente = pacienteRepository.getReferenceById(id);
        paciente.excluir();
    }

}
