import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DatabaseConnection conexao = DatabaseConnection.getInstance();
        conexao.conectar();

        System.out.println("===== SISTEMA DE PEDIDOS =====");
        System.out.println("1 - Pedido Normal");
        System.out.println("2 - Pedido Expresso");
        System.out.print("Escolha o tipo de pedido: ");

        int tipoPedido = scanner.nextInt();

        Pedido pedido;

        if (tipoPedido == 1) {
            pedido = PedidoFactory.criarPedido("normal");
        } else {
            pedido = PedidoFactory.criarPedido("expresso");
        }

        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("1 - PIX");
        System.out.println("2 - Cartão");
        System.out.println("3 - Boleto");
        System.out.print("Opção: ");

        int tipoPagamento = scanner.nextInt();

        PagamentoStrategy pagamento;

        switch (tipoPagamento) {
            case 1:
                pagamento = new PagamentoPix();
                break;

            case 2:
                pagamento = new PagamentoCartao();
                break;

            default:
                pagamento = new PagamentoBoleto();
                break;
        }

        System.out.print("\nDigite o valor do pedido: R$ ");
        double valor = scanner.nextDouble();

        PedidoService service = new PedidoService(pagamento);

        System.out.println("\n===== PROCESSANDO PEDIDO =====");
        service.finalizarPedido(pedido, valor);

        scanner.close();
    }
}