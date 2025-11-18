package src.painel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class FornecedorPe extends JFrame implements ActionListener {
    private JButton enviar;
    private JButton limpar;
    private JButton mostrar;
    private JButton encerrar;
    private JButton ti;
    private JButton androides;
    private JButton emergente;
    private JButton alimentos;
    private JTextField campoCod;
    private JTextField campoNome;
    private JTextField campoData;
    private JTextField campoArea;
    private JTextArea avisos;

    public FornecedorPe() {
        super("Cadastro de fornecedor");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(2,1);
        FlowLayout flowLayoutCenter = new FlowLayout(FlowLayout.CENTER);
        Color color = new Color(236,246, 187);
        Font fonte = new Font("Arial", Font.BOLD, 14);

        JPanel painelPrincipal = new JPanel(new GridLayout(5,1));
        JPanel painel1 = new JPanel(flowLayoutCenter);
        painel1.setBackground(color);
        JPanel painel2 = new JPanel(gridLayout);
        painel2.setBackground(color);
        painel2.setBorder(new EmptyBorder(0,10,0,0));
        JPanel painel21 = new JPanel(flowLayoutCenter);
        painel21.setBackground(color);
        JPanel painel22 = new JPanel(flowLayoutCenter);
        painel22.setBackground(color);
        JPanel painel3 = new JPanel(gridLayout);
        painel3.setBackground(color);
        JPanel painel31 = new JPanel(flowLayoutCenter);
        painel31.setBackground(color);
        painel31.setBorder(new EmptyBorder(0,10,0,0));
        JPanel painel32 = new JPanel(flowLayoutCenter);
        painel32.setBackground(color);
        JPanel painel4 = new JPanel(gridLayout);
        painel4.setBackground(color);
        JPanel painel41 = new JPanel(flowLayoutCenter);
        painel41.setBackground(color);
        JPanel painel42 = new JPanel(flowLayoutCenter);
        painel42.setBackground(color);
        JPanel painel5 = new JPanel(flowLayoutCenter);
        painel5.setBackground(color);

        JLabel mensagem = new JLabel("Insira seus dados");
        mensagem.setFont(new Font("Arial", Font.BOLD, 30));

        JLabel mensagemCod = new JLabel("Cod: ");
        mensagemCod.setFont(fonte);
        campoCod = new JTextField(20);
        campoCod.setBorder(new EmptyBorder(0,0,0,0));
        
        painel1.add(mensagem);

        painel1.setBorder(new EmptyBorder(20,0,0,0));

        JLabel mensagemNome = new JLabel("Nome: ");
        mensagemNome.setFont(fonte);
        campoNome = new JTextField(19);
        campoNome.setBorder(new EmptyBorder(0,0,0,0));

        JLabel mensagemData = new JLabel("Data: ");
        mensagemData.setFont(fonte);
        campoData = new JTextField(20);
        campoData.setBorder(new EmptyBorder(0,0,0,0));

        painel21.add(mensagemCod);
        painel21.add(campoCod);

        painel22.add(mensagemNome);
        painel22.add(campoNome);

        painel2.add(painel21);
        painel2.add(painel22);

        JLabel mensagemArea = new JLabel("Area: ");
        mensagemArea.setFont(fonte);
        ti = new JButton("TI");
        androides = new JButton("ANDROIDES");
        emergente = new JButton("EMERGENTE");
        alimentos = new JButton("ALIMENTOS");

        enviar = new JButton("Enviar");
        limpar = new JButton("Limpar");
        mostrar = new JButton("Mostrar");
        encerrar = new JButton("Encerrar");

        avisos = new JTextArea(6,42);

        painel31.add(mensagemData);
        painel31.add(campoData);

        painel32.add(mensagemArea);
        painel32.add(ti);
        painel32.add(androides);
        painel32.add(emergente);
        painel32.add(alimentos);

        painel3.add(painel31);
        painel3.add(painel32);

        campoArea = new JTextField(20);
        painel41.add(campoArea);
        
        painel42.add(enviar);
        painel42.add(limpar);
        painel42.add(mostrar);
        painel42.add(encerrar);

        painel4.add(painel41);
        painel4.add(painel42);

        painel5.add(avisos);
        painel5.setBorder(new EmptyBorder(0,0,20,0));

        painelPrincipal.add(painel1);
        painelPrincipal.add(painel2);
        painelPrincipal.add(painel3);
        painelPrincipal.add(painel4);
        painelPrincipal.add(painel5);

        this.add(painelPrincipal);

        limpar.addActionListener(this);
        enviar.addActionListener(this);
        mostrar.addActionListener(this);
        encerrar.addActionListener(this);
        ti.addActionListener(this);
        androides.addActionListener(this);
        emergente.addActionListener(this);
        alimentos.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}