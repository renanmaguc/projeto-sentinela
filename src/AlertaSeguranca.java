public class AlertaSeguranca {
    private DispositivoMonitoramento sensorOrigem; // Associação (TEM-UM)
    private ZonaRestrita zonaAfetada;             // Associação (TEM-UM)
    private String severidade;                   // NORMAL, ATENCAO, CRITICO
    private String mensagem;

    public AlertaSeguranca(DispositivoMonitoramento sensorOrigem, ZonaRestrita zonaAfetada, String severidade, String mensagem) {
        this.sensorOrigem = sensorOrigem;
        this.zonaAfetada = zonaAfetada;
        this.severidade = severidade;
        this.mensagem = mensagem;
    }

    public void exibirAlerta() {
        System.out.println("--------------------------------------------------");
        System.out.println("ALERTA SENTINELA [" + severidade + "]");
        System.out.println("Localização/Zona: " + (zonaAfetada != null ? zonaAfetada.getDescricao() : "Perímetro Externo"));
        System.out.println("Dispositivo Origem: " + sensorOrigem.getCodigoIdentificador() + " (" + sensorOrigem.getLocalizacao() + ")");
        System.out.println("Mensagem: " + mensagem);
        System.out.println("--------------------------------------------------");
    }

    public DispositivoMonitoramento getSensorOrigem() {
        return sensorOrigem;
    }

    public ZonaRestrita getZonaAfetada() {
        return zonaAfetada;
    }

    public String getSeveridade() {
        return severidade;
    }
}