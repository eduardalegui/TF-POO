package src.ui.fornecedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import src.entidades.CatalogoParticipantes;
import src.ui.HomePage;
public class PainelFornecedor extends JPanel implements ActionListener{
    private JButton voltar;
    private JButton botao21;
    private JButton botao22;
    private JButton botao23;
    private JButton botao24;
    private HomePage home;
    private CatalogoParticipantes catalogoParticipantes;

    public PainelFornecedor(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        this.home = home;
        Color corFundo = new Color(238, 236, 194);
        Color verde = new Color(0, 150, 0);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        //===============================================
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotao = new MatteBorder(2,2, 2, 2, verde);
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
            MatteBorder bordaTF = new MatteBorder(0, 0, 4, 0, verde);
            JLabel tituloTF = new JLabel("Métodos de Fornecedor");
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
                botao21.setBackground(verde);
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
                botao22.setBackground(verde);
                botao22.setFont(fontBotoes);
                JPanel comp22 = new JPanel();
                comp22.setBorder(bordaComp);
                comp22.add(botao22);
                comp22.setOpaque(false);
            //===============================================
            //===============================================
                botao23= new JButton("Consultar Maior");
                botao23.setPreferredSize(dimensao);
                botao23.setBorder(bordaBotao);
                botao23.setBackground(verde);
                botao23.setFont(fontBotoes);
                JPanel comp23 = new JPanel();
                comp23.setBorder(bordaComp);
                comp23.add(botao23);
                comp23.setOpaque(false);
            //===============================================
            comp2.add(comp21);
            comp2.add(comp22);
            comp2.add(comp23);
            comp2.setOpaque(false);
        //===============================================
        botao21.addActionListener(this);
        botao22.addActionListener(this);
        botao23.addActionListener(this);
        voltar.addActionListener(this);
        this.setBackground(corFundo);
        this.setLayout(layout);
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao21) { //cadastrar
            home.mudaPainel(6);
        } else if(e.getSource() == botao22) { //mostrar relatorio
            new DialogRelatorioFornecedor(catalogoParticipantes);
        } else if(e.getSource() == botao23) { //consultar maior
            new DialogMaiorValorFornecedor(catalogoParticipantes);
        } else if(e.getSource() == voltar) {
            home.mudaPainel(0);
        }
    }

    
}
