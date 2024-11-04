// src/view/Main.java
package view;

import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Mesa> mesas = new ArrayList<>();
    private static List<Ingrediente> ingredientes = new ArrayList<>();
    private static List<Cardapio> cardapios = new ArrayList<>();
    private static List<Pedido> pedidos = new ArrayList<>();
    private static int contadorMesa = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Mesa");
            System.out.println("3. Adicionar Ingrediente");
            System.out.println("4. Adicionar Prato ao Cardápio");
            System.out.println("5. Fazer Pedido");
            System.out.println("6. Listar Clientes");
            System.out.println("7. Listar Mesas");
            System.out.println("8. Listar Ingredientes");
            System.out.println("9. Listar Cardápio");
            System.out.println("10. Listar Pedidos");
            System.out.println("11. Pagar Pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> adicionarCliente(scanner);
                case 2 -> adicionarMesa(scanner);
                case 3 -> adicionarIngrediente(scanner);
                case 4 -> adicionarPrato(scanner);
                case 5 -> fazerPedido(scanner);
                case 6 -> listarClientes();
                case 7 -> listarMesas();
                case 8 -> listarIngredientes();
                case 9 -> listarCardapio();
                case 10 -> listarPedidos();
                case 11 -> pagarPedido(scanner);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado.");
            return;
        }
        System.out.println("Lista de Pedidos:");
        for (Pedido pedido : pedidos) {
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Mesa: " + pedido.getMesa().getId_mesa());
            System.out.println("Prato: " + pedido.getCardapio().getNome_prato());
            if (pedido.getPagamento() instanceof PagamentoCartao) {
                System.out.println("Pagamento: Cartão");
                System.out.println("Número do Cartão: " + ((PagamentoCartao) pedido.getPagamento()).getNumeroCartao());
            } else if (pedido.getPagamento() instanceof PagamentoPix) {
                System.out.println("Pagamento: Pix");
                System.out.println("Código da Transação: " + ((PagamentoPix) pedido.getPagamento()).getCodigoTransacao());
            }
            System.out.println("----------");
        }
    }

    private static void pagarPedido(Scanner scanner) {
        System.out.print("Digite o nome do cliente para pagar o pedido: ");
        String nomeCliente = scanner.nextLine();
        Pedido pedidoParaPagar = null;
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente().getNome().equalsIgnoreCase(nomeCliente)) {
                pedidoParaPagar = pedido;
                break;
            }
        }

        if (pedidoParaPagar == null) {
            System.out.println("Pedido não encontrado para o cliente especificado.");
            return;
        }

        System.out.println("Escolha o método de pagamento:");
        System.out.println("1. Cartão");
        System.out.println("2. Pix");
        int metodoPagamento = scanner.nextInt();
        scanner.nextLine();

        switch (metodoPagamento) {
            case 1 -> {
                System.out.print("Digite o número do cartão: ");
                String numeroCartao = scanner.nextLine();
                PagamentoCartao pagamentoCartao = new PagamentoCartao();
                pagamentoCartao.setNumeroCartao(numeroCartao);
                pedidoParaPagar.setPagamento(pagamentoCartao);
                pagamentoCartao.processarPagamento();
            }
            case 2 -> {
                System.out.print("Digite o código da transação Pix: ");
                String codigoTransacao = scanner.nextLine();
                PagamentoPix pagamentoPix = new PagamentoPix();
                pagamentoPix.setCodigoTransacao(codigoTransacao);
                pedidoParaPagar.setPagamento(pagamentoPix);
                pagamentoPix.processarPagamento();
            }
            default -> {
                System.out.println("Método de pagamento inválido.");
                return;
            }
        }

        pedidos.remove(pedidoParaPagar);
        System.out.println("Pedido pago e removido do sistema com sucesso.");
    }

    private static void adicionarCliente(Scanner scanner) {
        Cliente cliente = new Cliente();
        System.out.print("Digite o nome do cliente: ");
        cliente.setNome(scanner.nextLine());
        clientes.add(cliente);
        System.out.println("Cliente adicionado!");
    }

    private static void adicionarMesa(Scanner scanner) {
        Mesa mesa = new Mesa();
        mesa.setId_mesa(contadorMesa++);
        System.out.print("Digite a quantidade de cadeiras: ");
        mesa.setQtd_cadeira(scanner.nextInt());
        scanner.nextLine();
        mesas.add(mesa);
        System.out.println("Mesa " + mesa.getId_mesa() + " adicionada!");
    }

    private static void adicionarIngrediente(Scanner scanner) {
        Ingrediente ingrediente = new Ingrediente();
        System.out.print("Digite o nome do ingrediente: ");
        ingrediente.setNome_ingrediente(scanner.nextLine());
        ingredientes.add(ingrediente);
        System.out.println("Ingrediente adicionado!");
    }

    private static void adicionarPrato(Scanner scanner) {
        Cardapio prato = new Cardapio();
        System.out.print("Digite o nome do prato: ");
        prato.setNome_prato(scanner.nextLine());
        System.out.print("Digite a descrição do prato: ");
        prato.setDescricao_prato(scanner.nextLine());
        System.out.print("Digite o valor do prato: ");
        prato.setValor_prato(scanner.nextDouble());
        scanner.nextLine();
        cardapios.add(prato);
        System.out.println("Prato adicionado ao cardápio!");
    }

    private static void fazerPedido(Scanner scanner) {
        Pedido pedido = new Pedido();
        System.out.print("Escolha o cliente (digite o nome): ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = null;

        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                cliente = c;
                break;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        pedido.setCliente(cliente);
        System.out.print("Escolha a mesa (número): ");
        int numeroMesa = scanner.nextInt();
        scanner.nextLine();
        Mesa mesa = null;

        for (Mesa m : mesas) {
            if (m.getId_mesa() == numeroMesa) {
                mesa = m;
                break;
            }
        }

        if (mesa == null) {
            System.out.println("Mesa não encontrada.");
            return;
        }

        pedido.setMesa(mesa);
        System.out.print("Escolha o prato (digite o nome): ");
        String nomePrato = scanner.nextLine();
        Cardapio prato = null;

        for (Cardapio p : cardapios) {
            if (p.getNome_prato().equalsIgnoreCase(nomePrato)) {
                prato = p;
                break;
            }
        }

        if (prato == null) {
            System.out.println("Prato não encontrado.");
            return;
        }

        pedido.setCardapio(prato);
        pedidos.add(pedido);
        System.out.println("Pedido feito com sucesso!");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente foi registrado.");
        } else {
            System.out.println("Clientes:");
            for (Cliente c : clientes) {
                System.out.println("- " + c.getNome());
            }
        }
    }

    private static void listarMesas() {
        if (mesas.isEmpty()) {
            System.out.println("Nenhuma mesa registrada.");
        } else {
            System.out.println("Mesas:");
            for (Mesa m : mesas) {
                System.out.println("- Mesa " + m.getId_mesa() + ": " + m.getQtd_cadeira() + " cadeiras");
            }
        }
    }

    private static void listarIngredientes() {
        if (ingredientes.isEmpty()) {
            System.out.println("Nenhum ingrediente registrado.");
        } else {
            System.out.println("Ingredientes:");
            for (Ingrediente i : ingredientes) {
                System.out.println("- " + i.getNome_ingrediente());
            }
        }
    }

    private static void listarCardapio() {
        if (cardapios.isEmpty()) {
            System.out.println("Nenhum prato no cardápio.");
        } else {
            System.out.println("Cardápio:");
            for (Cardapio p : cardapios) {
                System.out.println("- " + p.getNome_prato() + ": " + p.getDescricao_prato() + " - R$" + p.getValor_prato());
            }
        }
    }
}
