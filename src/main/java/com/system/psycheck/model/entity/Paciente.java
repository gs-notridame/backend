package com.system.psycheck.model.entity;

import com.system.psycheck.model.dto.DadosAtualizacaoPaciente;
import com.system.psycheck.model.dto.DadosCadastroPaciente;
import jakarta.persistence.*;

@Table(name = "PACIENTE")
@Entity(name = "PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PACIENTE")
    @SequenceGenerator(name = "SQ_PACIENTE", sequenceName = "SQ_PACIENTE", allocationSize = 1, initialValue = 1)
    @Column(name = "COD_PACIENTE")
    private Long codPaciente;
    private String historico;
    private String numSeguroSaude;

    @OneToOne
    @JoinColumn(name = "COD_PESSOA")
    private PessoaFisica pessoaFisica;

    public Paciente() {
    }

    public Paciente(Long codPaciente, String historico, String numSeguroSaude, PessoaFisica pessoaFisica) {
        this.codPaciente = codPaciente;
        this.historico = historico;
        this.numSeguroSaude = numSeguroSaude;
        this.pessoaFisica = pessoaFisica;
    }

    public Paciente(DadosCadastroPaciente dados) {
        this.historico = dados.historico();
        this.numSeguroSaude = dados.numSeguroSaude();

        this.pessoaFisica = new PessoaFisica(
                dados.nome(),
                dados.email(),
                dados.softDelete(),
                dados.usuario(),
                dados.senha(),
                dados.dataNasc(),
                dados.cpf(),
                dados.genero()
        );
    }

    public Long getCodPaciente() {
        return codPaciente;
    }

    public Paciente setCodPaciente(Long codPaciente) {
        this.codPaciente = codPaciente;
        return this;
    }

    public String getHistorico() {
        return historico;
    }

    public Paciente setHistorico(String historico) {
        this.historico = historico;
        return this;
    }

    public String getNumSeguroSaude() {
        return numSeguroSaude;
    }

    public Paciente setNumSeguroSaude(String numSeguroSaude) {
        this.numSeguroSaude = numSeguroSaude;
        return this;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public Paciente setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
        return this;
    }

    public void atualizar(DadosAtualizacaoPaciente dados) {
        if (dados.historico() != null) {
            this.historico = dados.historico();
        }
        if (dados.numSeguroSaude() != null) {
            this.numSeguroSaude = dados.numSeguroSaude();
        }
        if (dados.nome() != null) {
            this.pessoaFisica.setNome(dados.nome());
        }
        if (dados.email() != null) {
            this.pessoaFisica.setEmail(dados.email());
        }
        if (dados.softDelete() != null) {
            this.pessoaFisica.setSoftDelete(dados.softDelete());
        }
        if (dados.usuario() != null) {
            this.pessoaFisica.setUsuario(dados.usuario());
        }
        if (dados.senha() != null) {
            this.pessoaFisica.setSenha(dados.senha());
        }
        if (dados.genero() != null) {
            this.pessoaFisica.setGenero(dados.genero());
        }
        if (dados.dataNasc() != null) {
            this.pessoaFisica.setDataNasc(dados.dataNasc());
        }
        if (dados.cpf() != null) {
            this.pessoaFisica.setCpf(dados.cpf());
        }
    }


    public void excluir() {
        this.pessoaFisica.setSoftDelete(true);
    }
}
