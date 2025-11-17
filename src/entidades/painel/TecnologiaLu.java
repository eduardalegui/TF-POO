package src.entidades.painel;

import java.util.*;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class TecnologiaLu extends JFrame implements ActionListener {

    
    private JPanel painelBotao;
    private JButton botao;
    private JButton botaoLimpa;
    private JButton botaoFecha;
    private JButton botaoMostrar;
    private JTextArea areaTexto;
    private JPanel painelTexto;

    private JPanel painelPrincipal;
    private JPanel esquerda;

    private JPanel painel1;
    private JLabel descricao1;
    private JTextField campoTexto1;

    private JPanel painel2;
    private JLabel descricao2;
    private JTextField campoTexto2;

    private JPanel painel3;
    private JLabel descricao3;
    private JTextField campoTexto3;

    private JPanel painel4;
    private JLabel descricao4;
    private JTextField campoTexto4;

    private JPanel painel5;
    private JLabel descricao5;
    private JTextField campoTexto5;

    private JPanel painel6;
    private JLabel descricao6;
    private JTextField campoTexto6;

    private JPanel painel7;
    private JLabel descricao7;
    private JTextField campoTexto7;


    private GridLayout gridLayout = new GridLayout(8, 1);
    private FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT, 20, 0);

    public TecnologiaLu() {
        
        super();

        esquerda = new JPanel();
        esquerda.setLayout(gridLayout);

        painel1 = new JPanel();
        painelId();
        esquerda.add(painel1);

        painel2 = new JPanel();
        painelModelo();
        esquerda.add(painel2);

        painel3 = new JPanel();
        painelDescricao();
        esquerda.add(painel3);

        painel4 = new JPanel();
        painelValorBase();
        esquerda.add(painel4);

        painel5 = new JPanel();
        painelPeso();
        esquerda.add(painel5);

        painel6 = new JPanel();
        painelTemperatura();
        esquerda.add(painel6);

        painel7 = new JPanel();
        painelFornecedor();
        esquerda.add(painel7);

        painelBotao = new JPanel();
        painelBotao();
        esquerda.add(painelBotao);

        painelTexto = new JPanel();
        painelTexto();

        painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.add(esquerda, BorderLayout.CENTER); 
        painelPrincipal.add(painelTexto(), BorderLayout.EAST);
        this.add(painelPrincipal);

        this.setSize(800, 500);
        this.setTitle("Cadastro de Tecnologia - ACMETech");
        botao.addActionListener(this);
        botaoLimpa.addActionListener(this);
        botaoFecha.addActionListener(e -> this.dispose());
        botaoMostrar.addActionListener(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void painelId() {
        
        descricao1 = new JLabel("Informe o ID da tecnologia:");
        campoTexto1 = new JTextField(25);
        painel1.setLayout(flowLayout);
        painel1.add(descricao1);
        painel1.add(campoTexto1);
    }

    private void painelModelo() {
        descricao2 = new JLabel("Informe o modelo:                ");
        campoTexto2 = new JTextField(25);
        painel2.setLayout(flowLayout);
        painel2.add(descricao2);
        painel2.add(campoTexto2);
    }

    private void painelDescricao() {
        descricao3 = new JLabel("Informe a descrição:           ");
        campoTexto3 = new JTextField(25);
        painel3.setLayout(flowLayout);
        painel3.add(descricao3);
        painel3.add(campoTexto3);
    }

    private void painelValorBase() {
        descricao4 = new JLabel("Informe o valor base (R$):  ");
        campoTexto4 = new JTextField(25);
        painel4.setLayout(flowLayout);
        painel4.add(descricao4);
        painel4.add(campoTexto4);
    }

    private void painelPeso() {
        descricao5 = new JLabel("Informe o peso (kg):            ");
        campoTexto5 = new JTextField(25);
        painel5.setLayout(flowLayout);
        painel5.add(descricao5);
        painel5.add(campoTexto5);
    }

    private void painelTemperatura() {
        descricao6 = new JLabel("Informe a temperatura:      ");
        campoTexto6 = new JTextField(25);
        painel6.setLayout(flowLayout);
        painel6.add(descricao6);
        painel6.add(campoTexto6);
    }

    private void painelFornecedor() {
        descricao7 = new JLabel("Informe o fornecedor:        ");
        campoTexto7 = new JTextField(25);
        painel7.setLayout(flowLayout);
        painel7.add(descricao7);
        painel7.add(campoTexto7);
    }

    private void painelBotao(){
        FlowLayout flowBotao = new FlowLayout(FlowLayout.LEFT, 14, 0);
        botao = new JButton("Cadastrar");
        botaoLimpa = new JButton("Limpar");
        botaoFecha = new JButton("Fechar");
        botaoMostrar = new JButton("Tecnologias cadastradas");
        painelBotao.setLayout(flowBotao);
        painelBotao.add(botaoFecha);
        painelBotao.add(botaoMostrar);
        painelBotao.add(botaoLimpa);
        painelBotao.add(botao);
    }

    private JPanel painelTexto() {


        painelTexto = new JPanel(new FlowLayout());
        areaTexto = new JTextArea(25, 25);
        
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        painelTexto.add(scrollPane);
        return painelTexto;
    }
}
