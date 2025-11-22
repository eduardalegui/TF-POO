package src.ui.fornecedor;

import src.entidades.CatalogoParticipantes;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.util.*;




public class DialogRelatorioFornecedor extends JDialog{
    private CatalogoParticipantes catalogoParticipantes;
    public DialogRelatorioFornecedor(CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        this.setSize(700,500);
        this.setTitle("Relatório Fornecedor"); // nome da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        
        Color corFundo = new Color(238, 236, 194);
        Color vermelho = new Color(233, 37, 37);
        //JButton voltar = new JButton("Voltar");
        Font fontBotoes = new Font("SansSerif", Font.BOLD, 20);
        MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, vermelho);
        ////FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
        JPanel botaoVoltar = new JPanel();
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        //GridBagLayout layout11 = new GridBagLayout();
        botaoVoltar.setMaximumSize(new Dimension(700, 500));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        //voltar.setPreferredSize(new Dimension(100, 40));
        botaoVoltar.setOpaque(true);
        //voltar.setBorder(bordaBotaoVoltar);
        botaoVoltar.setLayout(layout);
        //voltar.setFont(fontBotoes);
        //voltar.setBackground(corFundo);
        //botaoVoltar.add(voltar);
        botaoVoltar.setBackground(corFundo);

                JPanel comp1 = new JPanel();
                JLabel titulo = new JLabel("RELATÓRIO FORNECEDOR");
                //comp1.setLayout(layout11);
                comp1.setBackground(vermelho);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(700, 40));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 10));
                comp1.add(titulo);

        //this.add(comp1);
        botaoVoltar.add(comp1);
        this.add(botaoVoltar);
        this.setLocationRelativeTo(null);
        setVisible(true); // ultima linha!!!

    }
    
    public List<String> mostrarRelatorio(){
        return catalogoParticipantes.mostrarRelatorioDeFornecedores();
    }
}
