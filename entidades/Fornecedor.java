package entidades;

import java.text.SimpleDateFormat;
import java.util.*;

public class Fornecedor extends Participante{
    private Date fundacao;
    private Area area;
    private List<Tecnologia> arrayTecnologias;

    public Fornecedor(long cod, String nome, Date fundacao, Area area) {
        super(cod, nome);
        this.fundacao = fundacao;
        this.area = area;
        arrayTecnologias = new ArrayList<>();
    }

    public Date getFundacao() {
        return this.fundacao;
    }

    public Area getArea() {
        return this.area;
    }

    public List<Tecnologia> getArrayTecnologia(){
        return arrayTecnologias;
    }

    public String cadastrarTecnologia(long id, String modelo, String descricao, double valorBase, double peso, double temperatura, Fornecedor fornecedor){
        try {
            for (Tecnologia tecnologia : arrayTecnologias) {
                if (tecnologia.getId() == id) {
                    return "ERRO:id repetido no sistema";
                }
            }
            Tecnologia novaTecnologia = new Tecnologia(id, modelo, descricao, valorBase, peso, temperatura, fornecedor);
            arrayTecnologias.add(novaTecnologia);
            Collections.sort(arrayTecnologias, Comparator.comparing(Tecnologia::getId));
            return "Tecnologia cadastrada";
        } catch (Exception e) {
            return "Revise seus dados e tente novamente";
        }
    }

    public String consultarTecnologiaComMaiorValor(){
        ArrayList<Tecnologia> tecnologiasEmpatadas = new ArrayList<>();
        String retorno = "";
        if (arrayTecnologias.size() == 0) {
            return "Erro: Não há tecnologias cadastradas";
        }
        Tecnologia maior = arrayTecnologias.get(0);
        for (Tecnologia tecnologia : arrayTecnologias) {
            if (maior.getValorBase() < tecnologia.getValorBase()) {
                maior = tecnologia;
            }
        }
        tecnologiasEmpatadas.add(maior);
        for (Tecnologia tecnologia : arrayTecnologias) {
            if (maior.getValorBase() == tecnologia.getValorBase()) {
                tecnologiasEmpatadas.add(tecnologia);
            }
        }
        for (Tecnologia tecnologia : tecnologiasEmpatadas) {
            retorno = retorno + tecnologia.geraDescricao() + "\n";
        }
        return retorno;
    }

    public List<String> mostrarRelatorioDeTecnologias() {
        List<String> retorno = new ArrayList<>();
        for(Tecnologia t : arrayTecnologias) {
            retorno.add(t.geraDescricao());
        }
        return retorno; 
    }

    @Override
    public String geraDescricao() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return this.getCod() + ";" + this.getNome() + ";" + data.format(this.getFundacao()) + ";" + this.getArea();
    }
}
