package view;

import controller.ProdutoController;
import controller.VendedorController;
import model.entidades.Produto;
import model.entidades.Vendedor;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private static final VendedorController vendedorController = new VendedorController();
    private static final ProdutoController produtoController = new ProdutoController();
    private static final Scanner scanner = new Scanner(System.in);

    // Cores ANSI para estilizar o console
    public static final String RESET = "\u001B[0m";
    public static final String CYAN = "\u001B[36m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String PURPLE = "\u001B[35m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        int opcao;
        do {
            exibirCabecalho("MARKETPLACE - MENU PRINCIPAL");
            System.out.println(CYAN + "1." + RESET + " Gerenciar Vendedores");
            System.out.println(CYAN + "2." + RESET + " Gerenciar Produtos");
            System.out.println(CYAN + "3." + RESET + " Relacionamentos (Consultas)");
            System.out.println(RED + "0." + RESET + " Sair do Sistema");
            System.out.print(BOLD + "\nEscolha uma opção: " + RESET);

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    menuVendedores();
                    break;
                case 2:
                    menuProdutos();
                    break;
                case 3:
                    menuRelacionamentos();
                    break;
                case 0:
                    System.out.println(GREEN + "\nSaindo do sistema... Até logo!" + RESET);
                    break;
                default:
                    System.out.println(RED + "\n[Erro] Opção inválida! Pressione Enter para continuar." + RESET);
                    scanner.nextLine();
            }
        } while (opcao != 0);
    }

    // ==========================================
    // MENU DE VENDEDORES
    // ==========================================
    private static void menuVendedores() {
        int opcao;
        do {
            exibirCabecalho("GERENCIAMENTO DE VENDEDORES");
            System.out.println(CYAN + "1." + RESET + " Cadastrar Vendedor");
            System.out.println(CYAN + "2." + RESET + " Listar Vendedores");
            System.out.println(CYAN + "3." + RESET + " Atualizar Vendedor");
            System.out.println(CYAN + "4." + RESET + " Excluir Vendedor");
            System.out.println(YELLOW + "0." + RESET + " Voltar ao Menu Principal");
            System.out.print(BOLD + "\nEscolha uma opção: " + RESET);

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarVendedor();
                    break;
                case 2:
                    listarVendedores();
                    pausa();
                    break;
                case 3:
                    atualizarVendedor();
                    break;
                case 4:
                    excluirVendedor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(RED + "\n[Erro] Opção inválida!" + RESET);
                    pausa();
            }
        } while (opcao != 0);
    }

    private static void cadastrarVendedor() {
        exibirCabecalho("CADASTRAR NOVO VENDEDOR");
        try {
            System.out.print("ID do Vendedor (número): ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Nome do Vendedor: ");
            String nome = scanner.nextLine();

            System.out.print("Avaliação (0 a 5): ");
            int avaliacao = Integer.parseInt(scanner.nextLine());

            vendedorController.cadastrarVendedor(id, nome, avaliacao);
            System.out.println(GREEN + "\n[Sucesso] Vendedor cadastrado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(RED + "\n[Erro ao cadastrar] " + e.getMessage() + RESET);
        }
        pausa();
    }

    private static void listarVendedores() {
        exibirCabecalho("LISTA DE VENDEDORES");
        try {
            List<Vendedor> vendedores = vendedorController.listarVendedores();
            if (vendedores.isEmpty()) {
                System.out.println(YELLOW + "Nenhum vendedor cadastrado." + RESET);
            } else {
                System.out.printf(BOLD + "%-5s | %-25s | %-10s\n" + RESET, "ID", "NOME", "AVALIAÇÃO");
                System.out.println("----------------------------------------------");
                for (Vendedor v : vendedores) {
                    System.out.printf("%-5d | %-25s | %-10d\n", v.getIdVendedor(), v.getNomeVendedor(), v.getAvaliacao());
                }
            }
        } catch (Exception e) {
            System.out.println(RED + "[Erro] " + e.getMessage() + RESET);
        }
    }

    private static void atualizarVendedor() {
        exibirCabecalho("ATUALIZAR VENDEDOR");
        try {
            System.out.print("Informe o ID do vendedor que deseja atualizar: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Nova Avaliação (0 a 5): ");
            int avaliacao = Integer.parseInt(scanner.nextLine());

            vendedorController.atualizarVendedor(id, nome, avaliacao);
            System.out.println(GREEN + "\n[Sucesso] Vendedor atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(RED + "\n[Erro ao atualizar] " + e.getMessage() + RESET);
        }
        pausa();
    }

    private static void excluirVendedor() {
        exibirCabecalho("EXCLUIR VENDEDOR");
        try {
            System.out.print("Informe o ID do vendedor que deseja excluir: ");
            int id = Integer.parseInt(scanner.nextLine());

            vendedorController.deletarVendedor(id);
            System.out.println(GREEN + "\n[Sucesso] Vendedor excluído com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(RED + "\n[Erro ao excluir] " + e.getMessage() + RESET);
        }
        pausa();
    }

    // ==========================================
    // MENU DE PRODUTOS
    // ==========================================
    private static void menuProdutos() {
        int opcao;
        do {
            exibirCabecalho("GERENCIAMENTO DE PRODUTOS");
            System.out.println(CYAN + "1." + RESET + " Cadastrar Produto (Vinculado a um Vendedor)");
            System.out.println(CYAN + "2." + RESET + " Atualizar Produto");
            System.out.println(CYAN + "3." + RESET + " Excluir Produto");
            System.out.println(YELLOW + "0." + RESET + " Voltar ao Menu Principal");
            System.out.print(BOLD + "\nEscolha uma opção: " + RESET);

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(RED + "\n[Erro] Opção inválida!" + RESET);
                    pausa();
            }
        } while (opcao != 0);
    }

    private static void cadastrarProduto() {
        exibirCabecalho("CADASTRAR NOVO PRODUTO");
        try {
            System.out.print("ID do Produto (número): ");
            int idProduto = Integer.parseInt(scanner.nextLine());

            System.out.print("Nome do Produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.print("Quantidade em estoque: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.print("Preço (ex: 49.90): ");
            double preco = Double.parseDouble(scanner.nextLine().replace(",", "."));

            System.out.print("ID do Vendedor Responsável: ");
            int idVendedor = Integer.parseInt(scanner.nextLine());

            produtoController.cadastrarProduto(idProduto, nomeProduto, quantidade, preco, idVendedor);
            System.out.println(GREEN + "\n[Sucesso] Produto cadastrado e vinculado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(RED + "\n[Erro ao cadastrar produto] " + e.getMessage() + RESET);
        }
        pausa();
    }

    private static void atualizarProduto() {
        exibirCabecalho("ATUALIZAR PRODUTO");
        try {
            System.out.print("Informe o ID do produto que deseja atualizar: ");
            int idProduto = Integer.parseInt(scanner.nextLine());

            System.out.print("Novo Nome do Produto: ");
            String nomeProduto = scanner.nextLine();

            System.out.print("Nova Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            System.out.print("Novo Preço: ");
            double preco = Double.parseDouble(scanner.nextLine().replace(",", "."));

            produtoController.atualizarProduto(idProduto, nomeProduto, quantidade, preco);
            System.out.println(GREEN + "\n[Sucesso] Produto atualizado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(RED + "\n[Erro ao atualizar produto] " + e.getMessage() + RESET);
        }
        pausa();
    }

    private static void excluirProduto() {
        exibirCabecalho("EXCLUIR PRODUTO");
        try {
            System.out.print("Informe o ID do produto que deseja excluir: ");
            int idProduto = Integer.parseInt(scanner.nextLine());

            produtoController.deletarProduto(idProduto);
            System.out.println(GREEN + "\n[Sucesso] Produto excluído com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(RED + "\n[Erro ao excluir produto] " + e.getMessage() + RESET);
        }
        pausa();
    }

    // ==========================================
    // MENU DE RELACIONAMENTOS
    // ==========================================
    private static void menuRelacionamentos() {
        exibirCabecalho("CONSULTA DE RELACIONAMENTOS");
        try {
            System.out.print("Informe o ID do vendedor para listar seus produtos: ");
            int idVendedor = Integer.parseInt(scanner.nextLine());

            List<Produto> produtos = produtoController.listarProdutosPorVendedor(idVendedor);

            System.out.println(PURPLE + "\n--- Produtos do Vendedor (ID: " + idVendedor + ") ---" + RESET);
            if (produtos.isEmpty()) {
                System.out.println(YELLOW + "Nenhum produto cadastrado para este vendedor." + RESET);
            } else {
                System.out.printf(BOLD + "%-10s | %-25s | %-10s | %-10s\n" + RESET, "ID PROD", "NOME", "QTD", "PREÇO");
                System.out.println("---------------------------------------------------------");
                for (Produto p : produtos) {
                    System.out.printf("%-10d | %-25s | %-10d | R$ %-8.2f\n",
                            p.getIdProduto(), p.getNomeProduto(), p.getQuantidade(), p.getPreco());
                }
            }
        } catch (Exception e) {
            System.out.println(RED + "\n[Erro] " + e.getMessage() + RESET);
        }
        pausa();
    }

    // ==========================================
    // UTILITÁRIOS VISUAIS DO CONSOLE
    // ==========================================
    private static void exibirCabecalho(String titulo) {
        // Limpa visualmente o terminal com quebras de linha
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println(PURPLE + "========================================================");
        System.out.println("       " + BOLD + titulo + RESET + PURPLE);
        System.out.println("========================================================" + RESET);
    }

    private static void pausa() {
        System.out.print(BOLD + "\nPressione Enter para continuar..." + RESET);
        scanner.nextLine();
    }
}