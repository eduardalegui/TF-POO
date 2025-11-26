package src.ui.venda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;
import src.ui.DialogMensagens;
import src.ui.HomePage;



public class PainelRemoverDadosVenda extends JPanel implements ActionListener{
    private JButton botao1;
    //private JButton botao2;
    private JButton voltar;
    private HomePage home;
    private JTextField campTexto4;
    private CatalogoParticipantes catalogoParticipantes;

    public PainelRemoverDadosVenda(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        //this.setSize(1200,700);
        //this.setTitle("Cadastrar Comprador"); // nome da janela
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        Color corFundo = new Color(238, 236, 194);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBackground(corFundo);
        this.setLayout(layout);
        //===============================================
        this.home = home;
            // JPanel body = new JPanel();
            // BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            // Color corFundo = new Color(238, 236, 194);
            Color amarelo = new Color(255, 194, 62);
            voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, amarelo);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 52));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 70, 0));
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
                JLabel titulo = new JLabel("REMOVER DADOS DA VENDA");
                comp1.setLayout(layout11);
                comp1.setBackground(amarelo);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(1200, 150));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.add(titulo);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                GridLayout layout2 = new GridLayout(5,1);
                comp2.setLayout(layout2);
                comp2.setMaximumSize(new Dimension(900, 300));
                comp2.setOpaque(false);
                comp2.setBorder(BorderFactory.createEmptyBorder(30, 140, 0, 140));
                FlowLayout  layout1 = new FlowLayout(FlowLayout.RIGHT);
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, amarelo);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);

                // //===============================================
                     JPanel comp21 = new JPanel();
                //     JLabel tituloNome = new JLabel("Nome: ");
                //     JTextField campTexto1 = new JTextField(20);
                //     tituloNome.setFont(fontDosTitulos);
                //     campTexto1.setOpaque(false);
                //     campTexto1.setBorder(bordaCampTexto);
                //     campTexto1.setFont(fontDosCampTexto);
                //     comp21.setLayout(layout1);
                //     comp21.add(tituloNome);
                //     comp21.add(campTexto1);
                //     comp21.setFont(fontDosTitulos);
                    comp21.setOpaque(false);
                // //===============================================
                // //===============================================
                     JPanel comp22 = new JPanel();
                //     JLabel tituloEmail = new JLabel("Email: ");
                //     JTextField campTexto2 = new JTextField(20);
                //     tituloEmail.setFont(fontDosTitulos);
                //     campTexto2.setOpaque(false);
                //     campTexto2.setBorder(bordaCampTexto);
                //     campTexto2.setFont(fontDosCampTexto);
                //     comp22.setLayout(layout1);
                //     comp22.add(tituloEmail);
                //     comp22.add(campTexto2);
                //     comp22.setFont(fontDosTitulos);
                     comp22.setOpaque(false);
                // //===============================================
                // //===============================================
                    JPanel comp23 = new JPanel();
                    JPanel comp25 = new JPanel();
                //     JLabel tituloPais = new JLabel("Pais: ");
                //     JTextField campTexto3 = new JTextField(20);
                //     tituloPais.setFont(fontDosTitulos);
                //     campTexto3.setOpaque(false);
                //     campTexto3.setBorder(bordaCampTexto);
                //     campTexto3.setFont(fontDosCampTexto);
                //     comp23.setLayout(layout1);
                //     comp23.add(tituloPais);
                //     comp23.add(campTexto3);
                //     comp23.setFont(fontDosTitulos);
                     comp23.setOpaque(false);
                     comp25.setOpaque(false);
                // //===============================================
                //===============================================
                    JPanel comp24 = new JPanel();
                    JLabel tituloCod = new JLabel("Id: ");
                    campTexto4 = new JTextField(18);
                    tituloCod.setFont(fontDosTitulos);
                    campTexto4.setOpaque(false);
                    campTexto4.setBorder(bordaCampTexto);
                    campTexto4.setFont(fontDosCampTexto);
                    comp24.setLayout(layout1);
                    comp24.add(tituloCod);
                    comp24.add(campTexto4);
                    comp24.setFont(fontDosTitulos);
                    comp24.setOpaque(false);
                //===============================================

                comp2.add(comp21);
                comp2.add(comp22);
                comp2.add(comp24);
                comp2.add(comp23);
                comp2.add(comp25);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                botao1 = new JButton("Confirmar");
                //JButton botao2= new JButton("Limpar");
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, corFundo);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setOpaque(true);
                botao1.setBorder(bordaBotoes);
                botao1.setBackground(amarelo);
                botao1.setFont(fontBotoes);

                // botao2.setPreferredSize(new Dimension(150, 60));
                // botao2.setOpaque(true);
                // botao2.setBorder(bordaBotoes);
                // botao2.setBackground(vermelho);
                // botao2.setFont(fontBotoes);

                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
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
        Comprador comprador = null;
        if(e.getSource() == botao1) { //confirmar
            try {
                String stringNum = campTexto4.getText();
                long num = Long.parseLong(stringNum);
                List<Comprador> compradores = new ArrayList<>();
                for(Participante p : catalogoParticipantes.getParticipantes()) {
                    if(p instanceof Comprador) {
                        Comprador c = (Comprador) p;
                        compradores.add(c);
                    }
                }
                for(Comprador c : compradores) {
                    for(Venda v : c.getArrayVenda()) {
                        if(v.getNum() == num) {
                            comprador = c;
                        }
                    }
                }        
                String msg = comprador.removerOsDadosDeUmaDeterminadaVenda(stringNum);
                new DialogMensagens(msg);
            } catch(NumberFormatException exception) {
                new DialogMensagens("Id invalido");
            }  catch(NullPointerException ex){
                new DialogMensagens("ERRO: Id não encontrado");
            }
            
            
        } else if(e.getSource() == voltar) { //voltar
            campTexto4.setText("");
            home.mudaPainel(4);
        } 
    }
}
