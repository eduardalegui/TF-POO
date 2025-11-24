package src.ui.tecnologia;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.CatalogoParticipantes;
import src.entidades.Fornecedor;
import src.entidades.Participante;
import src.entidades.Tecnologia;


public class DialogRelatorioTecnologia extends JDialog{
    private CatalogoParticipantes catalogoParticipantes;
    public DialogRelatorioTecnologia(CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        this.setSize(700,500);            
        Color corFundo = new Color(238, 236, 194);
        Color azul = new Color(0, 100, 250);
        Font fontBotoes = new Font("SansSerif", Font.BOLD, 30);
        MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, azul);
        JPanel botaoVoltar = new JPanel();
        BoxLayout layout = new BoxLayout(botaoVoltar, BoxLayout.Y_AXIS);
        GridBagLayout layout11 = new GridBagLayout();
        botaoVoltar.setMaximumSize(new Dimension(700, 500));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        botaoVoltar.setOpaque(true);
        botaoVoltar.setLayout(layout);
        botaoVoltar.setBackground(corFundo);
        JPanel comp1 = new JPanel();
        JLabel titulo = new JLabel("RELATÓRIO TECNOLOGIA");
        comp1.setBackground(azul);
        comp1.setOpaque(true);
        comp1.setMaximumSize(new Dimension(700, 40));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 23));
        comp1.add(titulo);
        JPanel comp4 = new JPanel();
        JTextArea areaTexto = new JTextArea(20, 55);
        areaTexto.setText(mostrarRelatorio());
        MatteBorder bordaAreaTexto = new MatteBorder(2, 2, 2, 2, azul);
        Font fontAreaTexto = new Font("SansSerif", Font.BOLD, 15);
        areaTexto.setBorder(bordaAreaTexto);
        areaTexto.setFont(fontAreaTexto);
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);
        comp4.setLayout(layout11);
        areaTexto.setBackground(corFundo);
        comp4.setOpaque(false);
        JScrollPane scrollar = new JScrollPane(areaTexto);
        comp4.add(scrollar);
        botaoVoltar.add(comp1);
        botaoVoltar.add(comp4);
        this.add(botaoVoltar);
        this.setLocationRelativeTo(null);
        setVisible(true); // ultima linha!!
    }
    
    public String mostrarRelatorio(){
        List<Tecnologia> tecnologias = new ArrayList<>();
        String retorno = "";
        for(Participante p : catalogoParticipantes.getParticipantes()){
            if(p instanceof Fornecedor){
                Fornecedor f = (Fornecedor) p;
                for(Tecnologia t : f.getArrayTecnologia()) {
                    tecnologias.add(t);
                }
            }
        }
        for(Tecnologia t : catalogoParticipantes.getTecnologiasSemFornecedor()) {
            tecnologias.add(t);
        }
        if(tecnologias.isEmpty()) {
            return "Não existem tecnologias cadastradas";
        }
        Collections.sort(tecnologias, Comparator.comparing(Tecnologia::getId));
        for(Tecnologia t : tecnologias) {
            retorno = retorno + t.geraDescricao() + "\n" + "\n";
        }
        return retorno;
    }
}