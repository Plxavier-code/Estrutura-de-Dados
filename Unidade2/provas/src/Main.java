import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedStack<String> pilha = new LinkedStack<>(5);
        LinkedQueue<String> fila = new LinkedQueue<>(5);

        int estruturaEscolhida;
        do {
            System.out.println("\n==== MENU PRINCIPAL ====");
            System.out.println("1 - Testar PILHA");
            System.out.println("2 - Testar FILA");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            estruturaEscolhida = sc.nextInt();
            sc.nextLine();

            switch (estruturaEscolhida) {
                case 1:
                    testarPilha(sc, pilha);
                    break;
                case 2:
                    testarFila(sc, fila);
                    break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (estruturaEscolhida != 0);

        sc.close();
    }

    // ============================
    // ===== MENU PARA PILHA =====
    // ============================
    private static void testarPilha(Scanner sc, LinkedStack<String> pilha) {
        int opcao;
        do {
            System.out.println("\n==== MENU PILHA ====");
            System.out.println("1 - Empilhar (push)");
            System.out.println("2 - Desempilhar (pop)");
            System.out.println("3 - Topo (peek)");
            System.out.println("4 - Atualizar topo (update)");
            System.out.println("5 - Imprimir pilha (print)");
            System.out.println("6 - Está vazia?");
            System.out.println("7 - Está cheia?");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para empilhar: ");
                        String valor = sc.nextLine();
                        pilha.push(valor);
                        System.out.println("Elemento empilhado!");
                        break;
                    case 2:
                        System.out.println("Elemento removido: " + pilha.pop());
                        break;
                    case 3:
                        System.out.println("Topo da pilha: " + pilha.peek());
                        break;
                    case 4:
                        System.out.print("Digite o novo valor do topo: ");
                        pilha.update(sc.nextLine());
                        System.out.println("Topo atualizado!");
                        break;
                    case 5:
                        System.out.println("Pilha: " + pilha.print());
                        break;
                    case 6:
                        System.out.println(pilha.is_empty() ? "A pilha está vazia." : "A pilha contém elementos.");
                        break;
                    case 7:
                        System.out.println(pilha.is_full() ? "A pilha está cheia." : "A pilha ainda tem espaço.");
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }

    // ============================
    // ===== MENU PARA FILA ======
    // ============================
    private static void testarFila(Scanner sc, LinkedQueue<String> fila) {
        int opcao;
        do {
            System.out.println("\n==== MENU FILA ====");
            System.out.println("1 - Enfileirar (enqueue)");
            System.out.println("2 - Desenfileirar (dequeue)");
            System.out.println("3 - Espiar primeiro (peek)");
            System.out.println("4 - Atualizar último (update)");
            System.out.println("5 - Imprimir fila (print)");
            System.out.println("6 - Está vazia?");
            System.out.println("7 - Está cheia?");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para enfileirar: ");
                        fila.enqueue(sc.nextLine());
                        System.out.println("Elemento enfileirado!");
                        break;
                    case 2:
                        System.out.println("Elemento removido: " + fila.dequeue());
                        break;
                    case 3:
                        System.out.println("Primeiro da fila: " + fila.peek());
                        break;
                    case 4:
                        System.out.print("Digite o novo valor do último: ");
                        fila.update(sc.nextLine());
                        System.out.println("Último elemento atualizado!");
                        break;
                    case 5:
                        System.out.println("Fila: " + fila.print());
                        break;
                    case 6:
                        System.out.println(fila.is_empty() ? "A fila está vazia." : "A fila contém elementos.");
                        break;
                    case 7:
                        System.out.println(fila.is_full() ? "A fila está cheia." : "A fila ainda tem espaço.");
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (opcao != 0);
    }
}
