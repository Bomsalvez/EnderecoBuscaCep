package estagio.ti.totem.vamosdnovo.config.exception;

public class ErrorDTO {
    private String error;
    private String propriedade;

    public ErrorDTO(String error) {
        this.error = error;
    }

    public ErrorDTO(String error, String propriedade) {
        this.error = error;
        this.propriedade = propriedade;
    }

    public String getError() {
        return error;
    }

    public String getPropriedade() {
        return propriedade;
    }
}
