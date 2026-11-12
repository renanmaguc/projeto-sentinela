public class DronePatrulha extends DispositivoMonitoramento {
    private String rotaPatrulha;
    private int bateriaPercentual;
    private boolean emMissao;
    private String resultadoVisaoComputacional;

    public DronePatrulha(String codigoIdentificador, String localizacao, String rotaPatrulha) {
        super(codigoIdentificador, localizacao);
        this.rotaPatrulha = rotaPatrulha;
        this.bateriaPercentual = 100;
        this.emMissao = false;
        this.resultadoVisaoComputacional = "Nenhuma ameaça visualizada.";
    }

    public void executarPatrulha() {
        this.emMissao = true;
        this.bateriaPercentual -= 5;
    }

    public void realizarVarreduraVisaoComputacional(String analise) {
        this.resultadoVisaoComputacional = analise;
    }

    public String getResultadoVisaoComputacional() {
        return resultadoVisaoComputacional;
    }

    public boolean isEmMissao() {
        return emMissao;
    }

    public int getBateriaPercentual() {
        return bateriaPercentual;
    }

    public String getRotaPatrulha() {
        return rotaPatrulha;
    }
}