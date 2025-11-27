package src.ui.comprador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;

public class DialogDadosCompradorModificado extends JDialog{
    private CatalogoParticipantes catalogoParticipantes;
    private String stringCod;
    public DialogDadosCompradorModificado(CatalogoParticipantes catalogoParticipantes, String stringCod){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        this.stringCod = stringCod;
        this.setSize(700,500);            
        Color corFundo = new Color(238, 236, 194);
        Color vermelho = new Color(233, 37, 37);
        Font fontBotoes = new Font("SansSerif", Font.BOLD, 30);
        MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, vermelho);
        JPanel botaoVoltar = new JPanel();
        BoxLayout layout = new BoxLayout(botaoVoltar, BoxLayout.Y_AXIS);
        GridBagLayout layout11 = new GridBagLayout();
        botaoVoltar.setMaximumSize(new Dimension(700, 500));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        botaoVoltar.setLayout(layout);
        botaoVoltar.setBackground(corFundo);
        JPanel comp1 = new JPanel();
        JLabel titulo = new JLabel("DADOS ATUAIS DO COMPRADOR");
        comp1.setBackground(vermelho);
        comp1.setMaximumSize(new Dimension(700, 40));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 23));
        comp1.add(titulo);
        JPanel comp4 = new JPanel();
        JTextArea areaTexto = new JTextArea(20, 55);
        areaTexto.setText(mostrarRelatorio());
        MatteBorder bordaAreaTexto = new MatteBorder(2, 2, 2, 2, vermelho);
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
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.setVisible(true); // ultima linha!!!
    }

    public String mostrarRelatorio(){
        try {
            for(Participante p : catalogoParticipantes.getParticipantes()) {
                if(p instanceof Comprador) {
                    Comprador c = (Comprador) p;
                    long cod = Long.parseLong(stringCod);
                    if(c.getCod() == cod) {
                        return c.geraDescricao();
                    }
                }
            }
            return "Comprador não encontrado";
        } catch(Exception e) {
            return "Erro ao buscar o comprador";
        }
    }
}
