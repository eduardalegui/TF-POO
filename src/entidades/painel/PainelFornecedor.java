package src.entidades.painel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;



public class PainelFornecedor extends JFrame{
    private JTextField campoTexto;
    private JButton botao;
    
    public PainelFornecedor(){
        super();
        this.setSize(1200,700);
        this.setTitle("Cadastrar Fornecedor"); // nome da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        
        //===============================================
            JPanel body = new JPanel();
            BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            Color corFundo = new Color(238, 236, 194);
            Color verde = new Color(0, 150, 0);
            body.setLayout(layout);
            body.setBackground(corFundo);
            body.setOpaque(true); //não o torna tranparente
            body.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
            
            //===============================================
                JPanel comp1 = new JPanel();
                GridBagLayout layout11 = new GridBagLayout();
                JLabel titulo = new JLabel("CADASTRAR FORNECEDOR");
                comp1.setLayout(layout11);
                comp1.setBackground(verde);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(1200, 150));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.add(titulo);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                GridLayout layout2 = new GridLayout(4,1);
                comp2.setLayout(layout2);
                comp2.setMaximumSize(new Dimension(900, 400));
                comp2.setOpaque(false);
                comp2.setBorder(BorderFactory.createEmptyBorder(40, 130, 0, 150));
                FlowLayout  layout1 = new FlowLayout(FlowLayout.RIGHT);
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, verde);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);

                //===============================================
                    JPanel comp21 = new JPanel();
                    JLabel tituloNome = new JLabel("Cod: ");
                    JTextField campTexto1 = new JTextField(20);
                    tituloNome.setFont(fontDosTitulos);
                    campTexto1.setOpaque(false);
                    campTexto1.setBorder(bordaCampTexto);
                    campTexto1.setFont(fontDosCampTexto);
                    comp21.setLayout(layout1);
                    comp21.add(tituloNome);
                    comp21.add(campTexto1);
                    comp21.setFont(fontDosTitulos);
                    comp21.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp22 = new JPanel();
                    JLabel tituloEmail = new JLabel("Nome: ");
                    JTextField campTexto2 = new JTextField(20);
                    tituloEmail.setFont(fontDosTitulos);
                    campTexto2.setOpaque(false);
                    campTexto2.setBorder(bordaCampTexto);
                    campTexto2.setFont(fontDosCampTexto);
                    comp22.setLayout(layout1);
                    comp22.add(tituloEmail);
                    comp22.add(campTexto2);
                    comp22.setFont(fontDosTitulos);
                    comp22.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp23 = new JPanel();
                    JLabel tituloPais = new JLabel("Data: ");
                    JTextField campTexto3 = new JTextField(20);
                    tituloPais.setFont(fontDosTitulos);
                    campTexto3.setOpaque(false);
                    campTexto3.setBorder(bordaCampTexto);
                    campTexto3.setFont(fontDosCampTexto);
                    comp23.setLayout(layout1);
                    comp23.add(tituloPais);
                    comp23.add(campTexto3);
                    comp23.setFont(fontDosTitulos);
                    comp23.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp24 = new JPanel();
                    JLabel tituloCod = new JLabel("Area: ");
                    JTextField campTexto4 = new JTextField(20);
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
                comp2.add(comp23);
                comp2.add(comp24);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                JButton botao1= new JButton("Confirmar");
                JButton botao2= new JButton("Limpar");
                JButton botao3= new JButton("Mostrar");
                JButton botao4= new JButton("Fechar");
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, corFundo);
                Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setOpaque(true);
                botao1.setBorder(bordaBotoes);
                botao1.setBackground(verde);
                botao1.setFont(fontBotoes);

                botao2.setPreferredSize(new Dimension(150, 60));
                botao2.setOpaque(true);
                botao2.setBorder(bordaBotoes);
                botao2.setBackground(verde);
                botao2.setFont(fontBotoes);

                botao3.setPreferredSize(new Dimension(150, 60));
                botao3.setOpaque(true);
                botao3.setBorder(bordaBotoes);
                botao3.setBackground(verde);
                botao3.setFont(fontBotoes);

                botao4.setPreferredSize(new Dimension(150, 60));
                botao4.setOpaque(true);
                botao4.setBorder(bordaBotoes);
                botao4.setBackground(verde);
                botao4.setFont(fontBotoes);

                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
                comp3.add(botao1);
                comp3.add(botao2);
                comp3.add(botao3);
                comp3.add(botao4);
            //===============================================
            //===============================================
                // JPanel comp4 = new JPanel();
                // JTextArea areaTexto = new JTextArea(10, 45);
                // MatteBorder bordaAreaTexto = new MatteBorder(2, 2, 2, 2, Color.RED);
                // Font fontAreaTexto = new Font("SansSerif", Font.BOLD, 15);
                // areaTexto.setBorder(bordaAreaTexto);
                // areaTexto.setFont(fontAreaTexto);
                // areaTexto.setLineWrap(true);
                // areaTexto.setWrapStyleWord(true);
                // comp4.setLayout(layout11);
                // comp4.setMaximumSize(new Dimension(1200, 210));
                // comp4.setOpaque(false);
                // JScrollPane scrollar = new JScrollPane(areaTexto);
                // comp4.add(scrollar);
            //===============================================

            body.add(comp1);
            body.add(comp2);
            body.add(comp3);
            //body.add(comp4);
        //===============================================
        this.add(body);
        setVisible(true); // ultima linha!!!
    }
}

