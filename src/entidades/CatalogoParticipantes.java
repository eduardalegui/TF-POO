package src.entidades;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class CatalogoParticipantes {
    private List<Participante> participantes;

    public CatalogoParticipantes() {
        this.participantes = new ArrayList<>();
    }

    public List<Participante> getParticipantes() {
        return this.participantes;
    }
    
    public String cadastrarFornecedor(String stringCod, String nome, String stringFundacao, String stringArea) {
        try {
            DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR"));
            boolean cadastrado = false;
            long cod = Long.parseLong(stringCod);
            

            if(nome.equals("")) {
                return "ERRO: O nome não pode estar vazio";
            }
            if (nome.matches(".*\\d.*")) {
                return "ERRO: O nome não pode conter números";
            }
            if (stringFundacao.length() < 10) {
                return "ERRO: Data inválida";
            }
            if (stringFundacao.equals("")) {
                return "ERRO: A data não pode estar vazia";
            }
            if (stringArea.equals("")) {
                return "ERRO: A área não pode estar vazia";
            }
            Date fundacao = date.parse(stringFundacao);
            String data = stringFundacao.trim();


            for(Participante p : participantes) {
                if (p instanceof Fornecedor) {
                    if(p.getCod() == cod) {
                        return "ERRO: Codigo repetido";
                    }
                }
            }

            Area area = verificarArea(stringArea);

            Fornecedor f = new Fornecedor(cod, nome, fundacao, area);
            for(int i = 0; i < participantes.size(); i++) {
                if(participantes.get(i).getCod() > cod) {
                    cadastrado = true;
                    participantes.add(i, f);
                    break;
                }
            }

            if(!cadastrado) {
                participantes.add(f);
            }

            return "Fornecedor cadastrado";
        } catch(NullPointerException e) {
            return "ERRO: Preencha todos os campos corretamente";
        } catch (ParseException e) {
            return "ERRO:Data no formato incorreto";
        } catch (Exception e) {
            return "ERRO: Revise seus dados e tente novamente";
        }
    }

    public String cadastrarComprador(String stringCod, String nome, String pais, String email) {
        try {
            boolean cadastrado = false;
            long cod = Long.parseLong(stringCod);

            if(nome.equals("")) {
                return "ERRO: O nome não pode estar vazio";
            }
            if (nome.matches(".*\\d.*")) {
                return "ERRO: O nome não pode conter números";
            }
            if (pais.matches(".*\\d.*")) {
                return "ERRO: O pais não pode conter números";
            }
            if (email.equals("")) {
                return "ERRO: O email não pode estar vazio";
            }
            if (!email.contains("@")) {
                return "ERRO: O email deve conter '@'";
            }
            if (email.length() < 6) {
                return "ERRO: Email muito curto";
            }

            for(Participante p : participantes) {
                if (p instanceof Comprador) {
                    if(p.getCod() == cod) {
                        return "ERRO: Codigo repetido";
                    }
                }
            }

            Comprador c = new Comprador(cod, nome, pais, email);
            for (int i = 0; i < participantes.size(); i++) {
                if (participantes.get(i).getCod() > cod) {
                    cadastrado = true;
                    participantes.add(i, c);
                    break;
                }
            }

            if (!cadastrado) {
                participantes.add(c);
            }

            return "Comprador cadastrado";
        } catch (NullPointerException e) {
            return "ERRO: Preencha todos os campos corretamente";
        } catch (Exception e) {
            return "ERRO: Revise seus dados e tente novamente";
        }
    }

    public Area verificarArea(String area) {
        for(Area a : Area.values()) {
            if(a.getNome().equals(area)) {
                return a;
            }
        } 
        return null;
    }

    public String consultarFornecedorComMaisTecnologias(){
        ArrayList<Fornecedor> fornecedoresEmpatados = new ArrayList<>();
        String retorno = "";
        ArrayList<Fornecedor> arrayFornecedores = new ArrayList<>();
        for (Participante p : participantes) {
            if (p instanceof Fornecedor) {
                arrayFornecedores.add((Fornecedor) p);
            }
        }
        if (arrayFornecedores.size() == 0) {
            return "Erro: Não há fornecedores cadastrados";
        }
        Fornecedor maior = arrayFornecedores.get(0);
        for (Fornecedor f: arrayFornecedores) {
            if (maior.getArrayTecnologia().size() < f.getArrayTecnologia().size()) {
                maior = f;
            }
        }
        fornecedoresEmpatados.add(maior);
        for (Fornecedor f : arrayFornecedores) { 
            if (maior.getArrayTecnologia().size()== f.getArrayTecnologia().size()) {
                fornecedoresEmpatados.add(f);
            }
        }
        for (Fornecedor f : fornecedoresEmpatados) {
            retorno = retorno + f.geraDescricao() + f.getArrayTecnologia().size() + "\n";
        }
        return retorno;
    }

    public String consultarCompradorComMaisVendas(){
        ArrayList<Comprador> compradoresEmpatados = new ArrayList<>();
        String retorno = "";
        ArrayList<Comprador> arrayCompradores = new ArrayList<>();
        for (Participante p : participantes) {
            if (p instanceof Comprador) {
                arrayCompradores.add((Comprador) p);
            }
        }
        if (arrayCompradores.size() == 0) {
            return "Erro: Não há fornecedores cadastrados";
        }
        Comprador maior = arrayCompradores.get(0);
        for (Comprador c: arrayCompradores) {
            if (maior.getArrayVenda().size() < c.getArrayVenda().size()) {
                maior = c;
            }
        }
        compradoresEmpatados.add(maior);
        for (Comprador comprador : arrayCompradores) { 
            if (maior.getArrayVenda().size() == comprador.getArrayVenda().size()) {
                arrayCompradores.add(comprador);
            }
        }
        for (Comprador comprador : compradoresEmpatados) {
            retorno = retorno + comprador.geraDescricao() + "\n";
        }
        
        return maior.geraDescricao();
    }

    public List<String> mostrarRelatorioDeFornecedores() {
        List<String> retorno = new ArrayList<>();
        for(Participante p : participantes) {
            if(p instanceof Fornecedor) {
                Fornecedor fornecedor = (Fornecedor) p;
                retorno.add(fornecedor.geraDescricao());
            }
        }
        return retorno;
    }

    public List<String> mostrarRelatorioDeCompradores() {
        List<String> retorno = new ArrayList<>();
        for(Participante p : participantes) {
            if(p instanceof Comprador) {
                Comprador comprador = (Comprador) p;
                retorno.add(comprador.geraDescricao());
            }
        }
        return retorno;
    }

    public String removerOsDadosDeUmDeterminadoComprador(long cod) {
        for(Participante p : participantes) {
            if(p instanceof Comprador) {
                if(p.getCod() == cod) {
                    Comprador comprador = (Comprador) p;
                    return comprador.geraDescricao();
                }
            }
        }
        return "ERRO:não existe comprador com este código";
    }

    public String mostrarOsDadosDeUmDeterminadoComprador(String stringCod) {
        try {
            long cod = Long.parseLong(stringCod);
            for(Participante p : participantes) {
                if(p instanceof Comprador) {
                    Comprador c = (Comprador) p;
                    if(c.getCod() == cod) {
                        return c.getCod() + ";" + c.getNome() + ";" + c.getPais() + ";" + c.getEmail();
                    }
                }
            }
            return "Comprador nao encontrado";
        } catch(NumberFormatException e) {
            return "Codigo invalido";
        } catch(NullPointerException e) {
            return "Comprador nao encontrado";
        }
    }

    public String alterarOsDadosDeUmDeterminadoComprador(String stringCod, String nome, String pais, String email) {
        try {
            Comprador c = null;
            boolean modificado = false;
            long cod = Long.parseLong(stringCod);
            for(Participante p : participantes) {
                if(p instanceof Comprador) {
                    c = (Comprador) p;
                    if(c.getCod() == cod) {
                        if (nome.matches(".*\\d.*")) {
                            return "ERRO: O nome não pode conter números";
                        }
                        if (!email.contains("@")) {
                            return "ERRO: O email deve conter '@'";
                        }
                        if (email.length() < 6) {
                            return "ERRO: Email muito curto";
                        }
                        if (pais.matches(".*\\d.*")) {
                            return "ERRO: O pais não pode conter números";
                        }
                        if(!nome.equals("")) {
                            modificado = true;
                            c.setNome(nome);
                        }
                        if(!pais.equals("")) {
                            modificado = true;
                            c.setPais(pais);
                        }
                        if(!email.equals("")) {
                            modificado = true;
                            c.setEmail(email);
                        }
                    }
                }
            }
            if(c == null) {
                return "Comprador nao encontrado";
            } else if(modificado) {
                return "Comprador modificado";
            } else {
                return "Nenhum campo preenchido";
            }            
        } catch(NumberFormatException e) {
            return "Codigo invalido";
        } catch(NullPointerException e) {
            return "Comprador nao encontrado";
        }
    }
    
}