package src.entidades;
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

    public String cadastrarTecnologia(String idT, String modelo, String descricao, String valorBaseT, String pesoT, String temperaturaT, Fornecedor fornecedor){
        try {
            long id = Long.parseLong(idT);
            double valorBase = Double.parseDouble(valorBaseT);
            double peso = Double.parseDouble(pesoT);
            double temperatura = Double.parseDouble(temperaturaT);

            if(modelo.equals("")) {
                return "ERRO: O modelo não pode estar vazio";
            }
            if(descricao.equals("")) {
                return "ERRO: O descricao não pode estar vazio";
            }
            if(valorBase < 0){
                return "ERRO: Valor base não pode ser negativo";
            }
            if(peso < 0){
                return "ERRO: Peso não pode ser negativo";
            }
            if(temperatura < 0){
                return "ERRO: Temperatura não pode ser negativo";
            }
            if(fornecedor == null){
                return "ERRO: Fornecedor não pode ser nulo";
            }
            
            for (Tecnologia tecnologia : arrayTecnologias) {
                if (tecnologia.getId() == id) {
                    return "ERRO: Id repetido";
                }
            }

            Tecnologia novaTecnologia = new Tecnologia(id, modelo, descricao, valorBase, peso, temperatura, fornecedor);
            arrayTecnologias.add(novaTecnologia);
            Collections.sort(arrayTecnologias, Comparator.comparing(Tecnologia::getId));
            
            return "Tecnologia cadastrada";
        } catch(NumberFormatException e){
            return "ERRO: " + e.getLocalizedMessage();
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

    public String mostrarRelatorioDeTecnologias() {
        String retorno = "";
        for(Tecnologia t : arrayTecnologias) {
            retorno = retorno + t.geraDescricao() + "\n" + "\n";
        }
        return retorno; 
    }

    @Override
    public String geraDescricao() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return this.getCod() + ";" + this.getNome() + ";" + this.geraData() + ";" + this.getArea();
    }

    public String geraData() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return data.format(fundacao);
    }   
}
