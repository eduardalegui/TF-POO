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

    public void setArrayTecnologias(Tecnologia t) {
        this.arrayTecnologias.add(t);
        Collections.sort(arrayTecnologias, Comparator.comparing(Tecnologia::getId));
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
        return this.getCod() + ";" + this.getNome() + ";" + this.geraData() + ";" + this.getArea();
    }

    public String geraData() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return data.format(fundacao);
    }   
}