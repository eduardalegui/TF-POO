package entidades;

import java.util.ArrayList;

public class Comprador extends Participante{
    private String pais;
    private String email;
    private ArrayList<Venda> arrayVenda;

    public Comprador(long cod, String nome, String pais, String email){
        super(cod, nome);
        this.pais = pais;
        this.email = email;
    }

    public String geraDescricao(){
        return null;
    }
}