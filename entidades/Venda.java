package entidades;

import java.util.Date;

public class Venda{
    private long num;
    private Date date;
    private double valorFinal;
    private Comprador comprador;

    public Venda(long num, Date date, double valorFinal, Comprador comprador){
        this.num = num;
        this.date = date;
        this.valorFinal = valorFinal;
        this.comprador = comprador;
    }

    public double calculaValorFinal(){
        return 0;
    }
    
}