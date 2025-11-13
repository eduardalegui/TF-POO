package entidades;

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
        return 0;
    }

    public long getNum() {
        return this.num;
    }

    public Date getDate() {
        return this.date;
    }

}