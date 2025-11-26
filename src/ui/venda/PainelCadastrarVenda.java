package src.ui.venda;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;
import src.ui.DialogMensagens;
import src.ui.HomePage;

public class PainelCadastrarVenda extends JPanel implements ActionListener {
    private CatalogoParticipantes catalogoParticipantes;
    private JButton voltar = new JButton("Voltar");
    private JButton botao1= new JButton("Enviar");
    private JButton botao2= new JButton("Limpar");
    private JTextField campTexto1 = new JTextField(20);
    private JTextField campTexto2 = new JTextField(20);
    private DefaultComboBoxModel<String> modeloNomes;
    private DefaultComboBoxModel<String> modeloIds;
    private JComboBox<String> selecionaComprador;
    private JComboBox<String> selecionaTecnologia;
    private HomePage home;

    public PainelCadastrarVenda(HomePage home, CatalogoParticipantes catalogoParticipantes){
        super();
        this.home = home;
        this.catalogoParticipantes = catalogoParticipantes;
        modeloNomes = new DefaultComboBoxModel<>();
        modeloIds = new DefaultComboBoxModel<>();
        adicionaComboBoxNomes();
        adicionaComboBoxIds();
        selecionaComprador = new JComboBox<>(modeloNomes);
        selecionaTecnologia = new JComboBox<>(modeloIds);
        Color corFundo = new Color(238, 236, 194);
        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBackground(corFundo);
        this.setLayout(layout);
        //===============================================
            Color amarelo = new Color(255, 194, 62);
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            MatteBorder bordaBotaoVoltar = new MatteBorder(2,2, 2, 2, amarelo);
            FlowLayout  layoutB = new FlowLayout(FlowLayout.LEFT);
            JPanel botaoVoltar = new JPanel();
            botaoVoltar.setMaximumSize(new Dimension(1200, 52));
            botaoVoltar.setBorder(BorderFactory.createEmptyBorder(10, 10, 25, 0));
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
                JLabel titulo = new JLabel("CADASTRAR VENDA");
                comp1.setLayout(layout11);
                comp1.setBackground(amarelo);
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
                MatteBorder bordaBotoes = new MatteBorder(0, 5, 0, 5, corFundo);
                FlowLayout  layout21 = new FlowLayout(FlowLayout.CENTER);                
                botao1.setPreferredSize(new Dimension(150, 60));
                botao1.setBorder(bordaBotoes);
                botao1.setBackground(amarelo);
                botao1.setFont(fontBotoes);
                botao2.setPreferredSize(new Dimension(150, 60));
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
            botao1.addActionListener(this);
            botao2.addActionListener(this);
            voltar.addActionListener(this);
        //===============================================
        this.add(botaoVoltar);
        this.add(comp1);
        this.add(comp2);
        this.add(comp3);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == voltar) { //voltar
            limpar();
            home.mudaPainel(4);
        } else if(e.getSource() == botao1) { //enviar
            String compradorSelecionado = (String) selecionaComprador.getSelectedItem();
            String tecnologiaSelec = (String) selecionaTecnologia.getSelectedItem();
            long tecnologiaSelecionada = Long.parseLong(tecnologiaSelec);
            String date = campTexto2.getText();
            String num = campTexto1.getText();
            Comprador comprador = null;
            Comprador c = null;
            if(catalogoParticipantes.getParticipantes().isEmpty()){
                System.out.println("Catalago vazio");
                return;
            }
            for (Participante participante : catalogoParticipantes.getParticipantes()) {
                if(participante instanceof Comprador){
                    comprador = (Comprador) participante;
                    if(compradorSelecionado.equals(comprador.getNome())){
                        c = comprador;
                    }
                }
            }
            String msg = catalogoParticipantes.cadastrarVenda(num, date, c, achaTecnologia(tecnologiaSelecionada));
            new DialogMensagens(msg);
            
        } else if(e.getSource() == botao2) { //limpar
            limpar();
        }
    }

    public void limpar(){
        campTexto2.setText("");
        campTexto1.setText("");
    }

    public Tecnologia achaTecnologia(long tecnologiaSelecionada){
        Fornecedor fornecedor = null;
        Tecnologia tecnologia = null;
        for (Participante participante : catalogoParticipantes.getParticipantes()) {
            if(participante instanceof Fornecedor){
                fornecedor = (Fornecedor) participante;
                for (Tecnologia tec : fornecedor.getArrayTecnologia()){
                    if(tec.getId() == tecnologiaSelecionada){
                        tecnologia = tec;
                        return tecnologia;
                    }
                }
                
            }
        }
        return null;
    }

    public void adicionaComboBoxNomes(){
        for (String nome : catalogoParticipantes.getArrayNomesCompradores()) {
            modeloNomes.addElement(nome);
        }
    }
    public void adicionaComboBoxIds(){
        for (String id : catalogoParticipantes.getIdsTecnologias()) {
            modeloIds.addElement(id);
        }
    }
}
