import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaEventos sistema = new SistemaEventos();

        System.out.println("Bem-vindo ao sistema de eventos!");
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();

        Usuario usuario = new Usuario(nome, email, cidade);

        int opcao;
        do {
            System.out.println("\n1. Criar evento");
            System.out.println("2. Listar eventos");
            System.out.println("3. Participar de evento");
            System.out.println("4. Meus eventos confirmados");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String enome = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.print("Data e hora (yyyy-MM-ddTHH:mm): ");
                    String dataHoraStr = sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();
                    LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr);
                    Evento evento = new Evento(enome, endereco, categoria, dataHora, descricao);
                    sistema.adicionarEvento(evento);
                    break;
                case 2:
                    sistema.listarEventosOrdenados();
                    break;
                case 3:
                    sistema.listarEventosOrdenados();
                    System.out.print("Digite o nome do evento que deseja participar: ");
                    String nomeEvento = sc.nextLine();
                    for (Evento e : sistema.getEventos()) {
                        if (e.toString().contains(nomeEvento)) {
                            usuario.confirmarEvento(e);
                            System.out.println("Você confirmou participação em: " + e);
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Seus eventos confirmados:");
                    for (Evento e : usuario.getEventosConfirmados()) {
                        System.out.println(e);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
}

