import javax.swing.*;
import java.awt.*;

public class TelaPedidos extends JFrame {

    private JComboBox<String> tipoPedidoCombo;
    private JComboBox<String> pagamentoCombo;
    private JTextField valorField;
    private JTextArea resultadoArea;

    public TelaPedidos() {
        setTitle("Sistema de Pedidos Online");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(4, 2, 10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        painel.add(new JLabel("Tipo de pedido:"));
        tipoPedidoCombo = new JComboBox<>(new String[]{"Normal", "Expresso"});
        painel.add(tipoPedidoCombo);

        painel.add(new JLabel("Forma de pagamento:"));
        pagamentoCombo = new JComboBox<>(new String[]{"PIX", "Cartão", "Boleto"});
        painel.add(pagamentoCombo);

        painel.add(new JLabel("Valor do pedido:"));
        valorField = new JTextField();
        painel.add(valorField);

        JButton finalizarButton = new JButton("Finalizar Pedido");
        painel.add(finalizarButton);

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        resultadoArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(painel, BorderLayout.NORTH);
        add(new JScrollPane(resultadoArea), BorderLayout.CENTER);

        finalizarButton.addActionListener(e -> finalizarPedido());
    }

    private void finalizarPedido() {
        try {
            DatabaseConnection conexao = DatabaseConnection.getInstance();
            conexao.conectar();

            String tipoPedido = tipoPedidoCombo.getSelectedItem().toString();
            String formaPagamento = pagamentoCombo.getSelectedItem().toString();
            double valor = Double.parseDouble(valorField.getText());

            Pedido pedido = PedidoFactory.criarPedido(tipoPedido);

            PagamentoStrategy pagamento;

            if (formaPagamento.equals("PIX")) {
                pagamento = new PagamentoPix();
            } else if (formaPagamento.equals("Cartão")) {
                pagamento = new PagamentoCartao();
            } else {
                pagamento = new PagamentoBoleto();
            }

            PedidoService service = new PedidoService(pagamento);
            service.finalizarPedido(pedido, valor);

            resultadoArea.setText(
                "Pedido finalizado com sucesso!\n\n" +
                "Tipo de pedido: " + tipoPedido + "\n" +
                "Forma de pagamento: " + formaPagamento + "\n" +
                "Valor: R$ " + valor + "\n\n" +
                "Padrões aplicados:\n" +
                "- Singleton: DatabaseConnection\n" +
                "- Factory Method: PedidoFactory\n" +
                "- Strategy: PagamentoStrategy"
            );

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido.");
        }
    }

    public static void main(String[] args) {
        new TelaPedidos().setVisible(true);
    }
}