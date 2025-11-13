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

    public Area verificarArea(String area) {
        for(Area a : Area.values()) {
            if(a.getNome().equals(area)) {
                return a;
            }
        } 
        return null;
    }
}