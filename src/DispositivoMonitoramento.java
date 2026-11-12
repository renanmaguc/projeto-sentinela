public abstract class DispositivoMonitoramento {
    private String codigoIdentificador;
    private String localizacao;
    private boolean emOperacao;

    public DispositivoMonitoramento(String codigoIdentificador, String localizacao) {
        if (codigoIdentificador == null || codigoIdentificador.trim().isEmpty()) {
            throw new IllegalArgumentException("O código identificador não pode ser vazio.");
        }
        this.codigoIdentificador = codigoIdentificador;
        this.localizacao = localizacao;
        this.emOperacao = true;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public boolean isEmOperacao() {
        return emOperacao;
    }

    public void setEmOperacao(boolean emOperacao) {
        this.emOperacao = emOperacao;
    }
}