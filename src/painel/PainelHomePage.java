package src.painel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;


public class PainelHomePage extends JFrame {

    public PainelHomePage(){
        super();
        this.setSize(1200,700);
        this.setTitle("TF_POO"); // nome da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        //===============================================
            JPanel body = new JPanel();
            BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            Color corFundo = new Color(238, 236, 194);
            Color azul = new Color(0, 100, 250);
            Color verde = new Color(0, 150, 0);
            Color roxo = new Color(136, 126, 174);
            Color amarelo = new Color(255, 194, 62);
            body.setLayout(layout);
            body.setBackground(corFundo);
            body.setOpaque(true); //não o torna tranparente
            body.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            //===============================================
                JPanel comp1 = new JPanel();
                GridLayout layout1 = new GridLayout(3,1);
                FlowLayout  layout11 = new FlowLayout(FlowLayout.CENTER);
                Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                comp1.setLayout(layout1);
                comp1.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
                
                
                //===============================================
                    JPanel comp11 = new JPanel();
                    MatteBorder bordaTF = new MatteBorder(0, 0, 4, 0, Color.RED);
                    JLabel tituloTF = new JLabel("Traalho Final");
                    Font fontTF = new Font("SansSerif", Font.BOLD, 40);
                    tituloTF.setBorder(bordaTF);
                    tituloTF.setFont(fontTF);
                    comp11.add(tituloTF);
                    comp11.setLayout(layout11);
                    //comp11.setMaximumSize(new Dimension(100, 30));
                    comp11.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                    comp11.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp12 = new JPanel();
                    MatteBorder bordaDE = new MatteBorder(0, 0, 4, 0, verde);
                    JLabel tituloDE = new JLabel("de");
                    Font fontDE = new Font("SansSerif", Font.BOLD, 30);
                    tituloDE.setBorder(bordaDE);
                    tituloDE.setFont(fontDE);
                    comp12.add(tituloDE);
                    comp12.setLayout(layout11);
                    //comp12.setMaximumSize(new Dimension(100, 20));
                    comp12.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                    comp12.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp13 = new JPanel();
                    MatteBorder bordaPOO = new MatteBorder(0, 0, 4, 0, azul);
                    JLabel tituloPOO = new JLabel("POO");
                    Font fontPOO = new Font("SansSerif", Font.BOLD, 50);
                    tituloPOO.setBorder(bordaPOO);
                    tituloPOO.setFont(fontPOO);
                    comp13.add(tituloPOO);
                    comp13.setLayout(layout11);
                    //comp13.setMaximumSize(new Dimension(100, 0));
                    comp13.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
                    comp13.setOpaque(false);
                //===============================================

                comp1.add(comp11);
                comp1.add(comp12);
                comp1.add(comp13);
                comp1.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                
                //===============================================
                    JPanel comp21 = new JPanel();
                    JButton botao21= new JButton("Comprador");
                    MatteBorder bordaBotoes21 = new MatteBorder(2, 2, 2, 2, Color.RED);
                    botao21.setPreferredSize(new Dimension(200, 100));
                    botao21.setOpaque(true);
                    botao21.setBorder(bordaBotoes21);
                    botao21.setBackground(Color.RED);
                    botao21.setFont(fontBotoes);
                    comp21.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                    comp21.add(botao21);
                    comp21.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp22 = new JPanel();
                    JButton botao22= new JButton("Fornecedor");
                    MatteBorder bordaBotoes22 = new MatteBorder(2, 2, 2, 2, verde);
                    botao22.setPreferredSize(new Dimension(200, 100));
                    botao22.setOpaque(true);
                    botao22.setBorder(bordaBotoes22);
                    botao22.setBackground(verde);
                    botao22.setFont(fontBotoes);
                    comp22.add(botao22);
                    comp22.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp23 = new JPanel();
                    JButton botao23= new JButton("Tecnologia");
                    MatteBorder bordaBotoes23 = new MatteBorder(2, 2, 2, 2, azul);
                    botao23.setPreferredSize(new Dimension(200, 100));
                    botao23.setOpaque(true);
                    botao23.setBorder(bordaBotoes23);
                    botao23.setBackground(azul);
                    botao23.setFont(fontBotoes);
                    comp23.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                    comp23.add(botao23);
                    comp23.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp24 = new JPanel();
                    JButton botao24= new JButton("Venda");
                    MatteBorder bordaBotoes24 = new MatteBorder(2, 2, 2, 2, amarelo);
                    botao24.setPreferredSize(new Dimension(200, 100));
                    botao24.setOpaque(true);
                    botao24.setBorder(bordaBotoes24);
                    botao24.setBackground(amarelo);
                    botao24.setFont(fontBotoes);
                    comp24.add(botao24);
                    comp24.setOpaque(false);
                //===============================================

                comp2.setLayout(layout21);
                comp2.setMaximumSize(new Dimension(900, 200));
                comp2.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
                comp2.add(comp21);
                comp2.add(comp22);
                comp2.add(comp23);
                comp2.add(comp24);
                comp2.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                MatteBorder bordaBotoes3 = new MatteBorder(2, 2, 2, 2, Color.BLACK);
                
                //===============================================
                    JPanel comp31 = new JPanel();
                    JButton botao31= new JButton("Salvar/Carregar");
                    botao31.setPreferredSize(new Dimension(150, 60));
                    botao31.setOpaque(true);
                    botao31.setBorder(bordaBotoes3);
                    botao31.setBackground(corFundo);
                    botao31.setFont(fontBotoes);
                    comp31.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                    comp31.add(botao31);
                    comp31.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp32 = new JPanel();
                    JButton botao32= new JButton("Sair");
                    botao32.setPreferredSize(new Dimension(150, 60));
                    botao32.setOpaque(true);
                    botao32.setBorder(bordaBotoes3);
                    botao32.setBackground(corFundo);
                    botao32.setFont(fontBotoes);
                    comp32.add(botao32);
                    comp32.setOpaque(false);
                //===============================================

                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
                comp3.add(comp31);
                comp3.add(comp32);
                comp3.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp4 = new JPanel();
                GridLayout layout4 = new GridLayout(1,3);
                Font nomes = new Font("SansSerif", Font.PLAIN, 20);
                comp4.setLayout(layout4);
                //===============================================
                    JPanel comp41 = new JPanel();
                    JLabel duda = new JLabel("Pedro Henrique Castilhos Fraga");
                    duda.setFont(nomes);
                    comp41.add(duda);
                    comp41.setLayout(layout11);
                    comp41.setOpaque(false);
                    //comp41.setMaximumSize(new Dimension(100, 20));
                //===============================================
                //===============================================
                    JPanel comp42 = new JPanel();
                    JLabel pe = new JLabel("Eduarda Pfitscher Leguisamo");
                    pe.setFont(nomes);
                    comp42.add(pe);
                    comp42.setLayout(layout11);
                    comp42.setOpaque(false);
                    //comp42.setMaximumSize(new Dimension(100, 20));
                //===============================================
                //===============================================
                    JPanel comp43 = new JPanel();
                    JLabel lu = new JLabel("Lucas Lourenço Jacchetti");
                    lu.setFont(nomes);
                    comp43.add(lu);
                    comp43.setLayout(layout11);
                    comp43.setOpaque(false);
                    //comp43.setMaximumSize(new Dimension(100, 20));
                //===============================================
                comp4.add(comp41);
                comp4.add(comp42);
                comp4.add(comp43);
                comp4.setOpaque(false);
            //===============================================
            body.add(comp1);
            body.add(comp2);
            body.add(comp3);
            body.add(comp4);
        //===============================================
        this.add(body);
        this.setVisible(true);
    }
    
}
