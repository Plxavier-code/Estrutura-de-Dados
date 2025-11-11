import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedStack<String> pilha = new LinkedStack<>(5); // capacidade 5

        int opcao;
        do {
            System.out.println("\n==== MENU PILHA ====");
            System.out.println("1 - Empilhar (push)");
            System.out.println("2 - Desempilhar (pop)");
            System.out.println("3 - Topo (peek)");
            System.out.println("4 - Atualizar topo (update)");
            System.out.println("5 - Imprimir pilha (print)");
            System.out.println("6 - Verificar se está vazia");
            System.out.println("7 - Verificar se está cheia");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para empilhar: ");
                        String valor = sc.nextLine();
                        pilha.push(valor);
                        System.out.println("Elemento empilhado com sucesso!");
                        break;

                    case 2:
                        System.out.println("Elemento removido: " + pilha.pop());
                        break;

                    case 3:
                        System.out.println("Topo da pilha: " + pilha.peek());
                        break;

                    case 4:
                        System.out.print("Digite o novo valor do topo: ");
                        String novo = sc.nextLine();
                        pilha.update(novo);
                        System.out.println("Topo atualizado!");
                        break;

                    case 5:
                        System.out.println("Pilha atual: " + pilha.print());
                        break;

                    case 6:
                        System.out.println(pilha.is_empty() ? "A pilha está vazia." : "A pilha contém elementos.");
                        break;

                    case 7:
                        System.out.println(pilha.is_full() ? "A pilha está cheia." : "A pilha ainda tem espaço.");
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);

        sc.close();
    }
}
