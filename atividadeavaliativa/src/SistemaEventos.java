// Arquivo: SistemaEventos.java
import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaEventos {
    private List<Evento> eventos = new ArrayList<>();
    private final String arquivo = "events.data";

    public SistemaEventos() {
        carregarEventos();
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
        salvarEventos();
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void listarEventosOrdenados() {
        eventos.sort(Comparator.comparing(Evento::getDataHora));
        for (Evento e : eventos) {
            System.out.println(e + (e.estaOcorrendo() ? " [OCORRENDO AGORA]" : ""));
        }
    }

    private void salvarEventos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Evento e : eventos) {
                writer.write(e.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos.");
        }
    }

    private void carregarEventos() {
        // Aqui você pode expandir depois com parsing real do arquivo
        // Por enquanto, deixamos vazio como estrutura inicial
    }
}
