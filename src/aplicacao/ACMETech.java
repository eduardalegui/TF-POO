package src.aplicacao;

import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import src.entidades.CatalogoParticipantes;
import src.entidades.Comprador;
import src.entidades.Fornecedor;
import src.entidades.Participante;
import src.entidades.Tecnologia;
import src.entidades.Venda;
import src.ui.comprador.DialogRelatorioComprador;
import src.ui.HomePage;
// import src.ui.comprador.DialogRelatorioComprador;
// import src.ui.comprador.PainelCadastrarComprador;
// import src.ui.comprador.PainelComprador;
// import src.ui.fornecedor.DialogRelatorioFornecedor;
// import src.ui.fornecedor.PainelCadastrarFornecedor;
// import src.ui.fornecedor.PainelFornecedor;
// import src.ui.tecnologia.DialogRelatorioTecnologia;
// import src.ui.tecnologia.PainelCadastrarTecnologia;
// import src.ui.tecnologia.PainelTecnologia;
// import src.ui.venda.DialogRelatorioVenda;
// import src.ui.venda.PainelCadastrarVenda;
// import src.ui.venda.PainelVenda;
public class ACMETech {
    private CatalogoParticipantes participantes;
    private List<String> retornoFornecedores = new ArrayList<>();
    private List<String> retornoCompradores = new ArrayList<>();
    private List<String> retornoTecnologias = new ArrayList<>(); 
    private List<String> retornoVendas = new ArrayList<>();  

    public void inicializar() {
        participantes = new CatalogoParticipantes();       

        List<String> retornoParticipantes = lerArquivoParticipantes("PARTICIPANTESENTRADA");
        for(String s : retornoParticipantes) {
            System.out.println(s);
        }
        retornoParticipantes = lerArquivoTecnologia("TECNOLOGIASENTRADA");
        for(String s : retornoParticipantes) {
            System.out.println(s);
        }
        retornoParticipantes = lerArquivoVendas("VENDASENTRADA");
        for(String s : retornoParticipantes) {
            System.out.println(s);
        }
        salvarDados("relatorio");
        carregarDadosJson("novosDados");
    }

    public void executar() {
        inicializar();
        //HomePage minhaJanela = new HomePage(participantes);
        //inicializar();
        //HomePage minhaJanela = new HomePage(participantes);
        //DialogRelatorioComprador dialog = new DialogRelatorioComprador();
        // PainelCadastrarComprador minhaJanela = new PainelCadastrarComprador();
        // PainelComprador minhaJanela = new PainelComprador();
        // PainelCadastrarFornecedor minhaJanela = new PainelCadastrarFornecedor();
        // PainelFornecedor minhaJanela = new PainelFornecedor();
        // PainelCadastrarTecnologia minhaJanela = new PainelCadastrarTecnologia();
        // PainelTecnologia minhaJanela = new PainelTecnologia();
        // PainelCadastrarVenda minhaJanela = new PainelCadastrarVenda();
        // PainelVenda minhaJanela = new PainelVenda();
    }

    public List<String> lerArquivoParticipantes(String caminho) {
        String nomeArquivo = caminho + ".CSV";
        Path path = Paths.get("src", "recursos", nomeArquivo);
        List<String> retorno = new ArrayList<>();
        Scanner sc = null;
        try (BufferedReader br = Files.newBufferedReader(path,Charset.forName("UTF-8"))) {
            br.readLine();
            String linha = null;
        while ((linha = br.readLine()) != null) {
            try {
                sc = new Scanner(linha).useDelimiter(";");
                String stringCod = sc.next();
                String nome = sc.next();
                String stringTipo = sc.next();
                String fundacao_pais = sc.next();
                String area_email = sc.next();
                if(stringTipo.equals("2")) {
                    retorno.add(participantes.cadastrarComprador(stringCod, nome, fundacao_pais, area_email));
                } else if(stringTipo.equals("1")) {
                    retorno.add(participantes.cadastrarFornecedor(stringCod, nome, fundacao_pais, area_email));
                }
            } catch (NumberFormatException e) {
                retorno.add("ERRO:formato invalido.");
                continue;
            } catch(NoSuchElementException e) {
                retorno.add("ERRO:formato invalido.");
                continue;
            }
        }
        } catch (IOException e) {
            retorno.add(String.format("Erro de E/S: %s%n", e));
        }
        sc.close();
        return retorno;
    }

