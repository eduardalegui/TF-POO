package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Fornecedor extends Participante{
    private Date fundacao;
    private Area area;

    public Fornecedor(long cod, String nome, Date fundacao, Area area) {
        super(cod, nome);
        this.fundacao = fundacao;
        this.area = area;
    }

    public Date getFundacao() {
        return this.fundacao;
    }

    @Override
    public String geraDescricao() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return this.getCod() + "," + this.getNome() + "," + data.format(this.getFundacao());
    }
}
