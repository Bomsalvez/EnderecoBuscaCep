package estagio.ti.totem.vamosdnovo.controller.dto;

import estagio.ti.totem.vamosdnovo.entity.Endereco;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.NotNull;


public class CasaFormDTO {
    private Long idCasa;
    @NotNull
    private String cepCasa;
    @NotNull
    private int numCasa;
    private ComplementoFormDTO complemento;

    public Long getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Long idCasa) {
        this.idCasa = idCasa;
    }

    public String getCepCasa() {
        return cepCasa;
    }

    public void setCepCasa(String cepCasa) {
        this.cepCasa = cepCasa;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public ComplementoFormDTO getComplemento() {
        return complemento;
    }

    public void setComplemento(ComplementoFormDTO complemento) {
        this.complemento = complemento;
    }
}
