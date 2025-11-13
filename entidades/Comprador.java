package entidades;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Comprador extends Participante{
    private String pais;
    private String email;
    private ArrayList<Venda> arrayVenda;

    public Comprador(long cod, String nome, String pais, String email){
        super(cod, nome);
        this.pais = pais;
        this.email = email;
        arrayVenda = new ArrayList<>();
    }

    public String getPais() {
        return this.pais;
    }

    public String getEmail() {
        return this.email;
    }

    public ArrayList<Venda> getArrayVenda() {
        return this.arrayVenda;
    }

    public void cadastrarVenda(String stringNum, String stringDate, Comprador comprador, Tecnologia tecnologia) {
        try {
            long num = Long.parseLong(stringNum);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR"));
            Date date = dateFormat.parse(stringDate);
            
            for(Venda v : arrayVenda) {
                if(v.getNum() == num) {
                    return;
                }
            }
            Venda venda = new Venda(num, date, comprador, tecnologia);
            arrayVenda.add(venda);
        } catch(NullPointerException e) {
            return;
        } catch (Exception e) {
            return;
        }
        
    }

    public String geraDescricao(){
        return this.getCod() + ";" + this.getNome() + ";" + this.getPais() + ";" + this.getEmail();
    }
}