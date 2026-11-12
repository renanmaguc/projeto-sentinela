public class SensorPerimetral extends DispositivoMonitoramento {
    private String setorVigiado;
    private boolean violacaoDetectada;

    public SensorPerimetral(String codigoIdentificador, String localizacao, String setorVigiado) {
        super(codigoIdentificador, localizacao);
        this.setorVigiado = setorVigiado;
        this.violacaoDetectada = false;
    }

    public void simularViolacao(boolean violacao) {
        this.violacaoDetectada = violacao;
    }

    public boolean isViolacaoDetectada() {
        return violacaoDetectada;
    }

    public String getSetorVigiado() {
        return setorVigiado;
    }
}