package estagio.ti.totem.vamosdnovo.controller.dto;

public class ComplementoFormDTO {
    private Long idComplemento;
    private String nomeComplemento;
    private CasaFormDTO casa;

    public Long getIdComplemento() {
        return idComplemento;
    }

    public void setIdComplemento(Long idComplemento) {
        this.idComplemento = idComplemento;
    }

    public String getNomeComplemento() {
        return nomeComplemento;
    }

    public void setNomeComplemento(String nomeComplemento) {
        this.nomeComplemento = nomeComplemento;
    }

    public CasaFormDTO getCasa() {
        return casa;
    }

    public void setCasa(CasaFormDTO casa) {
        this.casa = casa;
    }
}
