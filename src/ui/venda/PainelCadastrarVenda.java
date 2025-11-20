package src.ui.venda;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class PainelCadastrarVenda extends JPanel{
    
    public PainelCadastrarVenda(){
        super();
        this.setSize(1200,700);
        //this.setTitle("Cadastrar Venda"); // nome da janela
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.
        //===============================================
            JPanel body = new JPanel();
            BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            Color corFundo = new Color(238, 236, 194);
            Color amarelo = new Color(255, 194, 62);
            JButton voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, amarelo);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 40));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(0, 10, 25, 0));
            voltar.setPreferredSize(new Dimension(100, 40));
            botaoVoltar.setOpaque(false);
            voltar.setOpaque(true);
            voltar.setBorder(bordaBotaoVoltar);
            voltar.setLayout(layoutB);
            botaoVoltar.setLayout(layoutB);
            voltar.setFont(fontBotoes);
            voltar.setBackground(corFundo);
            botaoVoltar.add(voltar);
            body.add(botaoVoltar);
            body.setLayout(layout);
            body.setBackground(corFundo);
            body.setOpaque(true); //não o torna tranparente
            body.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            
            //===============================================
                JPanel comp1 = new JPanel();
                GridBagLayout layout11 = new GridBagLayout();
                JLabel titulo = new JLabel("CADASTRAR VENDA");
                comp1.setLayout(layout11);
                comp1.setBackground(amarelo);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(1200, 150));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.add(titulo);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                GridLayout layout2 = new GridLayout(4,1);
                comp2.setLayout(layout2);
                comp2.setMaximumSize(new Dimension(1000, 400));
                comp2.setOpaque(false);
                comp2.setBorder(BorderFactory.createEmptyBorder(40, 130, 0, 150));
                FlowLayout  layout1 = new FlowLayout(FlowLayout.RIGHT);
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, amarelo);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);

                //===============================================
                    JPanel comp21 = new JPanel();
                    JLabel tituloNumero = new JLabel("Número: ");
                    JTextField campTexto1 = new JTextField(20);
                    tituloNumero.setFont(fontDosTitulos);
                    campTexto1.setOpaque(false);
                    campTexto1.setBorder(bordaCampTexto);
                    campTexto1.setFont(fontDosCampTexto);
                    comp21.setLayout(layout1);
                    comp21.add(tituloNumero);
                    comp21.add(campTexto1);
                    comp21.setFont(fontDosTitulos);
                    comp21.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp22 = new JPanel();
                    JLabel tituloData = new JLabel("Data: ");
                    JTextField campTexto2 = new JTextField(20);
                    tituloData.setFont(fontDosTitulos);
                    campTexto2.setOpaque(false);
                    campTexto2.setBorder(bordaCampTexto);
                    campTexto2.setFont(fontDosCampTexto);
                    comp22.setLayout(layout1);
                    comp22.add(tituloData);
                    comp22.add(campTexto2);
                    comp22.setFont(fontDosTitulos);
                    comp22.setOpaque(false);
                //===============================================
                //===============================================
                    JComboBox<String> selecionaComprador = new JComboBox<>(new String[]{"TI", "Androides", "Emergente", "Alimentos"});
                    JPanel comp23 = new JPanel();
                    JLabel tituloComprador = new JLabel("Comprador: ");
                    selecionaComprador.setPreferredSize(new Dimension(500, 50));
                    selecionaComprador.setFont(fontDosCampTexto);
                    tituloComprador.setFont(fontDosTitulos);
                    comp23.setLayout(layout1);
                    comp23.add(tituloComprador);
                    comp23.add(selecionaComprador);
                    comp23.setFont(fontDosTitulos);
                    comp23.setOpaque(false);
                //===============================================
                //===============================================
                    JComboBox<String> selecionaTecnologia = new JComboBox<>(new String[]{"TI", "Androides", "Emergente", "Alimentos"});
                    JPanel comp24 = new JPanel();
                    JLabel tituloTecnologia = new JLabel("Tecnologia: ");
                    selecionaTecnologia.setPreferredSize(new Dimension(500, 50));
                    selecionaTecnologia.setFont(fontDosCampTexto);
                    tituloTecnologia.setFont(fontDosTitulos);
                    comp24.setLayout(layout1);
                    comp24.add(tituloTecnologia);
                    comp24.add(selecionaTecnologia);
                    comp24.setFont(fontDosTitulos);
                    comp24.setOpaque(false);
                //===============================================

                comp2.add(comp22);
                comp2.add(comp21);
                comp2.add(comp23);
                comp2.add(comp24);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                JButton botao1= new JButton("Enviar");
                JButton botao2= new JButton("Limpar");
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, corFundo);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setOpaque(true);
                botao1.setBorder(bordaBotoes);
                botao1.setBackground(amarelo);
                botao1.setFont(fontBotoes);

                botao2.setPreferredSize(new Dimension(150, 60));
                botao2.setOpaque(true);
                botao2.setBorder(bordaBotoes);
                botao2.setBackground(amarelo);
                botao2.setFont(fontBotoes);

                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
                comp3.add(botao1);
                comp3.add(botao2);
            //===============================================

            body.add(comp1);
            body.add(comp2);
            body.add(comp3);
        //===============================================
        this.add(body);
        //this.setLocationRelativeTo(null);
        setVisible(true); // ultima linha!!!
    }
}
