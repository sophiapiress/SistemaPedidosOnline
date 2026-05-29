public class PedidoFactory {
    public static Pedido criarPedido(String tipo) {
        if (tipo.equalsIgnoreCase("normal")) {
            return new PedidoNormal();
        } else if (tipo.equalsIgnoreCase("expresso")) {
            return new PedidoExpresso();
        } else {
            throw new IllegalArgumentException("Tipo de pedido inválido.");
        }
    }
}