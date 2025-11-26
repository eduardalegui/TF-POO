package src.ui.venda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import src.entidades.CatalogoParticipantes;
import src.ui.HomePage;


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
        this.catalogoParticipantes = catalogoParticipantes;
        this.home = home;
        //this.setSize(1200,700);
        this.setMinimumSize(new Dimension(1200, 700));
        Color corFundo = new Color(238, 236, 194);
        Color amarelo = new Color(255, 194, 62);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        //===============================================
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotao = new MatteBorder(2,2, 2, 2, amarelo);
            FlowLayout layoutB = new FlowLayout(FlowLayout.LEFT);
            voltar = new JButton("Voltar");
            voltar.setPreferredSize(new Dimension(100, 40));
            voltar.setBorder(bordaBotao);
            voltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
            botaoVoltar.setLayout(layoutB);
            botaoVoltar.add(voltar);
            botaoVoltar.setOpaque(false);
        //===============================================
        //=============================================== 
            Font fontTF = new Font("SansSerif", Font.BOLD, 60);
            FlowLayout layout11 = new FlowLayout(FlowLayout.CENTER);
            MatteBorder bordaTF = new MatteBorder(0, 0, 4, 0, amarelo);
            JLabel tituloTF = new JLabel("Métodos de Venda");
            tituloTF.setBorder(bordaTF);
            tituloTF.setFont(fontTF);
            JPanel comp1 = new JPanel();
            comp1.setLayout(layout11);
            comp1.setSize(1200,40);
            comp1.setBorder(BorderFactory.createEmptyBorder(80, 0, 0, 0));
            comp1.setOpaque(false);
            comp1.add(tituloTF);
        //===============================================
        //===============================================
            JPanel comp2 = new JPanel();
            comp2.setLayout(layout11);
            comp2.setMaximumSize(new Dimension(800, 200));
            comp2.setBorder(BorderFactory.createEmptyBorder(20, 0, 400, 0));
            EmptyBorder bordaComp = new EmptyBorder(0,25,20,25);
            Dimension dimensao = new Dimension(250, 100);
            //===============================================
                botao21= new JButton("Cadastrar");
                botao21.setPreferredSize(dimensao);
                botao21.setBorder(bordaBotao);
                botao21.setBackground(amarelo);
                botao21.setFont(fontBotoes);
                JPanel comp21 = new JPanel();
                comp21.setBorder(bordaComp);
                comp21.add(botao21);
                comp21.setOpaque(false);
            //===============================================
            //===============================================
                botao22= new JButton("Mostrar Relatório");
                botao22.setPreferredSize(dimensao);
                botao22.setBorder(bordaBotao);
                botao22.setBackground(amarelo);
                botao22.setFont(fontBotoes);
                JPanel comp22 = new JPanel();
                comp22.setBorder(bordaComp);
                comp22.add(botao22);
                comp22.setOpaque(false);
            //===============================================
            //===============================================
                botao23= new JButton("Remover Dados");
                botao23.setPreferredSize(dimensao);
                botao23.setBorder(bordaBotao);
                botao23.setBackground(amarelo);
                botao23.setFont(fontBotoes);
                JPanel comp23 = new JPanel();
                comp23.setBorder(bordaComp);
                comp23.add(botao23);
                comp23.setOpaque(false);
            //===============================================
            //===============================================
                botao24= new JButton("Consultar Maior");
                botao24.setPreferredSize(dimensao);
                botao24.setBorder(bordaBotao);
                botao24.setBackground(amarelo);
                botao24.setFont(fontBotoes);
                JPanel comp24 = new JPanel();
                comp24.setBorder(bordaComp);
                comp24.add(botao24);
                comp24.setOpaque(false);
            //===============================================
            comp2.add(comp21);
            comp2.add(comp22);
            comp2.add(comp23);
            comp2.add(comp24);
            comp2.setOpaque(false);
        //===============================================
        botao21.addActionListener(this);
        botao22.addActionListener(this);
        botao23.addActionListener(this);
        botao24.addActionListener(this);
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
