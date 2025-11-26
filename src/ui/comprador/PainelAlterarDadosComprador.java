package src.ui.comprador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;
import src.ui.DialogMensagens;
import src.ui.HomePage;



public class PainelAlterarDadosComprador extends JPanel implements ActionListener{
    private JButton botao1;
    private JButton voltar;
    private HomePage home;
    private JTextField campTexto4;
    private CatalogoParticipantes catalogoParticipantes;

    public PainelAlterarDadosComprador(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        Color corFundo = new Color(238, 236, 194);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBackground(corFundo);
        this.setLayout(layout);
        this.home = home;
        //===============================================
            Color vermelho = new Color(233, 37, 37);
            voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, vermelho);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 52));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 85, 0));
            voltar.setPreferredSize(new Dimension(100, 40));
            botaoVoltar.setOpaque(false);
            voltar.setOpaque(true);
            voltar.setBorder(bordaBotaoVoltar);
            voltar.setLayout(layoutB);
            botaoVoltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            botaoVoltar.add(voltar);
            //===============================================
                JPanel comp1 = new JPanel();
                GridBagLayout layout11 = new GridBagLayout();
                JLabel titulo = new JLabel("ALTERAR DADOS DO COMPRADOR");
                comp1.setLayout(layout11);
                comp1.setBackground(vermelho);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(1200, 150));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.add(titulo);
            //===============================================
            //===============================================
                FlowLayout  layout1 = new FlowLayout(FlowLayout.CENTER);
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, vermelho);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);
                JLabel tituloCod = new JLabel("Código: ");
                tituloCod.setFont(fontDosTitulos);
                campTexto4 = new JTextField(18);
                campTexto4.setOpaque(false);
                campTexto4.setBorder(bordaCampTexto);
                campTexto4.setFont(fontDosCampTexto);
                JPanel comp2 = new JPanel();
                comp2.setBorder(BorderFactory.createEmptyBorder(130, 140, 0, 140));
                comp2.setLayout(layout1);
                comp2.setMaximumSize(new Dimension(900, 300));
                comp2.setOpaque(false);
                comp2.add(tituloCod);
                comp2.add(campTexto4);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                botao1 = new JButton("Confirmar");
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, corFundo);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setOpaque(true);
                botao1.setBorder(bordaBotoes);
                botao1.setBackground(vermelho);
                botao1.setFont(fontBotoes);
                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
                comp3.add(botao1);
            //===============================================
        botao1.addActionListener(this);
        voltar.addActionListener(this);
        //==============================================
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        this.add(comp3);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao1) { //confirmar
            String stringId = campTexto4.getText();
            if (validaId(stringId)) {
                home.mudaPainel(11);
            }
            else{
                new DialogMensagens("ERRO: Id inválido");
            }
            
        } else if(e.getSource() == voltar) { //voltar
            campTexto4.setText("");
            home.mudaPainel(1);
        } 
    }

    public boolean validaId(String stringId){
        try {
            long id = Long.parseLong(stringId);
            Comprador comprador = null;
            for (Participante p : catalogoParticipantes.getParticipantes()) {
                if (p instanceof Comprador) {
                    comprador = (Comprador) p;
                    if (comprador.getCod() == id) {
                        home.setidCompradorEscolhidoParaModificacao(id);
                        return true;
                    }
                }
            }
            return false;
            
        } catch (Exception e) {
            return false;
        }
    }
}
