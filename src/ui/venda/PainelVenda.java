package src.ui.venda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import src.entidades.CatalogoParticipantes;
import src.ui.HomePage;
import src.ui.fornecedor.DialogRelatorioFornecedor;


public class PainelVenda extends JPanel implements ActionListener{
    private JButton voltar;
    private JButton botao21;
    private JButton botao22;
    private JButton botao23;
    private JButton botao24;
    private HomePage home;
    private CatalogoParticipantes catalogoParticipantes;

    public PainelVenda(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.setSize(1200,700);
        //this.setTitle("Venda"); // nome da janela
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        this.catalogoParticipantes = catalogoParticipantes;
        Color corFundo = new Color(238, 236, 194);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBackground(corFundo);
        this.setLayout(layout);
        //===============================================
            this.home = home;
            // JPanel body = new JPanel();
            // BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            // Color corFundo = new Color(238, 236, 194);
            Color amarelo = new Color(255, 194, 62);
            voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, amarelo);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            FlowLayout  layout11 = new FlowLayout(FlowLayout.CENTER);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 60));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 70, 0));
            voltar.setPreferredSize(new Dimension(100, 40));
            botaoVoltar.setOpaque(false);
            voltar.setOpaque(true);
            voltar.setBorder(bordaBotaoVoltar);
            voltar.setLayout(layoutB);
            botaoVoltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            botaoVoltar.add(voltar);
            // body.add(botaoVoltar);
            // body.setLayout(layout);
            // body.setBackground(corFundo);
            // body.setOpaque(true); //não o torna tranparente
            // body.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

            //===============================================
                JPanel comp1 = new JPanel();
                MatteBorder bordaTF = new MatteBorder(0, 0, 4, 0, amarelo);
                JLabel tituloTF = new JLabel("Métodos de Venda");
                Font fontTF = new Font("SansSerif", Font.BOLD, 60);
                tituloTF.setBorder(bordaTF);
                tituloTF.setFont(fontTF);
                comp1.add(tituloTF);
                comp1.setLayout(layout11);
                comp1.setSize(1200,40);
                //comp1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                comp1.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                comp2.setLayout(layout11);
                comp2.setMaximumSize(new Dimension(800, 200));
                comp2.setBorder(BorderFactory.createEmptyBorder(20, 0, 400, 0));

                //===============================================
                    JPanel comp21 = new JPanel();
                    botao21= new JButton("Cadastrar");
                    MatteBorder bordaBotoes21 = new MatteBorder(2, 2, 2, 2, amarelo);
                    botao21.setPreferredSize(new Dimension(250, 100));
                    botao21.setOpaque(true);
                    botao21.setBorder(bordaBotoes21);
                    botao21.setBackground(amarelo);
                    botao21.setFont(fontBotoes);
                    comp21.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 25));
                    comp21.add(botao21);
                    comp21.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp22 = new JPanel();
                    botao22= new JButton("Mostrar Relatório");
                    MatteBorder bordaBotoes22 = new MatteBorder(2, 2, 2, 2, amarelo);
                    botao22.setPreferredSize(new Dimension(250, 100));
                    botao22.setOpaque(true);
                    botao22.setBorder(bordaBotoes22);
                    botao22.setBackground(amarelo);
                    botao22.setFont(fontBotoes);
                    comp22.setBorder(BorderFactory.createEmptyBorder(0, 25, 20, 0));
                    comp22.add(botao22);
                    comp22.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp23 = new JPanel();
                    botao23= new JButton("Remover Dados");
                    MatteBorder bordaBotoes23 = new MatteBorder(2, 2, 2, 2, amarelo);
                    botao23.setPreferredSize(new Dimension(250, 100));
                    botao23.setOpaque(true);
                    botao23.setBorder(bordaBotoes23);
                    botao23.setBackground(amarelo);
                    botao23.setFont(fontBotoes);
                    comp23.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
                    comp23.add(botao23);
                    comp23.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp24 = new JPanel();
                    botao24= new JButton("Consultar Maior");
                    MatteBorder bordaBotoes24 = new MatteBorder(2, 2, 2, 2, amarelo);
                    botao24.setPreferredSize(new Dimension(250, 100));
                    botao24.setOpaque(true);
                    botao24.setBorder(bordaBotoes24);
                    botao24.setBackground(amarelo);
                    botao24.setFont(fontBotoes);
                    comp24.setBorder(BorderFactory.createEmptyBorder(0, 25, 0, 0));
                    comp24.add(botao24);
                    comp24.setOpaque(false);
                //===============================================

                comp2.add(comp21);
                comp2.add(comp22);
                comp2.add(comp23);
                comp2.add(comp24);
                comp2.setOpaque(false);
            //===============================================

            // body.add(comp1);
            // body.add(comp2);
        //===============================================
            botao21.addActionListener(this);
            botao22.addActionListener(this);
            botao23.addActionListener(this);
            botao24.addActionListener(this);
            voltar.addActionListener(this);
        //===============================
        //this.add(body);
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        //this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao21) { //cadastrar
            home.mudaPainel(9);
        } else if(e.getSource() == botao22) { //mostrar relatorio
            new DialogRelatorioVenda(catalogoParticipantes);
        } else if(e.getSource() == botao23) { //remover dados
            home.mudaPainel(12);
        } else if(e.getSource() == botao24) { //consultar maior
            new DialogMaiorValorVenda(catalogoParticipantes);
        } else if(e.getSource() == voltar) { //voltar
            home.mudaPainel(0);
        }
    }
}
