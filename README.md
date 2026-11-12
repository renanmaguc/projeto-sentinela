# Projeto SENTINELA

Sistema de monitoramento em tempo real para instalações nucleares, desenvolvido em Java, utilizando sensores, drones com visão computacional e Inteligência Artificial (motor de regras) para garantir a segurança física e identificar situações de risco e acessos indevidos.

---

## Sobre o Projeto
O **SENTINELA** é um protótipo em console (Terminal) que simula o ecossistema de segurança de uma usina nuclear. Ele modela zonas restritas, dispositivos de monitoramento polimórficos e processa leituras críticas através de uma central analítica.

---

## Estrutura de Classes
O sistema é composto pelas seguintes classes principais:
1. **`DispositivoMonitoramento`**: Superclasse abstrata/base para todos os hardwares de monitoramento.
2. **`SensorRadiacao`**: Dispositivo especializado em medir os níveis radioativos em `QSv/h`.
3. **`SensorPerimetral`**: Dispositivo responsável por monitorar cercas e detectar violações físicas por setor.
4. **`DronePatrulha`**: Dispositivo aéreo que realiza patrulhas, consome bateria e simula captura de imagens por visão computacional/IA.
5. **`ZonaRestrita`**: Modela os locais monitorados (ex: *Casa do Reator*, *Pátio de Combustível*), controlando seus limites e classificando o risco (`NORMAL`, `ATENCAO`, `CRITICO`).
6. **`AlertaSeguranca`**: Objeto gerado pela central ao identificar anomalias, vinculando o dispositivo de origem e a zona afetada.
7. **`CentralMonitoramento`**: O motor de regras do sistema que varre os dispositivos e emite os alertas de segurança.
8. **`Main`**: Classe de execução que demonstra os três cenários obrigatórios exigidos pela sprint.

---

## Cenários Obrigatórios Demonstrados
O sistema executa sequencialmente três cenários de simulação no console:
1. **Rotina Normal**: Leituras dentro da normalidade, perímetro íntegro e zero alertas.
2. **Pico de Radiação**: Uma zona ultrapassa o limiar de segurança e a central dispara um alerta crítico/de atenção.
3. **Acesso Indevido**: Violação detectada na cerca perimetral, envio do drone e confirmação visual de veículo não identificado por IA.

---

## Como Executar o Projeto

1. Certifique-se de ter o **Java JDK** instalado em sua máquina.
2. Clone o repositório ou abra a pasta do projeto no seu ambiente de desenvolvimento.
3. Compile e execute a classe principal **`Main.java`**:
   ```bash
   javac Main.java
   java Main