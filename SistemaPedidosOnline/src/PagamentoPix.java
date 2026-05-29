public class PagamentoPix implements PagamentoStrategy {
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado via PIX.");
    }
}