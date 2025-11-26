package src.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.*;

public class DialogMensagens extends JDialog{
    private JLabel tituloCod;
    public DialogMensagens(String msg){
        super();
        this.setSize(500,300);             
        Color corFundo = new Color(238, 236, 194);
        Color amarelo = new Color(255, 194, 62);
        JPanel botaoVoltar = new JPanel();
        BoxLayout layout = new BoxLayout(botaoVoltar, BoxLayout.Y_AXIS);
        GridBagLayout layout11 = new GridBagLayout();
        botaoVoltar.setLayout(layout);
        botaoVoltar.setBackground(corFundo);
        JPanel comp4 = new JPanel();
        JTextArea areaTexto = new JTextArea(9, 26);
        areaTexto.setText(msg);
        Font fontAreaTexto = new Font("SansSerif", Font.BOLD, 20);
        areaTexto.setFont(fontAreaTexto);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        comp4.setLayout(layout11);
        areaTexto.setBackground(corFundo);
        comp4.setOpaque(false);
        JScrollPane scrollar = new JScrollPane(areaTexto);
        areaTexto.setEditable(false);
        comp4.add(scrollar);
        botaoVoltar.add(comp4);
        this.add(botaoVoltar);
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true); // ultima linha!!!
    }
}
