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
        GridBagLayout layout1 = new GridBagLayout();
        Font fontAreaTexto = new Font("SansSerif", Font.BOLD, 16);
        JLabel areaTexto = new JLabel(msg);
        JPanel comp4 = new JPanel();
        areaTexto.setFont(fontAreaTexto);
        comp4.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        comp4.setLayout(layout1);
        comp4.setBackground(corFundo);
        comp4.add(areaTexto);
        this.add(comp4);
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true); // ultima linha!!!
    }
}
