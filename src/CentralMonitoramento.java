import java.util.ArrayList;
import java.util.List;

public class CentralMonitoramento {
    private List<DispositivoMonitoramento> dispositivos;

    public CentralMonitoramento() {
        this.dispositivos = new ArrayList<>();
    }

    public void adicionarDispositivo(DispositivoMonitoramento dispositivo) {
        this.dispositivos.add(dispositivo);
    }

   public List<AlertaSeguranca> analisarLeituras(ZonaRestrita casaReator, ZonaRestrita patioCombustivel) {
        List<AlertaSeguranca> alertasGerados = new ArrayList<>();

        for (DispositivoMonitoramento disp : dispositivos) {
            if (disp instanceof SensorRadiacao) {
                SensorRadiacao sr = (SensorRadiacao) disp;
                
                // Define qual zona o sensor pertence com base no código dele
                ZonaRestrita zonaAlvo = sr.getCodigoIdentificador().equals("SR-01") ? casaReator : patioCombustivel;
                
                if (zonaAlvo != null) {
                    // Atualiza a radiação na zona correta
                    zonaAlvo.registrarLeituraRadiacao(sr.getLeituraAtual());
                    String risco = zonaAlvo.classificarRisco();

                    if (!risco.equals("NORMAL")) {
                        alertasGerados.add(new AlertaSeguranca(
                            sr, 
                            zonaAlvo, 
                            risco, 
                            "Nível de radiação detectado de " + sr.getLeituraAtual() + " QSv/h."
                        ));
                    }
                }
            } else if (disp instanceof SensorPerimetral) {
                SensorPerimetral sp = (SensorPerimetral) disp;
                if (sp.isViolacaoDetectada()) {
                    alertasGerados.add(new AlertaSeguranca(
                        sp, 
                        null, 
                        "CRITICO", 
                        "Violação física detectada na cerca do setor: " + sp.getSetorVigiado()
                    ));
                }
            } else if (disp instanceof DronePatrulha) {
                DronePatrulha dp = (DronePatrulha) disp;
                if (dp.isEmMissao() && dp.getResultadoVisaoComputacional().contains("Veículo")) {
                    alertasGerados.add(new AlertaSeguranca(
                        dp, 
                        null, 
                        "CRITICO", 
                        "Confirmação visual por IA: " + dp.getResultadoVisaoComputacional()
                    ));
                }
            }
        }
        return alertasGerados;
    }
}