import java.util.*;

public class Usuario {
    private String nome;
    private String email;
    private String cidade;
    private List<Evento> eventosConfirmados;

    public Usuario(String nome, String email, String cidade) {
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
        this.eventosConfirmados = new ArrayList<>();
    }

    public void confirmarEvento(Evento evento) {
        eventosConfirmados.add(evento);
    }

    public void cancelarEvento(Evento evento) {
        eventosConfirmados.remove(evento);
    }

    public List<Evento> getEventosConfirmados() {
        return eventosConfirmados;
    }

    @Override
    public String toString() {
        return nome + " - " + email + " - " + cidade;
    }
}
