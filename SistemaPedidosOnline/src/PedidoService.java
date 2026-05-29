public class PedidoService {
    private PagamentoStrategy pagamentoStrategy;

    public PedidoService(PagamentoStrategy pagamentoStrategy) {
        this.pagamentoStrategy = pagamentoStrategy;
    }

    public void finalizarPedido(Pedido pedido, double valor) {
        pedido.criar();
        pagamentoStrategy.pagar(valor);
        System.out.println("Pedido finalizado com sucesso.");
    }
}