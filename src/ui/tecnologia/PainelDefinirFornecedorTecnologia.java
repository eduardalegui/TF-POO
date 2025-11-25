package src.ui.tecnologia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;
import src.ui.DialogMensagens;
import src.entidades.*;
import src.ui.HomePage;


public class PainelDefinirFornecedorTecnologia extends JPanel implements ActionListener {
    private JButton botao1= new JButton("Enviar");
    private JButton botao2= new JButton("Limpar");
    private JButton voltar = new JButton("Voltar");
    private JTextField campTexto1 = new JTextField(15);
    private JTextField campTexto2 = new JTextField(15);
    private JTextField campTexto3 = new JTextField(15);
    private JTextField campTexto4 = new JTextField(15);
    private JTextField campTexto5 = new JTextField(15);
    private JTextField campTexto6 = new JTextField(15);
    private DefaultComboBoxModel<String> modeloIds;
    private JComboBox<String> selecionaArea;
    private CatalogoParticipantes catalogoParticipantes;
    private HomePage home;

    public PainelDefinirFornecedorTecnologia(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.catalogoParticipantes = catalogoParticipantes;
        modeloIds = new DefaultComboBoxModel<>();
        adicionaComboBoxNomes();
        selecionaArea = new JComboBox<>(modeloIds);
        this.setSize(1200,700);
        Color corFundo = new Color(238, 236, 194);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBackground(corFundo);
        this.setLayout(layout);
        //===============================================
            this.home = home;
            Color azul = new Color(0, 100, 250);
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, azul);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 52));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 15, 0));
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
                JLabel titulo = new JLabel("DEFINIR FORNECEDOR DE TECNOLOGIA");
                comp1.setLayout(layout11);
                comp1.setBackground(azul);
                comp1.setOpaque(true);
                comp1.setMaximumSize(new Dimension(1200, 300));
                titulo.setFont(new Font("SansSerif", Font.BOLD, 50));
                comp1.add(titulo);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                GridLayout layout2 = new GridLayout(2,1);
                comp2.setLayout(layout2);
                comp2.setMaximumSize(new Dimension(900, 400));
                comp2.setOpaque(false);
                comp2.setBorder(BorderFactory.createEmptyBorder(100, 0, 100, 140));
                FlowLayout  layout1 = new FlowLayout(FlowLayout.RIGHT);
                MatteBorder bordaCampTexto = new MatteBorder(0, 0, 2, 0, azul);
                Font fontDosTitulos = new Font("SansSerif", Font.BOLD, 30);
                Font fontDosCampTexto = new Font("SansSerif", Font.PLAIN, 30);
                //===============================================
                    JPanel comp21 = new JPanel();
                    JLabel tituloID = new JLabel("ID da tecnologia: ");
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
                    JPanel comp4 = new JPanel();
                    JLabel tituloFornecedor = new JLabel("Fornecedor: ");
                    tituloFornecedor.setFont(fontDosTitulos);
                    selecionaArea.setPreferredSize(new Dimension(375, 35));
                    selecionaArea.setFont(fontDosCampTexto);
                    comp4.setBorder(BorderFactory.createEmptyBorder(5, 190, 0, 0));
                    comp4.setLayout(layout1);
                    comp4.add(tituloFornecedor);
                    comp4.add(selecionaArea);
                    comp4.setFont(fontDosTitulos);
                    comp4.setOpaque(false);
                //===============================================
                comp2.add(comp21);
                comp2.add(comp4);
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
                comp3.setBorder(BorderFactory.createEmptyBorder(5, 0, 60, 0));
                comp3.add(botao1);
                comp3.add(botao2);                
            //===============================================
            botao1.addActionListener(this);
            botao2.addActionListener(this);
            voltar.addActionListener(this);
        //=====================================
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        this.add(comp3);
        setVisible(true); // ultima linha!!!
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao1) { //enviar
            String id = campTexto1.getText();
            String fornecedorT = (String) selecionaArea.getSelectedItem();
            Fornecedor f = null;
            Fornecedor fornecedor = null;
            for (Participante participante : catalogoParticipantes.getParticipantes()) {
                if (participante instanceof Fornecedor) {
                    fornecedor = (Fornecedor) participante;
                    if (fornecedorSelecionado == participante.getCod()) {
                        f = fornecedor;
                    }
                }
            }

            f.de
        } else if(e.getSource() == botao2) { //limpar
            limpar();
        } else if(e.getSource() == voltar) { //volta
            limpar();
            home.mudaPainel(3);
        }
    }

    public void adicionaComboBoxNomes(){
        for (String id : catalogoParticipantes.getArrayIdsFornecedores()) {
            modeloIds.addElement(id);
        }
    }

    public void limpar(){
        campTexto1.setText("");
    }
}
