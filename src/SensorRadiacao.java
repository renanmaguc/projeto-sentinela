public class SensorRadiacao extends DispositivoMonitoramento {
    private double leituraAtual; // em QSv/h
    private double limiteSeguranca;

    public SensorRadiacao(String codigoIdentificador, String localizacao, double limiteSeguranca) {
        super(codigoIdentificador, localizacao);
        this.limiteSeguranca = limiteSeguranca;
        this.leituraAtual = 0.0;
    }

    public void registrarLeitura(double novaLeitura) {
        if (novaLeitura < 0) {
            throw new IllegalArgumentException("Erro: Leitura de radiação não pode ser negativa.");
        }
        if (novaLeitura > 1000000.0) {
            throw new IllegalArgumentException("Falha de sensor: Leitura acima de 1.000.000 QSv/h rejeitada.");
        }
        this.leituraAtual = novaLeitura;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }

    public double getLimiteSeguranca() {
        return limiteSeguranca;
    }

    public boolean detectouAnomalia() {
        return this.leituraAtual > this.limiteSeguranca;
    }
}