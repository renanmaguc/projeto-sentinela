import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("     INICIALIZANDO SISTEMA SENTINELA  ");
        System.out.println("==================================================\n");

        // 1. Instanciando as Zonas Restritas
        ZonaRestrita casaReator = new ZonaRestrita("ZNR-01", "Casa do Reator", 2.0, 5.0);
        ZonaRestrita patioCombustivel = new ZonaRestrita("ZNR-02", "Pátio de Armazenamento de Combustível Irradiado", 2.0, 5.0);

        // 2. Instanciando os Dispositivos de Monitoramento
        SensorRadiacao sensorReator = new SensorRadiacao("SR-01", "Interior da Casa do Reator", 5.0);
        SensorPerimetral sensorPerimetro = new SensorPerimetral("SP-01", "Perímetro Norte - Setor Alfa", "Setor Alfa");
        DronePatrulha drone = new DronePatrulha("DR-01", "Base Aérea Central", "Rota Externa Setor Norte");

        // 3. Configurando a Central de Monitoramento
        CentralMonitoramento central = new CentralMonitoramento();
        central.adicionarDispositivo(sensorReator);
        central.adicionarDispositivo(sensorPerimetro);
        central.adicionarDispositivo(drone);

        // CENÁRIO 1: Rotina Normal
        
        System.out.println("--- [CENÁRIO 1] ROTINA NORMAL ---");
        sensorReator.registrarLeitura(0.2); // Leitura segura
        sensorPerimetro.simularViolacao(false);
        
        List<AlertaSeguranca> alertasC1 = central.analisarLeituras(casaReator, patioCombustivel);
        System.out.println("Estado da Zona: " + casaReator.getDescricao() + " | Radiação: " + casaReator.getNivelRadiacaoAtual() + " QSv/h | Risco: " + casaReator.classificarRisco());
        System.out.println("Total de alertas gerados: " + alertasC1.size() + "\n");

        // CENÁRIO 2: Pico de Radiação

        System.out.println("--- [CENÁRIO 2] PICO DE RADIAÇÃO ---");
        sensorReator.registrarLeitura(4.7); // Ultrapassa limiar
        
        List<AlertaSeguranca> alertasC2 = central.analisarLeituras(casaReator, patioCombustivel);
        System.out.println("Estado da Zona: " + casaReator.getDescricao() + " | Radiação: " + casaReator.getNivelRadiacaoAtual() + " QSv/h | Risco: " + casaReator.classificarRisco());
        for (AlertaSeguranca alerta : alertasC2) {
            alerta.exibirAlerta();
        }
        System.out.println();

        // CENÁRIO 3: Acesso Indevido

        System.out.println("--- [CENÁRIO 3] ACESSO INDEVIDO ---");
        sensorReator.registrarLeitura(0.2); // Reseta a radiação para o normal
        sensorPerimetro.simularViolacao(true); // Cerca violada
        drone.executarPatrulha();
        drone.realizarVarreduraVisaoComputacional("Veículo não identificado parado na zona de exclusão perimetral.");

        List<AlertaSeguranca> alertasC3 = central.analisarLeituras(casaReator, patioCombustivel);
        for (AlertaSeguranca alerta : alertasC3) {
            alerta.exibirAlerta();
        }

        System.out.println("\n==================================================");
        System.out.println("   EXECUÇÃO DO SENTINELA CONCLUÍDA COM SUCESSO");
        System.out.println("==================================================");
    }
}