package estagio.ti.totem.vamosdnovo.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_casa")
public class Casa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCasa;

    private String cepCasa;

    private int numCasa;

    @OneToOne(mappedBy = "casa")
    private Complemento complemento;

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

    public Complemento getComplemento() {
        return complemento;
    }

    public void setComplemento(Complemento complemento) {
        this.complemento = complemento;
    }
}
