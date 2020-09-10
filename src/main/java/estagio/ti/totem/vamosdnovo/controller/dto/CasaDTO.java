package estagio.ti.totem.vamosdnovo.controller.dto;

import estagio.ti.totem.vamosdnovo.entity.Complemento;
import estagio.ti.totem.vamosdnovo.entity.Endereco;
import org.springframework.web.client.RestTemplate;


public class CasaDTO {
    private Long idCasa;

    private Endereco cepCasa;

    private int numCasa;

    private ComplementoDTO complemento;

    public Long getIdCasa() {
        return idCasa;
    }

    public void setIdCasa(Long idCasa) {
        this.idCasa = idCasa;
    }

    public Endereco getCepCasa() {
        return cepCasa;
    }

    public void setCepCasa(String cepCasa) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://viacep.com.br/ws/" + cepCasa + "/json";
        Endereco cep = restTemplate.getForObject(url, Endereco.class);
        this.cepCasa = cep;
    }

    public int getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(int numCasa) {
        this.numCasa = numCasa;
    }

    public ComplementoDTO getComplemento() {
        return complemento;
    }

    public void setComplemento(ComplementoDTO complemento) {
        this.complemento = complemento;
    }
}