    public List<String> lerArquivoTecnologia(String caminho) {
        String nomeArquivo = caminho + ".CSV";
        Path path = Paths.get("src", "recursos",nomeArquivo);
        List<String> retorno = new ArrayList<>();
        Scanner sc = null;
        try (BufferedReader br = Files.newBufferedReader(path,Charset.forName("UTF-8"))) {
            br.readLine();
            String linha = null;
        while ((linha = br.readLine()) != null) {
            try {
                sc = new Scanner(linha).useDelimiter(";");
                Fornecedor f = null;
                String stringId = sc.next();
                String modelo = sc.next();
                String descricao = sc.next();
                String stringValorBase = sc.next();
                String stringPeso = sc.next();
                String stringTemperatura = sc.next();
                String stringFornecedor = sc.next();
                // long id = Long.parseLong(stringId);
                // double valorBase = Double.parseDouble(stringValorBase);
                // double peso = Double.parseDouble(stringPeso);
                // double temperatura = Double.parseDouble(stringTemperatura);
                long fornecedor = Long.parseLong(stringFornecedor);
                for(Participante p : participantes.getParticipantes()) {
                    if(p instanceof Fornecedor) {
                        if(p.getCod() == fornecedor) {
                            f = (Fornecedor) p;
                        }
                    }
                }
                retorno.add(f.cadastrarTecnologia(stringId, modelo, descricao, stringValorBase, stringPeso, stringTemperatura, f));
            } catch (NumberFormatException e) {
                retorno.add("ERRO:formato invalido.");
                continue;
            } catch(NoSuchElementException e) {
                retorno.add("ERRO:formato invalido.");
                continue;
            }
        }
        } catch (IOException e) {
            retorno.add(String.format("Erro de E/S: %s%n", e));
        }
        sc.close();
        return retorno;
    }

    public List<String> lerArquivoVendas(String caminho) {
        String nomeArquivo = caminho + ".CSV";
        Path path = Paths.get("src", "recursos", nomeArquivo);
        List<String> retorno = new ArrayList<>();
        Scanner sc = null;
        try (BufferedReader br = Files.newBufferedReader(path,Charset.forName("UTF-8"))) {
            br.readLine();
            String linha = null;
        while ((linha = br.readLine()) != null) {
            try {
                sc = new Scanner(linha).useDelimiter(";");
                Comprador comprador = null;
                Tecnologia tecnologia = null;
                String stringNum = sc.next();
                String stringData = sc.next();
                String stringCod = sc.next();
                String StringId = sc.next();
                long cod = Long.parseLong(stringCod);
                long id = Long.parseLong(StringId);
                for(Participante p : participantes.getParticipantes()) {
                    if(p instanceof Comprador) {
                        if(p.getCod() == cod) {
                            comprador = (Comprador) p;
                        }
                    }
                }
                for(Participante p : participantes.getParticipantes()) {
                    if(p instanceof Fornecedor) {
                        Fornecedor f = (Fornecedor) p;
                        for(Tecnologia t : f.getArrayTecnologia()) {
                            if(t.getId() == id) {
                                tecnologia = t;
                            }
                        }
                    }
                }
                retorno.add(comprador.cadastrarVenda(stringNum, stringData, comprador, tecnologia));
            } catch (NumberFormatException e) {
                retorno.add("ERRO:formato invalido.");
                continue;
            } catch(NoSuchElementException e) {
                retorno.add("ERRO:formato invalido.");
                continue;
            }
        }
        } catch (IOException e) {
            retorno.add(String.format("Erro de E/S: %s%n", e));
        }
        sc.close();
        return retorno;
    }

