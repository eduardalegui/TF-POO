package src.ui.comprador;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class DialogRelatorioComprador extends JFrame{

    public DialogRelatorioComprador(){
        super();
        this.setSize(700,500);
        this.setTitle("Relatório Comprador"); // nome da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        
        Color corFundo = new Color(238, 236, 194);
        Color vermelho = new Color(233, 37, 37);
        JButton voltar = new JButton("Voltar");
        Font fontBotoes = new Font("SansSerif", Font.BOLD, 20);
        MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, vermelho);
        FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
        JPanel botaoVoltar = new JPanel();
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        botaoVoltar.setMaximumSize(new Dimension(600, 50));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 70, 0));
        voltar.setPreferredSize(new Dimension(100, 40));
        botaoVoltar.setOpaque(true);
        voltar.setBorder(bordaBotaoVoltar);
        botaoVoltar.setLayout(layoutB);
        voltar.setFont(fontBotoes);
        voltar.setBackground(corFundo);
        botaoVoltar.add(voltar);
        botaoVoltar.setBackground(corFundo);

                JPanel comp1 = new JPanel();
                //GridBagLayout layout11 = new GridBagLayout();
                JLabel titulo = new JLabel("RELATÓRIO COMPRADOR");
                //comp1.setLayout(layout11);
                comp1.setBackground(vermelho);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(600, 40));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 10));
                comp1.add(titulo);

        //this.add(comp1);
        this.add(botaoVoltar);
        this.setLocationRelativeTo(null);
        setVisible(true); // ultima linha!!!
    }

}
