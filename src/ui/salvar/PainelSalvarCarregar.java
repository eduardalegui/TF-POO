package src.ui.salvar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import src.aplicacao.ACMETech;
import src.ui.HomePage;



public class PainelSalvarCarregar extends JPanel implements ActionListener{
    private JButton voltar;
    private JButton botao21;
    private JButton botao22;
    private HomePage home;
    private ACMETech acme;
    private JPanel botaoVoltar;
    private JPanel comp1;
    private JPanel comp2;
    private JPanel comp21;
    private JPanel comp22;
    private Color corFundo;
    private BoxLayout layout;
    private FlowLayout  layoutB;
    private FlowLayout  layout11;
    private MatteBorder bordaBotao;
    private MatteBorder bordaTF;
    private Font fontBotoes;
    private Font fontTF;
    private EmptyBorder bordaComp;
    private Dimension dimensao;
    private JLabel tituloTF;

    public PainelSalvarCarregar(HomePage home, ACMETech acme){
        super();
        this.acme = acme;
        this.home = home;
        //this.setSize(1200,700);
        this.setMinimumSize(new Dimension(1200, 700));
        corFundo = new Color(238, 236, 194);
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        //===============================================
            fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            bordaBotao = new MatteBorder(2,2, 2, 2, Color.BLACK);
            layoutB = new FlowLayout(FlowLayout.LEFT);
            voltar = new JButton("Voltar");
            voltar.setPreferredSize(new Dimension(100, 40));
            voltar.setBorder(bordaBotao);
            voltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            botaoVoltar = new JPanel();
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 90, 0));
            botaoVoltar.setLayout(layoutB);
            botaoVoltar.add(voltar);
            botaoVoltar.setOpaque(false);
        //===============================================
        //=============================================== 
            fontTF = new Font("SansSerif", Font.BOLD, 60);
            layout11 = new FlowLayout(FlowLayout.CENTER);
            bordaTF = new MatteBorder(0, 0, 4, 0, Color.BLACK);
            tituloTF = new JLabel("Métodos de Salvar/Carregar");
            tituloTF.setBorder(bordaTF);
            tituloTF.setFont(fontTF);
            comp1 = new JPanel();
            comp1.setLayout(layout11);
            comp1.setSize(1200,40);
            comp1.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
            comp1.setOpaque(false);
            comp1.add(tituloTF);
        //===============================================
        //===============================================
            comp2 = new JPanel();
            comp2.setLayout(layout11);
            comp2.setMaximumSize(new Dimension(800, 200));
            comp2.setBorder(BorderFactory.createEmptyBorder(20, 0, 400, 0));
            bordaComp = new EmptyBorder(0,25,20,25);
            dimensao = new Dimension(250, 100);
            //===============================================
                botao21= new JButton("Salvar Dados");
                botao21.setPreferredSize(dimensao);
                botao21.setBorder(bordaBotao);
                botao21.setBackground(corFundo);
                botao21.setFont(fontBotoes);
                comp21 = new JPanel();
                comp21.setBorder(bordaComp);
                comp21.add(botao21);
                comp21.setOpaque(false);
            //===============================================
            //===============================================
                botao22= new JButton("Carregar Dados");
                botao22.setPreferredSize(dimensao);
                botao22.setBorder(bordaBotao);
                botao22.setBackground(corFundo);
                botao22.setFont(fontBotoes);
                comp22 = new JPanel();
                comp22.setBorder(bordaComp);
                comp22.add(botao22);
                comp22.setOpaque(false);
            //===============================================
            comp2.add(comp21);
            comp2.add(comp22);
            comp2.setOpaque(false);
        //===============================================
        botao21.addActionListener(this);
        botao22.addActionListener(this);
        voltar.addActionListener(this);
        this.setBackground(corFundo);
        this.setLayout(layout);
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao21) { //Salvar Dados
            home.mudaPainel(13);
        } else if(e.getSource() == botao22) { //Carregar Dados
            home.mudaPainel(14);
        } else if(e.getSource() == voltar) { //consultar maior
            home.mudaPainel(0);
        } 
    }
}