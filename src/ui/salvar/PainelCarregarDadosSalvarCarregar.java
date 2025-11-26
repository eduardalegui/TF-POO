package src.ui.salvar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.aplicacao.ACMETech;
import src.ui.DialogMensagens;
import src.ui.HomePage;



public class PainelCarregarDadosSalvarCarregar extends JPanel implements ActionListener{
    private JButton botao1;
    //private JButton botao2;
    private JButton voltar;
    private HomePage home;
    private ACMETech acme;
    private JTextField campTexto4;
    private JComboBox<String> selecionaArea;

    public PainelCarregarDadosSalvarCarregar(HomePage home, ACMETech acme){
        super();
        //this.setSize(1200,700);
        //this.setTitle("Cadastrar Comprador"); // nome da janela
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        Color corFundo = new Color(238, 236, 194);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBackground(corFundo);
        this.setLayout(layout);
        //===============================================
        this.home = home;
        this.acme = acme;
        selecionaArea = new JComboBox<>();
            // JPanel body = new JPanel();
            // BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            // Color corFundo = new Color(238, 236, 194);
            
            voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, Color.BLACK);
            MatteBorder bordaTitulo = new MatteBorder(4, 0, 4, 0, Color.BLACK);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 20));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
            voltar.setPreferredSize(new Dimension(100, 40));
            botaoVoltar.setOpaque(false);
            voltar.setOpaque(true);
            voltar.setBorder(bordaBotaoVoltar);
            voltar.setLayout(layoutB);
            botaoVoltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            botaoVoltar.add(voltar);
            // body.add(botaoVoltar);
            // body.setLayout(layout);
            // body.setBackground(corFundo);
            // body.setOpaque(true); //não o torna tranparente
            // body.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            
            //===============================================
                JPanel comp1 = new JPanel();
                GridBagLayout layout11 = new GridBagLayout();
                JLabel titulo = new JLabel("CARREGAR DADOS");
                comp1.setLayout(layout11);
                comp1.setBackground(corFundo);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(1200, 300));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.setBorder(bordaTitulo);
                comp1.add(titulo);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                //GridLayout layout2 = new GridLayout(1,1);
                FlowLayout  layout1 = new FlowLayout(FlowLayout.CENTER);
                comp2.setLayout(layout1);
                //comp2.setMaximumSize(new Dimension(900, 300));
                comp2.setOpaque(false);
                comp2.setBorder(BorderFactory.createEmptyBorder(30, 140, 0, 140));
                
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, Color.BLACK);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);

                
                // //===============================================
                //===============================================
                    JPanel comp24 = new JPanel();
                    JLabel tituloCod = new JLabel("Nome: ");
                    selecionaArea.setPreferredSize(new Dimension(375, 35));
                    selecionaArea.setFont(fontDosCampTexto);
                    //campTexto4 = new JTextField(18);
                    tituloCod.setFont(fontDosTitulos);
                    // campTexto4.setOpaque(false);
                    // campTexto4.setBorder(bordaCampTexto);
                    // campTexto4.setFont(fontDosCampTexto);
                    comp24.setLayout(layout1);
                    comp24.add(tituloCod);
                    comp24.add(selecionaArea);
                    comp24.setFont(fontDosTitulos);
                    comp24.setOpaque(false);
                //===============================================

                //comp2.add(comp21);
                //comp2.add(comp22);
                comp2.add(comp24);
                //comp2.add(comp23);
                //comp2.add(comp25);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                botao1 = new JButton("Confirmar");
                //JButton botao2= new JButton("Limpar");
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, Color.BLACK);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setOpaque(true);
                botao1.setBorder(bordaBotaoVoltar);
                botao1.setBackground(corFundo);
                botao1.setFont(fontBotoes);

                // botao2.setPreferredSize(new Dimension(150, 60));
                // botao2.setOpaque(true);
                // botao2.setBorder(bordaBotoes);
                // botao2.setBackground(vermelho);
                // botao2.setFont(fontBotoes);

                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 5, 0, 5));
                comp3.add(botao1);
                //comp3.add(botao2);
            //===============================================

            // body.add(comp1);
            // body.add(comp2);
            // body.add(comp3);
        //===============================================
        botao1.addActionListener(this);
        //botao2.addActionListener(this);
        voltar.addActionListener(this);
        //==============================================
        //this.add(body);
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        this.add(comp3);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao1) { //confirmar
            String msg = acme.carregarDadosJson(campTexto4.getText());
            new DialogMensagens(msg);
        } else if(e.getSource() == voltar) { //voltar
            //campTexto4.setText("");
            home.mudaPainel(5);
        } 
    }
}
