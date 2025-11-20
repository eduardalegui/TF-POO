package src.ui.comprador;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class PainelComprador extends JPanel{

    public PainelComprador(){
        super();
        this.setSize(1200,700);
        //this.setTitle("Comprador"); // nome da janela
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        //===============================================
            JPanel body = new JPanel();
            BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            Color corFundo = new Color(238, 236, 194);
            Color vermelho = new Color(233, 37, 37);
            JButton voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, vermelho);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            FlowLayout  layout11 = new FlowLayout(FlowLayout.CENTER);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 40));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(0, 10, 70, 0));
            voltar.setPreferredSize(new Dimension(100, 40));
            botaoVoltar.setOpaque(false);
            voltar.setOpaque(true);
            voltar.setBorder(bordaBotaoVoltar);
            voltar.setLayout(layoutB);
            botaoVoltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            botaoVoltar.add(voltar);
            body.add(botaoVoltar);
            body.setLayout(layout);
            body.setBackground(corFundo);
            body.setOpaque(true); //não o torna tranparente
            body.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

            //===============================================
                JPanel comp1 = new JPanel();
                MatteBorder bordaTF = new MatteBorder(0, 0, 4, 0, vermelho);
                JLabel tituloTF = new JLabel("Métodos de Comprador");
                Font fontTF = new Font("SansSerif", Font.BOLD, 60);
                tituloTF.setBorder(bordaTF);
                tituloTF.setFont(fontTF);
                comp1.add(tituloTF);
                comp1.setLayout(layout11);
                comp1.setSize(1200,40);
                comp1.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
                comp1.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                comp2.setLayout(layout11);
                comp2.setMaximumSize(new Dimension(800, 200));
                comp2.setBorder(BorderFactory.createEmptyBorder(20, 0, 400, 0));

                //===============================================
                    JPanel comp21 = new JPanel();
                    JButton botao21= new JButton("Cadastrar");
                    MatteBorder bordaBotoes21 = new MatteBorder(2, 2, 2, 2, vermelho);
                    botao21.setPreferredSize(new Dimension(250, 100));
                    botao21.setOpaque(true);
                    botao21.setBorder(bordaBotoes21);
                    botao21.setBackground(vermelho);
                    botao21.setFont(fontBotoes);
                    comp21.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 25));
                    comp21.add(botao21);
                    comp21.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp22 = new JPanel();
                    JButton botao22= new JButton("Mostrar Relatório");
                    MatteBorder bordaBotoes22 = new MatteBorder(2, 2, 2, 2, vermelho);
                    botao22.setPreferredSize(new Dimension(250, 100));
                    botao22.setOpaque(true);
                    botao22.setBorder(bordaBotoes22);
                    botao22.setBackground(vermelho);
                    botao22.setFont(fontBotoes);
                    comp22.setBorder(BorderFactory.createEmptyBorder(0, 25, 20, 0));
                    comp22.add(botao22);
                    comp22.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp23 = new JPanel();
                    JButton botao23= new JButton("Alterar Dados");
                    MatteBorder bordaBotoes23 = new MatteBorder(2, 2, 2, 2, vermelho);
                    botao23.setPreferredSize(new Dimension(250, 100));
                    botao23.setOpaque(true);
                    botao23.setBorder(bordaBotoes23);
                    botao23.setBackground(vermelho);
                    botao23.setFont(fontBotoes);
                    comp23.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 25));
                    comp23.add(botao23);
                    comp23.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp24 = new JPanel();
                    JButton botao24= new JButton("Consultar Maior");
                    MatteBorder bordaBotoes24 = new MatteBorder(2, 2, 2, 2, vermelho);
                    botao24.setPreferredSize(new Dimension(250, 100));
                    botao24.setOpaque(true);
                    botao24.setBorder(bordaBotoes24);
                    botao24.setBackground(vermelho);
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

            body.add(comp1);
            body.add(comp2);
        //===============================================
        this.add(body);
        //this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}

