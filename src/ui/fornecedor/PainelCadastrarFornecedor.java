package src.ui.fornecedor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;
import src.ui.DialogMensagens;
import src.ui.HomePage;


public class PainelCadastrarFornecedor extends JPanel implements ActionListener{
    private JButton botao1;
    private JButton botao2;
    private JButton voltar;
    private JTextField campTexto1 = new JTextField(20);
    private JTextField campTexto2 = new JTextField(20);
    private JTextField campTexto3 = new JTextField(20);
    private JComboBox<String> selecionaArea = new JComboBox<>(new String[]{"", "TI", "Androides", "Emergente", "Alimentos"});
    private HomePage home;
    private CatalogoParticipantes catalogoParticipantes;
    
    public PainelCadastrarFornecedor(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        //this.setSize(1200,700);
        //this.setTitle("Cadastrar Fornecedor"); // nome da janela
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
            Color verde = new Color(0, 150, 0);
            voltar = new JButton("Voltar");
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, verde);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 52));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 25, 0));
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
                    // JTextField campTexto1 = new JTextField(20);
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
                    // JTextField campTexto2 = new JTextField(20);
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
                    // JTextField campTexto3 = new JTextField(20);
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
                    //JComboBox<String> selecionaArea = new JComboBox<>(new String[]{"TI", "Androides", "Emergente", "Alimentos"});
                    JPanel comp24 = new JPanel();
                    JLabel tituloCod = new JLabel("Area: ");
                    selecionaArea.setPreferredSize(new Dimension(500, 50));
                    selecionaArea.setFont(fontDosCampTexto);
                    tituloCod.setFont(fontDosTitulos);
                    comp24.setLayout(layout1);
                    comp24.add(tituloCod);
                    comp24.add(selecionaArea);
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
                botao1= new JButton("Enviar");
                botao2= new JButton("Limpar");
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, corFundo);
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

                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
                comp3.add(botao1);
                comp3.add(botao2);
            //===============================================
            // body.add(comp1);
            // body.add(comp2);
            // body.add(comp3);
        //===============================================
        botao1.addActionListener(this);
        botao2.addActionListener(this);
        voltar.addActionListener(this);
        //===============================================
        //this.add(body);
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        this.add(comp3);
        //this.setLocationRelativeTo(null);
        setVisible(true); // ultima linha!!!
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao1) { //enviar
            String cod = campTexto1.getText();
            String nome = campTexto2.getText();
            String data = campTexto3.getText();
            String area = (String) selecionaArea.getSelectedItem();

            if(catalogoParticipantes.getParticipantes().isEmpty()){
                System.out.println("Catalago vazio");
                return;
            }
            String msg = catalogoParticipantes.cadastrarFornecedor(cod, nome, data, area);
            new DialogMensagens(msg);
        } else if(e.getSource() == botao2) { //limpar
            limpar();
        } else if(e.getSource() == voltar) { //voltar
            limpar();
            home.mudaPainel(2);
        } 
    }

    public void limpar(){
        campTexto1.setText("");
        campTexto2.setText("");
        campTexto3.setText("");
    }
}

