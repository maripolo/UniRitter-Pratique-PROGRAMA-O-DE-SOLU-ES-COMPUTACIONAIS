// Arquivo: Evento.java
import java.time.LocalDateTime;

public class Evento {
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime dataHora;
    private String descricao;

    public Evento(String nome, String endereco, String categoria, LocalDateTime dataHora, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.dataHora = dataHora;
        this.descricao = descricao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public boolean estaOcorrendo() {
        LocalDateTime agora = LocalDateTime.now();
        return dataHora.isBefore(agora.plusHours(1)) && dataHora.isAfter(agora.minusHours(1));
    }

    public boolean jaOcorreu() {
        return dataHora.isBefore(LocalDateTime.now());
    }

    @Override
    public String toString() {
        return nome + " | " + categoria + " | " + dataHora + " | " + endereco + " | " + descricao;
    }
}
