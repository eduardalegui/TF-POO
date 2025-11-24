package src.ui.venda;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.CatalogoParticipantes;
import src.entidades.Comprador;
import src.entidades.Participante;
import src.entidades.Venda;


public class DialogRelatorioVenda extends JDialog{
    private CatalogoParticipantes catalogoParticipantes;
    public DialogRelatorioVenda(CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        this.setSize(700,500);            
        Color corFundo = new Color(238, 236, 194);
        Color amarelo = new Color(255, 194, 62);
        Font fontBotoes = new Font("SansSerif", Font.BOLD, 30);
        MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, amarelo);
        JPanel botaoVoltar = new JPanel();
        BoxLayout layout = new BoxLayout(botaoVoltar, BoxLayout.Y_AXIS);
        GridBagLayout layout11 = new GridBagLayout();
        botaoVoltar.setMaximumSize(new Dimension(700, 500));
        botaoVoltar.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        botaoVoltar.setOpaque(true);
        botaoVoltar.setLayout(layout);
        botaoVoltar.setBackground(corFundo);
        JPanel comp1 = new JPanel();
        JLabel titulo = new JLabel("RELATÓRIO VENDA");
        comp1.setBackground(amarelo);
        comp1.setOpaque(true);
        comp1.setMaximumSize(new Dimension(700, 40));
        titulo.setFont(new Font("SansSerif", Font.BOLD, 23));
        comp1.add(titulo);
        JPanel comp4 = new JPanel();
        JTextArea areaTexto = new JTextArea(20, 55);
        areaTexto.setText(mostrarRelatorio());
        MatteBorder bordaAreaTexto = new MatteBorder(2, 2, 2, 2, amarelo);
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
        setVisible(true); // ultima linha!!
    }
    
    public String mostrarRelatorio(){
        List<Venda> vendas = new ArrayList<>();
        String retorno = "";
        for(Participante p : catalogoParticipantes.getParticipantes()){
            if(p instanceof Comprador){
                Comprador c = (Comprador) p;
                for(Venda v : c.getArrayVenda()) {
                    vendas.add(v);
                }
            }
        }
        if(vendas.isEmpty()) {
            return "Não existem vendas cadastradas";
        }
        Collections.sort(vendas, Comparator.comparing(Venda::getNum));
        for(int i = vendas.size() - 1; i >= 0; i--) {
            retorno = retorno + vendas.get(i).geraDescricao() + "\n" + "\n";
        }
        return retorno;
    }
}
