package src.ui.salvar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.aplicacao.ACMETech;
import src.ui.DialogMensagens;
import src.ui.HomePage;
import src.entidades.*;
import java.nio.file.*;

public class PainelCarregarDadosSalvarCarregar extends JPanel implements ActionListener{
    private JButton botao1;
    private JButton voltar;
    private HomePage home;
    private ACMETech acme;
    private JTextField campTexto4;
    private CatalogoParticipantes catalogoParticipantes;

    public PainelCarregarDadosSalvarCarregar(HomePage home, ACMETech acme, CatalogoParticipantes catalogoParticipantes){
        super();
        this.home = home;
        this.acme = acme;
        this.catalogoParticipantes = catalogoParticipantes;
        Color corFundo = new Color(238, 236, 194);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBackground(corFundo);
        this.setLayout(layout);
        //===============================================
            voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, Color.BLACK);
            MatteBorder bordaTitulo = new MatteBorder(4, 0, 4, 0, Color.BLACK);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 52));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 80, 0));
            voltar.setPreferredSize(new Dimension(100, 40));
            botaoVoltar.setOpaque(false);
            voltar.setBorder(bordaBotaoVoltar);
            voltar.setLayout(layoutB);
            botaoVoltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            botaoVoltar.add(voltar);
            //===============================================
                JPanel comp1 = new JPanel();
                GridBagLayout layout11 = new GridBagLayout();
                JLabel titulo = new JLabel("CARREGAR DADOS");
                comp1.setLayout(layout11);
                comp1.setBackground(corFundo);
                comp1.setMaximumSize(new Dimension(1200, 150));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.setBorder(bordaTitulo);
                comp1.add(titulo);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                FlowLayout  layout1 = new FlowLayout(FlowLayout.CENTER);
                comp2.setLayout(layout1);
                comp2.setMaximumSize(new Dimension(900, 300));
                comp2.setOpaque(false);
                comp2.setBorder(BorderFactory.createEmptyBorder(130, 140, 0, 140));
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, Color.BLACK);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);
                JLabel tituloCod = new JLabel("Nome: ");
                campTexto4 = new JTextField(18);
                campTexto4.setOpaque(false);
                campTexto4.setBorder(bordaCampTexto);
                campTexto4.setFont(fontDosCampTexto);
                tituloCod.setFont(fontDosTitulos);
                comp2.add(tituloCod);
                comp2.add(campTexto4);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                botao1 = new JButton("Confirmar");
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, Color.BLACK);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setBorder(bordaBotaoVoltar);
                botao1.setBackground(corFundo);
                botao1.setFont(fontBotoes);
                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 5, 0, 5));
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
            String nome = campTexto4.getText();
            String msg = acme.carregarDadosJson(nome);
            new DialogMensagens(msg);
        } else if(e.getSource() == voltar) { //voltar
            campTexto4.setText("");
            home.mudaPainel(5);
        } 
    }

    // public void adicionaComboBoxNomesArquivos() {
    //     Path pasta = Paths.get("src", "recursos");
    //     try (DirectoryStream<Path> caminho = Files.newDirectoryStream(pasta, "*.json")) {
    //         for (Path entrada : caminho) {
    //             modeloArquivos.addElement(entrada.getFileName().toString().substring(0, entrada.getFileName().toString().length() - 5));
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }
    // }
}
