public class ZonaRestrita {
    private String identificador;
    private String descricao;
    private double nivelRadiacaoAtual; // em QSv/h
    private double limiteAtencao;
    private double limiteCritico;

    public ZonaRestrita(String identificador, String descricao, double limiteAtencao, double limiteCritico) {
        if (identificador == null || identificador.trim().isEmpty()) {
            throw new IllegalArgumentException("Identificador da zona não pode ser vazio.");
        }
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("Descrição da zona não pode ser vazia.");
        }
        this.identificador = identificador;
        this.descricao = descricao;
        this.nivelRadiacaoAtual = 0.0;
        this.limiteAtencao = limiteAtencao;
        this.limiteCritico = limiteCritico;
    }

    public void registrarLeituraRadiacao(double leitura) {
        if (leitura < 0.0) {
            throw new IllegalArgumentException("Radiação não pode ser negativa.");
        }
        if (leitura > 1000000.0) {
            throw new IllegalArgumentException("Leitura absurda rejeitada (> 1.000.000 QSv/h).");
        }
        this.nivelRadiacaoAtual = leitura;
    }

    public String classificarRisco() {
        if (this.nivelRadiacaoAtual >= this.limiteCritico) {
            return "CRITICO";
        } else if (this.nivelRadiacaoAtual >= this.limiteAtencao) {
            return "ATENCAO";
        } else {
            return "NORMAL";
        }
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getDescdescricao() {
        return descricao;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public double getNivelRadiacaoAtual() {
        return nivelRadiacaoAtual;
    }
}