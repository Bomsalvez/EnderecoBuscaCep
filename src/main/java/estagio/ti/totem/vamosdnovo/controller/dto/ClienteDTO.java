package estagio.ti.totem.vamosdnovo.controller.dto;

import estagio.ti.totem.vamosdnovo.entity.Casa;
import java.util.Date;
import java.util.Set;

public class ClienteDTO {
    private Long idCliente;

    private String nomeClinete;

    private String cpfClinete;

    private Date dataNascimento;

    private Set<CasaDTO> casas;

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

    public Set<CasaDTO> getCasas() {
        return casas;
    }

    public void setCasas(Set<CasaDTO> casas) {
        this.casas = casas;
    }
}
