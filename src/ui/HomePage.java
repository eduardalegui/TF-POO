package src.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import src.entidades.*;
import src.ui.comprador.*;
import src.ui.fornecedor.*;
import src.ui.salvar.*;
import src.ui.tecnologia.*;
import src.ui.venda.*;
import src.aplicacao.ACMETech;


public class HomePage extends JFrame implements ActionListener {
    private CatalogoParticipantes catalogoParticipantes;
    private ACMETech acme;
    private JButton botao21 = new JButton("Comprador");
    private JButton botao22 = new JButton("Fornecedor");
    private JButton botao23 = new JButton("Tecnologia");
    private JButton botao24 = new JButton("Venda");
    private JButton botao31 = new JButton("Salvar/Carregar");
    private JButton botao32 = new JButton("Sair");
    private PainelVenda painelVenda = new PainelVenda(this, catalogoParticipantes);
    private PainelTecnologia painelTecnologia = new PainelTecnologia(this, catalogoParticipantes);
    private PainelComprador painelComprador = new PainelComprador(this, catalogoParticipantes);
    private PainelFornecedor painelFornecedor = new PainelFornecedor(this, catalogoParticipantes);
    private PainelCadastrarComprador painelCadastrarComprador;
    private PainelCadastrarFornecedor painelCadastrarFornecedor;
    private PainelCadastrarTecnologia painelCadastrarTecnologia;
    private PainelCadastrarVenda painelCadastrarVenda;
    private PainelRemoverDadosVenda painelRemoverDadosVenda;
    private PainelSalvarCarregar painelSalvarCarregar;
    private PainelAlterarDadosComprador painelAlterarDadosComprador;
    private PainelModificarComprador painelModificarComprador;
    private PainelSalvarDadosSalvarCarregar painelSalvarDadosSalvarCarregar;
    private PainelCarregarDadosSalvarCarregar painelCarregarDadosSalvarCarregar;
    private long idCompradorEscolhidoParaModificacao;

    public long getidCompradorEscolhidoParaModificacao(){
        return idCompradorEscolhidoParaModificacao;
    }

