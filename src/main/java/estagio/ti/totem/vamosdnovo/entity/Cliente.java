package estagio.ti.totem.vamosdnovo.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String nomeClinete;

    private String cpfClinete;

    private Date dataNascimento;

    @ManyToMany
    @JoinTable(name = "tbl_casa_cliente",
            joinColumns = @JoinColumn(name = "fkCliente"),
            inverseJoinColumns = @JoinColumn(name = "fkCasa"))
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
        if (casas == null) {
            Collections.emptySet();
        }
        return casas;
    }

    public void setCasas(Casa casas) {
        if (this.casas == null) {
            this.casas = new HashSet<>();
        }
        this.casas.add(casas);
    }
}
