package uninter;

import java.util.InputMismatchException;
import java.util.Scanner;

// Classe Menu para interação com o usuário
public class Menu {

    // Scanner para leitura de entradas do usuário
    private Scanner sc;
    // Instância de Cofrinho para gerenciar as moedas
    private Cofrinho cofrinho;

    // Construtor da classe Menu que inicializa o Scanner e o Cofrinho
    public Menu() {
        sc = new Scanner(System.in);
        cofrinho = new Cofrinho();
    }

    // Método para exibir o menu principal e lidar com as opções selecionadas
    public void exibirMenuPrincipal() {
        System.out.println("COFRINHO:");
        System.out.println("1- Adicionar Moeda:");
        System.out.println("2- Remover Moeda:");
        System.out.println("3- Listar Moedas:");
        System.out.println("4- Calcular Valor Total Convertido Para Real:");
        System.out.println("0- Encerrar: ");

        String opcaoSelecionada = sc.next();
        System.out.println();
        switch (opcaoSelecionada) {
            case "0":
                System.out.println("Fechando o Programa!");
                break;

            case "1":
                exibirSubMenuAdicionarMoedas();
                exibirMenuPrincipal();
                break;

            case "2":
                exibirSubMenuRemoverMoedas();
                exibirMenuPrincipal();
                break;

            case "3":
                cofrinho.listagemMoedas();
                System.out.println();
                exibirMenuPrincipal();
                break;

            case "4":
                double valorTotalConvertido = cofrinho.totalConvertido();
                System.out.printf("O valor total convertido em reais eh de: R$ %.2f\n", valorTotalConvertido);
                System.out.println();
                exibirMenuPrincipal();
                break;

            default:
                System.out.println("Opção Inválida!");
                System.out.println();
                exibirMenuPrincipal();
                break;
        }
    }

    // Método para exibir o submenu de adição de moedas
    private void exibirSubMenuAdicionarMoedas() {
        try {
            System.out.println("Escolha Moeda:");
            System.out.println("1 - Real");
            System.out.println("2 - Dolar");
            System.out.println("3 - Euro");

            int opcaoMoeda = sc.nextInt();
            System.out.println();
            if (opcaoMoeda != 1 && opcaoMoeda != 2 && opcaoMoeda != 3 ) {
                System.out.println("Opção Inválida!");
                System.out.println();
                exibirSubMenuAdicionarMoedas();
            }

            System.out.println("Digite o valor: ");

            String valorTextoMoeda = sc.next();
            valorTextoMoeda = valorTextoMoeda.replace(",", ".");
            double valorMoeda = Double.valueOf(valorTextoMoeda);

            Moeda moeda = null;
            if (opcaoMoeda == 1) {
                moeda = new Real(valorMoeda);
            } else if (opcaoMoeda == 2) {
                moeda = new Dolar(valorMoeda);
            } else if (opcaoMoeda == 3) {
                moeda = new Euro(valorMoeda);
            } else {
                System.out.println("Nao existe essa moeda!");
                exibirMenuPrincipal();
            }

            cofrinho.adicionar(moeda);
            System.out.println("Moeda Adicionada!");
            System.out.println();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Certifique-se de inserir uma opcao valida!.\n");
            // Limpar o buffer do scanner
            sc.nextLine();
            // Exibir novamente o submenu
            exibirSubMenuAdicionarMoedas();
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida! Certifique-se de inserir um valor valido!.\n");
            exibirSubMenuAdicionarMoedas();
        } catch (Exception e) {
            System.out.println("Entrada inválida!.\n");
            exibirSubMenuAdicionarMoedas();
        }
    }

    // Método para exibir o submenu de remoção de moedas
    private void exibirSubMenuRemoverMoedas() {
        System.out.println("Escolha Moeda:");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");

        int opcaoMoeda = sc.nextInt();

        System.out.println();


        switch (opcaoMoeda) {
            case 1:
                System.out.println("Moedas de Real no Cofrinho:");
                listarMoedasPorTipo(Real.class);
                break;
            case 2:
                System.out.println("Moedas de Dolar no Cofrinho:");
                listarMoedasPorTipo(Dolar.class);
                break;
            case 3:
                System.out.println("Moedas de Euro no Cofrinho:");
                listarMoedasPorTipo(Euro.class);
                break;
            default:
                System.out.println("Nao existe essa moeda!\n");
                System.out.println();
                exibirMenuPrincipal();
                return;
        }

        System.out.println();
        System.out.println("Digite o valor: ");

        String valorTextoMoeda = sc.next();
        valorTextoMoeda = valorTextoMoeda.replace(",", ".");
        double valorMoeda = Double.valueOf(valorTextoMoeda);

        Moeda moeda = null;
        if (opcaoMoeda == 1) {
            moeda = new Real(valorMoeda);

        } else if (opcaoMoeda == 2) {
            moeda = new Dolar(valorMoeda);

        } else if (opcaoMoeda == 3) {
            moeda = new Euro(valorMoeda);

        }

        boolean removeuMoeda = cofrinho.remover(moeda);
        if (removeuMoeda) {
            System.out.println("Moeda Removida!\n");
        } else {
            System.out.println("Nao foi encontrada nenhuma moeda com esse valor!\n");
        }
    }
    // Método para listar as moedas de um tipo específico
    private void listarMoedasPorTipo(Class<? extends Moeda> tipo) {
        boolean encontrouMoeda = false;
        for (Moeda moeda : cofrinho.getListaMoedas()) {
            if (moeda.getClass().equals(tipo)) {
                moeda.info();
                encontrouMoeda = true;
            }
        }
        if (!encontrouMoeda) {
            System.out.println("Nao foram encontradas moedas desse tipo no cofrinho!");
        }
    }
}
