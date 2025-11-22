package src.ui.tecnologia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;
import src.ui.HomePage;


public class PainelCadastrarTecnologia extends JPanel implements ActionListener {
    private JButton botao1= new JButton("Enviar");
    private JButton botao2= new JButton("Limpar");
    private JButton voltar = new JButton("Voltar");
    private JTextField campTexto1 = new JTextField(15);
    private JTextField campTexto2 = new JTextField(15);
    private JTextField campTexto3 = new JTextField(15);
    private JTextField campTexto4 = new JTextField(15);
    private JTextField campTexto5 = new JTextField(15);
    private JTextField campTexto6 = new JTextField(15);
    private JComboBox<String> selecionaArea = new JComboBox<>(new String[]{"101", "404", "555", "202", "303"});
    private CatalogoParticipantes catalogoParticipantes;
    private HomePage home;

    public PainelCadastrarTecnologia(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        this.setSize(1200,700);
        //this.setTitle("Cadastrar Tecnologia"); // nome da janela
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
            Color azul = new Color(0, 100, 250);
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, azul);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 52));
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
                JLabel titulo = new JLabel("CADASTRAR TECNOLOGIA");
                comp1.setLayout(layout11);
                comp1.setBackground(azul);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(1200, 10000));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.add(titulo);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                GridLayout layout2 = new GridLayout(7,1);
                comp2.setLayout(layout2);
                comp2.setMaximumSize(new Dimension(900, 1000));
                comp2.setOpaque(false);
                comp2.setBorder(BorderFactory.createEmptyBorder(10, 000, 0, 140));
                FlowLayout  layout1 = new FlowLayout(FlowLayout.RIGHT);
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, azul);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);

                //===============================================
                    JPanel comp21 = new JPanel();
                    JLabel tituloID = new JLabel("ID: ");
                    //JTextField campTexto1 = new JTextField(15);
                    tituloID.setFont(fontDosTitulos);
                    campTexto1.setOpaque(false);
                    campTexto1.setBorder(bordaCampTexto);
                    campTexto1.setFont(fontDosCampTexto);
                    comp21.setLayout(layout1);
                    comp21.add(tituloID);
                    comp21.add(campTexto1);
                    comp21.setFont(fontDosTitulos);
                    comp21.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp22 = new JPanel();
                    JLabel tituloModelo = new JLabel("Modelo: ");
                    //JTextField campTexto2 = new JTextField(15);
                    tituloModelo.setFont(fontDosTitulos);
                    campTexto2.setOpaque(false);
                    campTexto2.setBorder(bordaCampTexto);
                    campTexto2.setFont(fontDosCampTexto);
                    comp22.setLayout(layout1);
                    comp22.add(tituloModelo);
                    comp22.add(campTexto2);
                    comp22.setFont(fontDosTitulos);
                    comp22.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp23 = new JPanel();
                    JLabel tituloDescricao = new JLabel("Descrição: ");
                    //JTextField campTexto3 = new JTextField(15);
                    tituloDescricao.setFont(fontDosTitulos);
                    campTexto3.setOpaque(false);
                    campTexto3.setBorder(bordaCampTexto);
                    campTexto3.setFont(fontDosCampTexto);
                    comp23.setLayout(layout1);
                    comp23.add(tituloDescricao);
                    comp23.add(campTexto3);
                    comp23.setFont(fontDosTitulos);
                    comp23.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp24 = new JPanel();
                    JLabel tituloValorBase = new JLabel("Valor Base: ");
                    //JTextField campTexto4 = new JTextField(15);
                    tituloValorBase.setFont(fontDosTitulos);
                    campTexto4.setOpaque(false);
                    campTexto4.setBorder(bordaCampTexto);
                    campTexto4.setFont(fontDosCampTexto);
                    comp24.setLayout(layout1);
                    comp24.add(tituloValorBase);
                    comp24.add(campTexto4);
                    comp24.setFont(fontDosTitulos);
                    comp24.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp25 = new JPanel();
                    JLabel tituloPeso = new JLabel("Peso: ");
                    //JTextField campTexto5 = new JTextField(15);
                    tituloPeso.setFont(fontDosTitulos);
                    campTexto5.setOpaque(false);
                    campTexto5.setBorder(bordaCampTexto);
                    campTexto5.setFont(fontDosCampTexto);
                    comp25.setLayout(layout1);
                    comp25.add(tituloPeso);
                    comp25.add(campTexto5);
                    comp25.setFont(fontDosTitulos);
                    comp25.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp26 = new JPanel();
                    JLabel tituloTemperatura = new JLabel("Temperatura: ");
                    //JTextField campTexto6 = new JTextField(15);
                    tituloTemperatura.setFont(fontDosTitulos);
                    campTexto6.setOpaque(false);
                    campTexto6.setBorder(bordaCampTexto);
                    campTexto6.setFont(fontDosCampTexto);
                    comp26.setLayout(layout1);
                    comp26.add(tituloTemperatura);
                    comp26.add(campTexto6);
                    comp26.setFont(fontDosTitulos);
                    comp26.setOpaque(false);
                //===============================================

                comp2.add(comp21);
                comp2.add(comp22);
                comp2.add(comp23);
                comp2.add(comp24);
                comp2.add(comp25);
                comp2.add(comp26);
            //===============================================
            //===============================================
                JPanel comp3 = new JPanel();
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, corFundo);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);
                
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setOpaque(true);
                botao1.setBorder(bordaBotoes);
                botao1.setBackground(azul);
                botao1.setFont(fontBotoes);

                botao2.setPreferredSize(new Dimension(150, 60));
                botao2.setOpaque(true);
                botao2.setBorder(bordaBotoes);
                botao2.setBackground(azul);
                botao2.setFont(fontBotoes);

                comp3.setLayout(layout21);
                comp3.setMaximumSize(new Dimension(900, 200));
                comp3.setOpaque(false);
                comp3.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));
                comp3.add(botao1);
                comp3.add(botao2);
            //===============================================
            //===============================================
                //JComboBox<String> selecionaArea = new JComboBox<>(new String[]{"oi"});
                JPanel comp4 = new JPanel();
                JLabel tituloFornecedor = new JLabel("Fornecedor: ");
                tituloFornecedor.setFont(fontDosTitulos);
                selecionaArea.setPreferredSize(new Dimension(375, 35));
                selecionaArea.setFont(fontDosCampTexto);
                comp4.setBorder(BorderFactory.createEmptyBorder(5, 190, 0, 0));
                comp4.add(tituloFornecedor);
                comp4.add(selecionaArea);
                comp4.setFont(fontDosTitulos);
                comp4.setOpaque(false);
                comp2.add(comp4);
            //===============================================

            // body.add(comp1);
            // body.add(comp2);
            // body.add(comp3);
        //===============================================
            botao1.addActionListener(this);
            botao2.addActionListener(this);
            voltar.addActionListener(this);
        //=====================================
        //this.add(body);
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        this.add(comp3);
        //this.setLocationRelativeTo(null);
        setVisible(true); // ultima linha!!!
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao1) { //enviar
            String id = campTexto1.getText();
            String modelo = campTexto2.getText();
            String descricao = campTexto3.getText();
            String valorBase = campTexto4.getText();
            String peso = campTexto5.getText();
            String temperatura = campTexto6.getText();
            String fornecedorT = (String) selecionaArea.getSelectedItem();
            Fornecedor f = null;
            Fornecedor fornecedor = null;

            long fornecedorSelecionado = Long.parseLong(fornecedorT);

            for (Participante participante : catalogoParticipantes.getParticipantes()) {
                if (participante instanceof Fornecedor) {
                    fornecedor = (Fornecedor) participante;
                    if (fornecedorSelecionado == participante.getCod()) {
                        f = fornecedor;
                    }
                }
            }

            System.out.println(fornecedor.cadastrarTecnologia(id, modelo, descricao, valorBase, peso, temperatura, f));
        } else if(e.getSource() == botao2) { //limpar
            limpar();
        } else if(e.getSource() == voltar) { //volta
            limpar();
            home.mudaPainel(3);
        }
    }

    public void limpar(){
        campTexto1.setText("");
        campTexto2.setText("");
        campTexto3.setText("");
        campTexto4.setText("");
        campTexto5.setText("");
        campTexto6.setText("");
    }
}
