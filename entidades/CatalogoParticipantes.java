package entidades;

import java.text.DateFormat;
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
            Date fundacao = date.parse(stringFundacao);

            if(nome == null || fundacao == null || cod == 0 || stringArea == null) {
                return "ERRO:Preencha todos os campos corretamente";
            }

            for(Participante p : participantes) {
                if(p.getCod() == cod) {
                    return "ERRO:Codigo repetido";
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
            return "ERRO:Preencha todos os campos corretamente";
        } catch (Exception e) {
            return "ERRO:Revise seus dados e tente novamente";
        }
    }

    public String cadastrarComprador(String stringCod, String nome, String pais, String email) {
        try {
            boolean cadastrado = false;
            long cod = Long.parseLong(stringCod);

            if (nome == null || pais == null || cod <= 0 || email == null || !email.contains("@")) {
                return "Preencha todos os campos corretamente";
            }

            for (Participante p : participantes) {
                if (p.getCod() == cod) {
                    return "ERRO:codigo repetido";
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
            return "Preencha todos os campos corretamente";
        } catch (Exception e) {
            return "Revise seus dados e tente novamente";
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
        return maior.geraDescricao() + ";" + maior.getArrayTecnologia().size();
    }

    public String consultarCompradorComMaisVendas(){
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
        for (Comprador f: arrayCompradores) {
            if (maior.getArrayVenda().size() < f.getArrayVenda().size()) {
                maior = f;
            }
        }
        return maior.geraDescricao();
    }
}