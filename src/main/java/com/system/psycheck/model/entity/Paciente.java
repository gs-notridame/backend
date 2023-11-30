package com.system.psycheck.model.entity;

import com.system.psycheck.model.dto.DadosAtualizacaoPaciente;
import com.system.psycheck.model.dto.DadosCadastroPaciente;
import com.system.psycheck.model.dto.DadosPaciente;
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
    @JoinColumn(name = "PESSOA", referencedColumnName = "COD_PESSOA", foreignKey = @ForeignKey(name = "fk_paciente_pessoa"))
    private PessoaFisica pessoa;

    public Paciente() {
    }

    public Paciente(DadosCadastroPaciente dados) {
        this.historico = dados.historico();
        this.numSeguroSaude = dados.numSeguroSaude();
        this.pessoa = dados.pessoa();
    }

    public Paciente(DadosPaciente dados) {
        this.codPaciente = dados.codPaciente();
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
        this.codPaciente = dados.codPaciente();
        this.historico = dados.historico();
        this.numSeguroSaude = dados.numSeguroSaude();
        this.pessoa = dados.pessoa();
    }

    public void excluir() {
        this.pessoa.setSoftDelete(true);
    }
}
