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

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "PESSOA",referencedColumnName = "COD_PESSOA", foreignKey = @ForeignKey(name = "fk_paciente_pessoa"))
    private PessoaFisica pessoa;

    public Paciente() {
    }

    public Paciente(Long codPaciente, String historico, String numSeguroSaude, PessoaFisica pessoaFisica) {
        this.codPaciente = codPaciente;
        this.historico = historico;
        this.numSeguroSaude = numSeguroSaude;
        this.pessoa = pessoaFisica;
    }

    public Paciente(DadosCadastroPaciente dados) {
        this.historico = dados.historico();
        this.numSeguroSaude = dados.numSeguroSaude();
        this.pessoa = dados.pessoa();
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

    public PessoaFisica getPessoa() {
        return pessoa;
    }

    public Paciente setPessoa(PessoaFisica pessoaFisica) {
        this.pessoa = pessoaFisica;
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
            this.pessoa.setNome(dados.nome());
        }
        if (dados.email() != null) {
            this.pessoa.setEmail(dados.email());
        }
        if (dados.softDelete() != null) {
            this.pessoa.setSoftDelete(dados.softDelete());
        }
        if (dados.usuario() != null) {
            this.pessoa.setUsuario(dados.usuario());
        }
        if (dados.senha() != null) {
            this.pessoa.setSenha(dados.senha());
        }
        if (dados.genero() != null) {
            this.pessoa.setGenero(dados.genero());
        }
        if (dados.dataNasc() != null) {
            this.pessoa.setDataNasc(dados.dataNasc());
        }
        if (dados.cpf() != null) {
            this.pessoa.setCpf(dados.cpf());
        }
    }


    public void excluir() {
        this.pessoa.setSoftDelete(true);
    }
}
