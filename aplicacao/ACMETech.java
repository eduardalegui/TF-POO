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
        Path path = Paths.get("recursos",nomeArquivo);
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
            PrintStream streamSaida = new PrintStream(new File(nome + ".txt"), Charset.forName("UTF-8"));
            System.setOut(streamSaida);
            for(Participante p : participantes.getParticipantes()) {
                if(p instanceof Fornecedor) {
                    Fornecedor f = (Fornecedor) p;
                    System.out.println(f.geraDescricao());
                } else {
                    Comprador c = (Comprador) p;
                    System.out.println(c.geraDescricao());
                }
            }
            for(Participante p : participantes.getParticipantes()) {
                if(p instanceof Comprador) {
                    Comprador c = (Comprador) p;
                    for(Venda v : c.getArrayVenda()) {
                        System.out.println(v.geraDescricao());
                    }
                } else {
                    Fornecedor f = (Fornecedor) p;
                    for(Tecnologia t : f.getArrayTecnologia()) {
                        System.out.println(t.geraDescricao());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);
    }

    public void carregarDados(String caminho){
        String nomeArquivo = caminho + ".txt";
        Path path = Paths.get("", nomeArquivo);
        participantes = new CatalogoParticipantes();
        try (BufferedReader br = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(";");
                int n = campos.length;
                try {
                    if (n == 4) {
                        String cod = campos[0];
                        String nome = campos[1];
                        String fund = campos[2];
                        String email = campos[3];
                        participantes.cadastrarFornecedor(cod, nome, fund, email);
                        continue;
                    }
                    else if (n == 10) {
                        long id = Long.parseLong(campos[0]);
                        String modelo = campos[1];
                        String descricao = campos[2];
                        double valorBase = Double.parseDouble(campos[3]);
                        double peso = Double.parseDouble(campos[4]);
                        double temperatura = Double.parseDouble(campos[5]);
                        long codFornecedor = Long.parseLong(campos[6]);

                        Fornecedor f = null;
                        for (Participante p : participantes.getParticipantes()) {
                            if (p instanceof Fornecedor && p.getCod() == codFornecedor) {
                                f = (Fornecedor) p;
                            }
                        }
                        if (f == null) {
                            System.out.println("Fornecedor não encontrado para tecnologia id " + id);
                            continue;
                        }
                        f.cadastrarTecnologia(id, modelo, descricao, valorBase, peso, temperatura, f);
                        continue;
                    }
                    else if (n >= 15) {
                        String num = campos[0];
                        String data = campos[1];
                        long codComprador = Long.parseLong(campos[3]);
                        long idTec = Long.parseLong(campos[7]);
                        Comprador comp = null;
                        Tecnologia tec = null;
                        for (Participante p : participantes.getParticipantes()) {
                            if (p.getCod() == codComprador) {
                                if (p instanceof Fornecedor) {
                                    participantes.fornecedorParaComprador(codComprador);
                                }
                            }
                        }
                        for (Participante p : participantes.getParticipantes()) {
                            if (p instanceof Comprador && p.getCod() == codComprador) {
                                comp = (Comprador)p;
                            }
                        }
                        for (Participante p : participantes.getParticipantes()) {
                            if (p instanceof Fornecedor) {
                                Fornecedor f = (Fornecedor)p;
                                for (Tecnologia t : f.getArrayTecnologia()) {
                                    if (t.getId() == idTec) {
                                        tec = t;
                                    }
                                }
                            }
                        }
                        if (comp == null || tec == null) {
                            System.out.println("Erro ao cadastrar venda " + num);
                            continue;
                        }
                        comp.cadastrarVenda(num, data, comp, tec);
                        continue;
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao carregar linha: " + linha);
                }
            }
            System.out.println("Carregamento concluído.");

        } catch (Exception e) {
            System.out.println("Erro: Ocorreu um erro ao carregar os dados");
        }
    }

    
}
