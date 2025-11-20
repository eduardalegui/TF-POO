package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Venda{
    private long num;
    private Date date;
    private double valorFinal;
    private Comprador comprador;
    private Tecnologia tecnologia;

    public Venda(long num, Date date, Comprador comprador, Tecnologia tecnologia){
        this.num = num;
        this.date = date;
        this.comprador = comprador;
        this.tecnologia = tecnologia;
    }

    public double calculaValorFinal(){
        double valorFinal = 0;
        double valorBase = tecnologia.getValorBase();
        Area area = tecnologia.getFornecedor().getArea();
        int qtdVendas;
        if (comprador.getArrayVenda().size() > 10) {
            qtdVendas = 10;
        }
        else{
            qtdVendas = comprador.getArrayVenda().size();
        }

        if (area == Area.TI) {
            valorFinal = valorBase + (valorBase * ((20 - qtdVendas) / 100));
        }
        if (area == Area.ANDROIDES) {
            valorFinal = valorBase + (valorBase * ((15 - qtdVendas) / 100));
        }
        if (area == Area.ALIMENTOS) {
            valorFinal = valorBase + (valorBase * ((10 - qtdVendas) / 100));
        }
        if (area == Area.EMERGENTE) {
            valorFinal = valorBase + (valorBase * ((25 - qtdVendas) / 100));
        }

        return valorFinal;
    }

    public long getNum() {
        return this.num;
    }

    public Date getDate() {
        return this.date;
    }

    public double getValorFinal() {
        return this.valorFinal;
    }

    public Comprador getComprador() {
        return this.comprador;
    }

    public Tecnologia getTecnologia() {
        return this.tecnologia;
    }

    public String geraDescricao() {
        return this.num + ";" + this.geraData() + ";" + this.valorFinal + ";" + this.comprador.geraDescricao() + ";" + this.tecnologia.geraDescricao();
    }

    public String geraData() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        return data.format(this.date);
    }

}           