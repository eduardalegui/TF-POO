package aplicacao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import entidades.CatalogoParticipantes;
import entidades.Comprador;
import entidades.Fornecedor;
import entidades.Participante;
import entidades.Tecnologia;

public class ACMETech {
    private CatalogoParticipantes participantes;

    public void inicializar() {
        participantes = new CatalogoParticipantes();
        List<String> retornoParticipantes = lerArquivoParticipantes();
        for(String s : retornoParticipantes) {
            System.out.println(s);
        }
        retornoParticipantes = lerArquivoTecnologia();
        for(String s : retornoParticipantes) {
            System.out.println(s);
        }
        retornoParticipantes = lerArquivoVendas();
        for(String s : retornoParticipantes) {
            System.out.println(s);
        }
    }

    public void executar() {
        inicializar();
    }

    public List<String> lerArquivoParticipantes() {
        Path path = Paths.get("recursos","PARTICIPANTESENTRADA.CSV");
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

    public List<String> lerArquivoTecnologia() {
        Path path = Paths.get("recursos","TECNOLOGIASENTRADA.CSV");
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

    public List<String> lerArquivoVendas() {
        Path path = Paths.get("recursos","VENDASENTRADA.CSV");
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


}
