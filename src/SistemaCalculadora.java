import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class SistemaCalculadora extends JFrame {

    private JTextField campoNumero1;
    private JTextField campoNumero2;
    private JLabel labelResultado;

    public SistemaCalculadora(){
        setTitle("Sistema Calculadora");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20,20));

        JPanel painelEntrada = new JPanel();
        painelEntrada.setLayout(new GridLayout(2,2,10,10));
        painelEntrada.add(new JLabel("Número 1:"));
        campoNumero1 = new JTextField();
        campoNumero1.setFont(new Font("Arial", Font.BOLD, 25));
        painelEntrada.add(campoNumero1);
        painelEntrada.add(new JLabel("Número 2:"));
        campoNumero2 = new JTextField();
        campoNumero2.setFont(new Font("Arial", Font.BOLD, 25 ));
        painelEntrada.add(campoNumero2);

        add(painelEntrada, BorderLayout.NORTH);

        JPanel painelOperacoes = new JPanel();
        painelOperacoes.setLayout(new GridLayout(2, 5,5,8));

        JButton botaoSoma = new JButton("+");
        JButton botaoSubtracao = new JButton("-");
        JButton botaoMultiplicacao = new JButton("*");
        JButton botaoDivisao = new JButton("/");

        botaoSoma.setFont(new Font("Arial", Font.BOLD, 26));
        botaoSubtracao.setFont(new Font("Arial", Font.BOLD, 26));
        botaoMultiplicacao.setFont(new Font("Arial", Font.BOLD, 26));
        botaoDivisao.setFont(new Font("Arial", Font.BOLD, 26));

        painelOperacoes.add(botaoSoma);
        painelOperacoes.add(botaoSubtracao);
        painelOperacoes.add(botaoMultiplicacao);
        painelOperacoes.add(botaoDivisao);

        add(painelOperacoes, BorderLayout.CENTER);

        labelResultado = new JLabel("Resultado: ");
        labelResultado.setFont(new Font("Arial", Font.PLAIN, 25));
        labelResultado.setHorizontalAlignment(SwingConstants.LEFT);
        add(labelResultado, BorderLayout.SOUTH);

        botaoSoma.addActionListener(new OperacaoListener("+"));
        botaoSubtracao.addActionListener(new OperacaoListener("-"));
        botaoMultiplicacao.addActionListener(new OperacaoListener("*"));
        botaoDivisao.addActionListener(new OperacaoListener("/"));

        setVisible(true);

    }

    private class OperacaoListener implements ActionListener {
        private String operacao;

        public OperacaoListener(String operacao) {
            this.operacao = operacao;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double numero1 = Double.parseDouble(campoNumero1.getText());
                double numero2 = Double.parseDouble(campoNumero2.getText());
                double resultado = 0;

                switch (operacao) {
                    case "+":
                        resultado = numero1 + numero2;
                        break;
                    case "-":
                        resultado = numero1 - numero2;
                        break;
                    case "*":
                        resultado = numero1 * numero2;
                        break;
                    case "/":
                        if (numero2 == 0) {
                            labelResultado.setText("Erro: Divisão por zero");
                            return;
                        }
                        resultado = numero1 / numero2;
                        break;
                }
                labelResultado.setText("Resultado: " + resultado);
            } catch (NumberFormatException ex) {
                labelResultado.setText("Erro: insira um número válido");
            }
        }
    }

    public static void main(String[] args){
        new SistemaCalculadora();
    }
}
