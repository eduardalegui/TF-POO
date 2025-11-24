package src.ui.fornecedor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.CatalogoParticipantes;


public class DialogMaiorValorFornecedor extends JDialog{
    private CatalogoParticipantes catalogoParticipantes;
    public DialogMaiorValorFornecedor(CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        this.setSize(700,500);            
        Color corFundo = new Color(238, 236, 194);
        Color verde = new Color(0, 150, 0);
        Font fontBotoes = new Font("SansSerif", Font.BOLD, 30);
        MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, verde);
        JPanel botaoVoltar = new JPanel();
        BoxLayout layout = new BoxLayout(botaoVoltar, BoxLayout.Y_AXIS);
        GridBagLayout layout11 = new GridBagLayout();
        botaoVoltar.setMaximumSize(new Dimension(700, 500));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        botaoVoltar.setOpaque(true);
        botaoVoltar.setLayout(layout);
        botaoVoltar.setBackground(corFundo);
        JPanel comp1 = new JPanel();
        JLabel titulo = new JLabel("FORNECEDOR COM MAIOR NÚMERO DE TECNOLOGIAS");
        comp1.setBackground(verde);
        comp1.setOpaque(true);
        comp1.setMaximumSize(new Dimension(700, 40));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 23));
        comp1.add(titulo);
        JPanel comp4 = new JPanel();
        JTextArea areaTexto = new JTextArea(20, 55);
        areaTexto.setText(mostrarMaior());
        MatteBorder bordaAreaTexto = new MatteBorder(2, 2, 2, 2, verde);
        Font fontAreaTexto = new Font("SansSerif", Font.BOLD, 15);
        areaTexto.setBorder(bordaAreaTexto);
        areaTexto.setFont(fontAreaTexto);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        comp4.setLayout(layout11);
        areaTexto.setBackground(corFundo);
        comp4.setOpaque(false);
        JScrollPane scrollar = new JScrollPane(areaTexto);
        areaTexto.setEditable(false);
        comp4.add(scrollar);
        botaoVoltar.add(comp1);
        botaoVoltar.add(comp4);
        this.add(botaoVoltar);
        this.setLocationRelativeTo(null);
        setVisible(true); // ultima linha!!!
    }
    
    public String mostrarMaior(){
        return catalogoParticipantes.consultarFornecedorComMaisTecnologias();
    }
}