    public void setidCompradorEscolhidoParaModificacao(long idCompradorEscolhidoParaModificacao){
        this.idCompradorEscolhidoParaModificacao = idCompradorEscolhidoParaModificacao;
    }
    // private DialogRelatorioComprador dialogRelatorioComprador = new DialogRelatorioComprador(catalogoParticipantes);
    // private DialogRelatorioFornecedor dialogRelatorioFornecedor = new DialogRelatorioFornecedor(catalogoParticipantes);
    // private DialogRelatorioTecnologia dialogRelatorioTecnologia = new DialogRelatorioTecnologia(catalogoParticipantes);
    // private DialogRelatorioVenda dialogRelatorioVenda = new DialogRelatorioVenda(catalogoParticipantes);
    private JPanel painelPrincipal;
    // public HomePage(int f){}
    public HomePage(CatalogoParticipantes catalogoParticipantes, ACMETech acme) {
        super();
        this.acme = acme;
        this.catalogoParticipantes = catalogoParticipantes;
        painelAlterarDadosComprador= new PainelAlterarDadosComprador(this, catalogoParticipantes);
        painelRemoverDadosVenda= new PainelRemoverDadosVenda(this, catalogoParticipantes);
        painelCadastrarVenda = new PainelCadastrarVenda(this, catalogoParticipantes);
        painelCadastrarComprador = new PainelCadastrarComprador(this, catalogoParticipantes);
        painelCadastrarFornecedor = new PainelCadastrarFornecedor(this, catalogoParticipantes);
        painelCadastrarTecnologia = new PainelCadastrarTecnologia(this, catalogoParticipantes);
        painelSalvarCarregar = new PainelSalvarCarregar(this, acme);
        painelModificarComprador = new PainelModificarComprador(this, catalogoParticipantes);
        painelSalvarDadosSalvarCarregar= new PainelSalvarDadosSalvarCarregar(this, acme);
        painelCarregarDadosSalvarCarregar= new PainelCarregarDadosSalvarCarregar(this, acme);
        this.setSize(1200,700);
        this.setTitle("TF_POO"); // nome da janela
        setDefaultCloseOperation(EXIT_ON_CLOSE); //o codigo para de rodar quando clica para fechar a janela.    
        //===============================================
            JPanel body = new JPanel();
            BoxLayout layout = new BoxLayout(body, BoxLayout.Y_AXIS);
            Color vermelho = new Color(233, 37, 37);
            Color corFundo = new Color(238, 236, 194);
            Color azul = new Color(0, 100, 250);
            Color verde = new Color(0, 150, 0);
            Color amarelo = new Color(255, 194, 62);
            FlowLayout  layout11 = new FlowLayout(FlowLayout.CENTER);
            Font fontBotoes = new Font("SansSerif", Font.BOLD, 25);
            body.setLayout(layout);
            body.setBackground(corFundo);
            body.setOpaque(true); //não o torna tranparente

            //===============================================
                JPanel comp11 = new JPanel();
                MatteBorder bordaTF = new MatteBorder(0, 0, 4, 0, vermelho);
                JLabel tituloTF = new JLabel("Trabalho Final");
                Font fontTF = new Font("SansSerif", Font.BOLD, 60);
                tituloTF.setBorder(bordaTF);
                tituloTF.setFont(fontTF);
                comp11.add(tituloTF);
                comp11.setLayout(layout11);
                comp11.setSize(1200,40);
                comp11.setBorder(BorderFactory.createEmptyBorder(60, 0, 0, 0));
                comp11.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp12 = new JPanel();
                MatteBorder bordaDE = new MatteBorder(0, 0, 4, 0, verde);
                JLabel tituloDE = new JLabel("de");
                Font fontDE = new Font("SansSerif", Font.BOLD, 50);
                tituloDE.setBorder(bordaDE);
                tituloDE.setFont(fontDE);
                comp12.add(tituloDE);
                comp12.setLayout(layout11);
                comp12.setSize(1200,30);
                comp12.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp13 = new JPanel();
                MatteBorder bordaPOO = new MatteBorder(0, 0, 4, 0, azul);
                JLabel tituloPOO = new JLabel("POO");
                Font fontPOO = new Font("SansSerif", Font.BOLD, 70);
                tituloPOO.setBorder(bordaPOO);
                tituloPOO.setFont(fontPOO);
                comp13.add(tituloPOO);
                comp13.setLayout(layout11);
                comp13.setSize(1200,50);
                comp13.setBorder(BorderFactory.createEmptyBorder(0, 0, 60, 0));
                comp13.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp2 = new JPanel();
                comp2.setLayout(layout11);
                comp2.setMaximumSize(new Dimension(900, 200));
                comp2.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

                //===============================================
                    JPanel comp21 = new JPanel();
                    //botao21= new JButton("Comprador");
                    MatteBorder bordaBotoes21 = new MatteBorder(2, 2, 2, 2, vermelho);
                    botao21.setPreferredSize(new Dimension(200, 100));
                    botao21.setOpaque(true);
                    botao21.setBorder(bordaBotoes21);
                    botao21.setBackground(vermelho);
                    botao21.setFont(fontBotoes);
                    comp21.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
                    comp21.add(botao21);
                    comp21.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp22 = new JPanel();
                    // botao22 = new JButton("Fornecedor");
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
                    // botao23 = new JButton("Tecnologia");
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
                    MatteBorder bordaBotoes24 = new MatteBorder(2, 2, 2, 2, amarelo);
                    botao24.setPreferredSize(new Dimension(200, 100));
                    botao24.setOpaque(true);
                    botao24.setBorder(bordaBotoes24);
                    botao24.setBackground(amarelo);
                    botao24.setFont(fontBotoes);
                    comp24.add(botao24);
                    comp24.setOpaque(false);
                //===============================================

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
                    botao31.setPreferredSize(new Dimension(230, 50));
                    botao31.setOpaque(true);
                    botao31.setBorder(bordaBotoes3);
                    botao31.setBackground(corFundo);
                    botao31.setFont(fontBotoes);
                    comp31.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 90));
                    comp31.add(botao31);
                    comp31.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp32 = new JPanel();
                    botao32.setPreferredSize(new Dimension(230, 50));
                    botao32.setOpaque(true);
                    botao32.setBorder(bordaBotoes3);
                    botao32.setBackground(corFundo);
                    botao32.setFont(fontBotoes);
                    comp32.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
                    comp32.add(botao32);
                    comp32.setOpaque(false);
                //===============================================

                comp3.setLayout(layout11);
                comp3.setMaximumSize(new Dimension(1200, 30));
                comp3.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
                comp3.add(comp31);
                comp3.add(comp32);
                comp3.setOpaque(false);
            //===============================================
            //===============================================
                JPanel comp4 = new JPanel();
                GridLayout layout4 = new GridLayout(1,3);
                Font nomes = new Font("SansSerif", Font.PLAIN, 20);
                comp4.setLayout(layout4);
                comp4.setMaximumSize(new Dimension(1200, 10));
                comp4.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

                //===============================================
                    JPanel comp41 = new JPanel();
                    JLabel duda = new JLabel("Pedro Henrique Castilhos Fraga");
                    duda.setFont(nomes);
                    comp41.add(duda);
                    comp41.setLayout(layout11);
                    comp41.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp42 = new JPanel();
                    JLabel pe = new JLabel("Eduarda Pfitscher Leguisamo");
                    pe.setFont(nomes);
                    comp42.add(pe);
                    comp42.setLayout(layout11);
                    comp42.setOpaque(false);
                //===============================================
                //===============================================
                    JPanel comp43 = new JPanel();
                    JLabel lu = new JLabel("Lucas Lourenço Jacchetti");
                    lu.setFont(nomes);
                    comp43.add(lu);
                    comp43.setLayout(layout11);
                    comp43.setOpaque(false);
                    comp43.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50));
                //===============================================

                comp4.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
                comp4.add(comp41);
                comp4.add(comp42);
                comp4.add(comp43);
                comp4.setOpaque(false);
            //===============================================

            body.add(comp11);
            body.add(comp12);
            body.add(comp13);
            body.add(comp2);
            body.add(comp3);
            body.add(comp4);
            painelPrincipal = body;
        //===============================================
            botao21.addActionListener(this);
            botao22.addActionListener(this);
            botao23.addActionListener(this);
            botao24.addActionListener(this);
            botao31.addActionListener(this);
            botao32.addActionListener(this);
        //========================
        
        this.add(body);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botao21) { //comprador
            mudaPainel(1);
        } else if(e.getSource() == botao22) { //fornecedor
            mudaPainel(2);
        } else if(e.getSource() == botao23) { //tecnolog
            mudaPainel(3);
        } else if(e.getSource() == botao24) { //venda
            mudaPainel(4);
        } else if(e.getSource() == botao31) { //salvar/carregar
            mudaPainel(5);
        } else if(e.getSource() == botao32) { //sair
            System.exit(0);
        }
    }
    public void mudaPainel(int painel) {
        switch(painel) {
            case 0:
                this.setContentPane(painelPrincipal);
                //this.pack();
                //this.setSize(1200, 700);
                break;
            case 1:
                this.setContentPane(painelComprador);
                //this.pack();
                //this.setSize(1200, 700);
                break;
            case 2:
                this.setContentPane(painelFornecedor);
                this.pack();
                this.setSize(1200, 700);
                break;
            case 3:
                this.setContentPane(painelTecnologia);
                //this.pack();
                //this.setSize(1200, 700);
                break;
            case 4:
                this.setContentPane(painelVenda);
                //this.pack();
                //this.setSize(1200, 700);
                break;
            case 5: 
                this.setContentPane(painelSalvarCarregar);
                //this.pack();
                break;
            case 6:
                this.setContentPane(painelCadastrarFornecedor);
                this.pack();
                this.setSize(1200, 700);
                break;
            case 7:
                this.setContentPane(painelCadastrarComprador);
                this.pack();
                this.setSize(1200, 700);
                break;
            case 8:
                this.setContentPane(painelCadastrarTecnologia);
                this.pack();
                this.setSize(1200, 700);
                break;
            case 9:
                this.setContentPane(painelCadastrarVenda);
                this.pack();
                this.setSize(1200, 700);
                break;
            case 10:
                this.setContentPane(painelAlterarDadosComprador);
                this.pack();
                this.setSize(1200, 700);
            break;
            case 11:
                this.setContentPane(painelModificarComprador);
                this.pack();
                this.setSize(1200, 700);
            break;
            case 12:
                this.setContentPane(painelRemoverDadosVenda);
                this.pack();
                this.setSize(1200, 700);
            break;
            case 13:
                this.setContentPane(painelSalvarDadosSalvarCarregar);
                this.pack();
                this.setSize(1200, 700);
            break;
            case 14:
                this.setContentPane(painelCarregarDadosSalvarCarregar);
                this.pack();
                this.setSize(1200, 700);
            break;
            // case 15:
            //     this.setContentPane(dialogRelatorioFornecedor);
            //     this.pack();
            //     this.setSize(1200, 700);
            // break;
            //case 16:
                //dialogRelatorioComprador.setVisible(true);
                //this.setContentPane(dialogRelatorioComprador);
                //this.pack();
                //this.setSize(1200, 700);
            //break;
            // case 17:
            //     this.setContentPane(dialogRelatorioTecnologia);
            //     this.pack();
            //     this.setSize(1200, 700);
            // break;
            // case 18:
            //     this.setContentPane(dialogRelatorioVenda);
            //     this.pack();
            //     this.setSize(1200, 700);
            // break;
        }
    }
}