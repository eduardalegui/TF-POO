package aplicacao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
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

import entidades.CatalogoParticipantes;
import entidades.Comprador;
import entidades.Fornecedor;
import entidades.Participante;
import entidades.Tecnologia;
import entidades.Venda;

public class ACMETech {
    private CatalogoParticipantes participantes;

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
    }

    public void executar() {
        inicializar();
    }

    public List<String> lerArquivoParticipantes(String caminho) {
        String nomeArquivo = caminho + ".CSV";
        Path path = Paths.get("recursos",nomeArquivo);
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
        Path path = Paths.get("recursos",nomeArquivo);
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
                long id = Long.parseLong(stringId);
                double valorBase = Double.parseDouble(stringValorBase);
                double peso = Double.parseDouble(stringPeso);
                double temperatura = Double.parseDouble(stringTemperatura);
                long fornecedor = Long.parseLong(stringFornecedor);
                for(Participante p : participantes.getParticipantes()) {
                    if(p instanceof Fornecedor) {
                        if(p.getCod() == fornecedor) {
                            f = (Fornecedor) p;
                        }
                    }
                }
                retorno.add(f.cadastrarTecnologia(id, modelo, descricao, valorBase, peso, temperatura, f));
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
        Path path = Paths.get("recursos", nomeArquivo);
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
            Path path = Paths.get("recursos", nome + ".json");
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

    public void carregarDadosCsv(String caminho) {
        String nomeArquivo = caminho + ".csv";
        Path path = Paths.get("resursos", nomeArquivo);
        participantes = new CatalogoParticipantes();
        Scanner sc = null;
        try (BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String linha = null;
            br.readLine();
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
                    long id = Long.parseLong(stringId);
                    double valorBase = Double.parseDouble(stringValorBase);
                    double peso = Double.parseDouble(stringPeso);
                    double temperatura = Double.parseDouble(stringTemperatura);
                    long fornecedor = Long.parseLong(stringFornecedor);
                    for(Participante p : participantes.getParticipantes()) {
                        if(p instanceof Fornecedor) {
                            if(p.getCod() == fornecedor) {
                                f = (Fornecedor) p;
                            }
                        }
                    }
                    System.out.println(f.cadastrarTecnologia(id, modelo, descricao, valorBase, peso, temperatura, f));
                } catch (NumberFormatException e) {
                    System.out.println("ERRO:formato invalido.");
                    continue;
                } catch(NoSuchElementException e) {
                    System.out.println("ERRO:formato invalido.");
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar o arquivo: ");
        }
        System.out.println("Carregamento concluído.");
    }
}
