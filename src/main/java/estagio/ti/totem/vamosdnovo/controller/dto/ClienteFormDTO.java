package estagio.ti.totem.vamosdnovo.controller.dto;

import estagio.ti.totem.vamosdnovo.entity.Casa;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

public class ClienteFormDTO {
    private Long idCliente;
    @NotNull
    private String nomeClinete;
    @NotNull
    private String cpfClinete;
    @NotNull
    private Date dataNascimento;
    @NotNull
    private Set<Casa> casas;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeClinete() {
        return nomeClinete;
    }

    public void setNomeClinete(String nomeClinete) {
        this.nomeClinete = nomeClinete;
    }

    public String getCpfClinete() {
        return cpfClinete;
    }

    public void setCpfClinete(String cpfClinete) {
        this.cpfClinete = cpfClinete;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Set<Casa> getCasas() {
        return casas;
    }

    public void setCasas(Set<Casa> casas) {
        this.casas = casas;
    }
}
