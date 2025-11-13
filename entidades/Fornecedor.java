package entidades;

import java.text.SimpleDateFormat;
import java.util.*;

public class Fornecedor extends Participante{
    private Date fundacao;
    private Area area;
    private ArrayList<Tecnologia> arrayTecnologias;

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

    public void cadastrarTecnologia(long id, String modelo, String descricao, double valorBase, double peso, double temperatura, Fornecedor fornecedor){
        try {
            for (Tecnologia tecnologia : arrayTecnologias) {
                if (tecnologia.getId() == id) {
                    return;
                }
                else{
                    Tecnologia novaTecnologia = new Tecnologia(id, modelo, descricao, valorBase, peso, temperatura, fornecedor);
                    arrayTecnologias.add(novaTecnologia);
                    Collections.sort(arrayTecnologias, Comparator.comparing(Tecnologia::getId));
                }
            }
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public String geraDescricao() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return this.getCod() + ";" + this.getNome() + ";" + data.format(this.getFundacao()) + this.getArea();
    }
}