    public void salvarDados(String nome) {
        try {
            Path path = Paths.get("src", "recursos", nome + ".json");
            PrintStream streamSaida = new PrintStream(path.toFile(), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
            List<Fornecedor> fornecedores = new ArrayList<>();
            List<Comprador> compradores = new ArrayList<>();
            List<Tecnologia> tecnologias = new ArrayList<>();
            List<Venda> vendas = new ArrayList<>();
            int contador = 1;
            System.out.println("{");
            System.out.println("    \"Fornecedores\": {");
            for(Participante p : participantes.getParticipantes()) {
                if(p instanceof Fornecedor) {
                    Fornecedor f = (Fornecedor) p;
                    fornecedores.add(f);
                }
            }
            for(Fornecedor f : fornecedores) {
                System.out.println("        \""  + contador + "\"" + ": {");
                System.out.println("            \"cod\": " + f.getCod() + ",");
                System.out.println("            \"nome\": " + "\"" + f.getNome() + "\"" + ",");
                System.out.println("            \"fundacao\": " + "\"" + f.geraData() + "\"" +",");
                System.out.println("            \"area\": " + "\"" + f.getArea().getNome() + "\"");
                if(contador == fornecedores.size()) {
                    System.out.println("        }");
                } else {
                    System.out.println("        },");
                    contador++;
                }
            }

            contador = 1;
            System.out.println("    },");
            System.out.println("    \"Compradores\": {");
            for(Participante p : participantes.getParticipantes()) {
                if(p instanceof Comprador) {
                    Comprador c = (Comprador) p;
                    compradores.add(c);
                }
            }
            for(Comprador c : compradores) {
                System.out.println("        \""  + contador + "\"" + ": {");
                System.out.println("            \"cod\": " + c.getCod() + ",");
                System.out.println("            \"nome\": " + "\"" + c.getNome() + "\"" + ",");
                System.out.println("            \"pais\": " + "\"" + c.getPais() + "\"" +",");
                System.out.println("            \"email\": " + "\"" + c.getEmail() + "\"");
                if(contador == compradores.size()) {
                    System.out.println("        }");
                } else {
                    System.out.println("        },");
                    contador++;
                }
            }

            contador = 1;
            System.out.println("    },");
            System.out.println("    \"Tecnologias\": {");
            for(Fornecedor f : fornecedores) {
                for(Tecnologia t : f.getArrayTecnologia()) {
                    tecnologias.add(t);
                }
            }
            for(Tecnologia t : tecnologias) {
                System.out.println("        \""  + contador + "\"" + ": {");
                System.out.println("            \"id\": " + t.getId() + ",");
                System.out.println("            \"modelo\": " + "\"" + t.getModelo() + "\"" + ",");
                System.out.println("            \"descricao\": " + "\"" + t.getDescricao() + "\"" +",");
                System.out.println("            \"valor_base\": " + "\"" + t.getValorBase() + "\"" + ",");
                System.out.println("            \"peso\": " + "\"" + t.getPeso() + "\"" + ",");
                System.out.println("            \"temperatura\": " + "\"" + t.getTemperatura() + "\"" + ",");
                System.out.println("            \"cod_fornecedor\": " + t.getFornecedor().getCod() + ",");
                System.out.println("            \"nome_fornecedor\": " + "\"" + t.getFornecedor().getNome() + "\"" + ",");
                System.out.println("            \"fundacao_fornecedor\": " + "\"" + t.getFornecedor().geraData() + "\"" + ",");
                System.out.println("            \"area_fornecedor\": " + "\"" + t.getFornecedor().getArea().getNome() + "\"");
                if(contador == tecnologias.size()) {
                    System.out.println("        }");
                } else {
                    System.out.println("        },");
                    contador++;
                }
            }

            contador = 1;
            System.out.println("    },");
            System.out.println( "   \"Vendas\": {");
            for(Comprador c : compradores) {
                for(Venda v : c.getArrayVenda()) {
                    vendas.add(v);
                }
            }
            for(Venda v : vendas) {
                System.out.println("        \""  + contador + "\"" + ": {");
                System.out.println("            \"num\": " + v.getNum() + ",");
                System.out.println("            \"data\": " + "\"" + v.geraData() + "\"" + ",");
                System.out.println("            \"valor_final\": " + "\"" + v.getValorFinal() + "\"" + ",");
                System.out.println("            \"cod_comprador\": " + v.getComprador().getCod() + ",");
                System.out.println("            \"nome_comprador\": " + "\"" + v.getComprador().getNome() + "\"" + ",");
                System.out.println("            \"pais_comprador\": " + "\"" + v.getComprador().getPais() + "\"" + ",");
                System.out.println("            \"email_comprador\": " + "\"" + v.getComprador().getEmail() + "\"" + ",");
                System.out.println("            \"id_tecnologia\": " + v.getTecnologia().getId() + ",");
                System.out.println("            \"modelo_tecnologia\": " + "\"" + v.getTecnologia().getModelo() + "\"" + ",");
                System.out.println("            \"descricao_tecnologia\": " + "\"" + v.getTecnologia().getDescricao() + "\"" +",");
                System.out.println("            \"valor_base_tecnologia\": " + "\"" + v.getTecnologia().getValorBase() + "\"" + ",");
                System.out.println("            \"peso_tecnologia\": " + "\"" + v.getTecnologia().getPeso() + "\"" + ",");
                System.out.println("            \"temperatura_tecnologia\": " + "\"" + v.getTecnologia().getTemperatura() + "\"" + ",");
                System.out.println("            \"cod_fornecedor_tecnologia\": " + v.getTecnologia().getFornecedor().getCod() + ",");
                System.out.println("            \"nome_fornecedor_tecnologia\": " + "\"" + v.getTecnologia().getFornecedor().getNome() + "\"" + ",");
                System.out.println("            \"fundacao_fornecedor_tecnologia\": " + "\"" + v.getTecnologia().getFornecedor().geraData() + "\"" + ",");
                System.out.println("            \"area_fornecedor_tecnologia\": " + "\"" + v.getTecnologia().getFornecedor().getArea().getNome() + "\"");
                if(contador == tecnologias.size()) {
                    System.out.println("        }");
                } else {
                    System.out.println("        },");
                    contador++;
                }            }
            System.out.println("    }");
            System.out.println("}");
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
    }

    public void carregarDadosJson(String caminho) {
        String nomeArquivo = caminho + ".json";
        Path path = Paths.get("src","recursos", nomeArquivo);
        Scanner sc = null;        
        try (BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            List<String> fornecedores = new ArrayList<>();
            List<String> compradores = new ArrayList<>();
            List<String> tecnologias = new ArrayList<>();
            List<String> vendas = new ArrayList<>();
            String linha = null;
            br.readLine();
            while ((linha = br.readLine()) != null) {
                try {
                    Fornecedor f = null;
                    Comprador c = null;
                    Tecnologia tecnologia = null;
                    fornecedores = listaCarregarDadosFornecedores(linha, br, linha, sc);
                    compradores = listaCarregarDadosCompradores(linha, br, linha, sc);
                    tecnologias = listaCarregarDadosTecnologias(linha, br, linha, sc);
                    vendas = listaCarregarDadosVendas(linha, br, linha, sc);
                    for(int i = 0; i < fornecedores.size(); i += 4) {
                        String cod = fornecedores.get(i);
                        String nome = fornecedores.get(i + 1).substring(1, fornecedores.get(i + 1).length() - 1);
                        String fundacao = fornecedores.get(i + 2).substring(1,fornecedores.get(i + 2).length() - 1);
                        String area = fornecedores.get(i + 3).substring(1, fornecedores.get(i + 3).length()  - 1);
                        participantes.cadastrarFornecedor(cod, nome, fundacao, area);
                    }
                    for(int i = 0; i < compradores.size(); i += 4) {
                        String cod = compradores.get(i);
                        String nome = compradores.get(i + 1).substring(1, compradores.get(i + 1).length() - 1);
                        String pais = compradores.get(i + 2).substring(1, compradores.get(i + 2).length() - 1);
                        String email = compradores.get(i + 3).substring(1, compradores.get(i + 3).length() - 1);
                        participantes.cadastrarComprador(cod, nome, pais, email); 
                    }
                    for(int i = 0; i < tecnologias.size(); i += 7) {
                        long cod = Long.parseLong(tecnologias.get(i + 6));
                        for(Participante p : participantes.getParticipantes()) {
                            if(p instanceof Fornecedor) {
                                if(p.getCod() == cod) {
                                    f = (Fornecedor) p;
                                }
                            }
                        }
                        String id = tecnologias.get(i);
                        String modelo = tecnologias.get(i + 1).substring(1, tecnologias.get(i + 1).length() - 1);
                        String descricao = tecnologias.get(i + 2).substring(1, tecnologias.get(i + 2).length() - 1);
                        String valorBase = tecnologias.get(i + 3);
                        String peso = tecnologias.get(i + 4);
                        String temperatura = tecnologias.get(i + 5);
                        f.cadastrarTecnologia(id, modelo, descricao, valorBase, peso, temperatura, f); 
                    }
                    
                    for(int i = 0; i < vendas.size(); i += 4) {
                        long cod = Long.parseLong(vendas.get(i + 2));
                        long id = Long.parseLong(vendas.get(i + 3));
                        for(Participante p : participantes.getParticipantes()) {
                            if(p instanceof Comprador) {
                                if(p.getCod() == cod) {
                                    c = (Comprador) p;
                                }
                            }
                        }
                        for(Participante p : participantes.getParticipantes()) {
                            if(p instanceof Fornecedor) {
                                Fornecedor fornecedor = (Fornecedor) p;
                                for(Tecnologia t : fornecedor.getArrayTecnologia()) {
                                    if(t.getId() == id) {
                                        tecnologia = t;
                                    }
                                }
                            }
                        }
                        String num = vendas.get(i);
                        String data = vendas.get(i + 1).substring(1, vendas.get(i + 1).length() - 1);
                        c.cadastrarVenda(num, data, c, tecnologia);
                    }
                } catch (NumberFormatException e) {
                        System.out.println("ERRO:formato invalido");
                        continue;
                } catch(NoSuchElementException e) {
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo");
        }
    }

    private List<String> listaCarregarDadosFornecedores(String tipo, BufferedReader br, String linha, Scanner sc) {
        try {
            if(tipo.contains("Fornecedores")) {
                while ((linha = br.readLine()) != null) {
                    sc = new Scanner(linha).useDelimiter("[:,]");
                    sc.next();
                    String conteudo = sc.next().trim();
                    retornoFornecedores.add(conteudo);
                }
            }
            return retornoFornecedores;
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<String> listaCarregarDadosCompradores(String tipo, BufferedReader br, String linha, Scanner sc) {
        try {
            if(tipo.contains("Compradores")) {
                while ((linha = br.readLine()) != null) {
                    sc = new Scanner(linha).useDelimiter("[:,]");
                    sc.next();
                    String conteudo = sc.next().trim();
                    retornoCompradores.add(conteudo);
                }
            } 
            return retornoCompradores;
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<String> listaCarregarDadosTecnologias(String tipo, BufferedReader br, String linha, Scanner sc) {
        try {
            if(tipo.contains("Tecnologias")) {
                while ((linha = br.readLine()) != null) {
                    sc = new Scanner(linha).useDelimiter("[:,]");
                    sc.next();
                    String conteudo = sc.next().trim();
                    retornoTecnologias.add(conteudo);
                }
            } 
            return retornoTecnologias;
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private List<String> listaCarregarDadosVendas(String tipo, BufferedReader br, String linha, Scanner sc) {
        try {
            if(tipo.contains("Vendas")) {
                while ((linha = br.readLine()) != null) {
                    sc = new Scanner(linha).useDelimiter("[:,]");
                    sc.next();
                    String conteudo = sc.next().trim();
                    retornoVendas.add(conteudo);
                }
            }
            return retornoVendas;
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}