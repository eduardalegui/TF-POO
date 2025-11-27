package src.entidades;

import java.util.*;

public class Comprador extends Participante{
    private String pais;
    private String email;
    private Queue<Venda> vendas;

    public Comprador(long cod, String nome, String pais, String email){
        super(cod, nome);
        this.pais = pais;
        this.email = email;
        vendas = new LinkedList<>();
    }

    public String getPais() {
        return this.pais;
    }

    public String getEmail() {
        return this.email;
    }

    public Queue<Venda> getArrayVenda() {
        return this.vendas;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setVendas(Venda v) {
        this.vendas.add(v);
        List<Venda> listaAlternativa = new ArrayList<>();
        listaAlternativa.addAll(vendas);
        Collections.sort(listaAlternativa, Comparator.comparing(Venda::getNum).reversed());
        vendas.clear();
        vendas.addAll(listaAlternativa);
    }

    public String mostrarRelatorioDeVendas() {
        String retorno = "";
        for(Venda v : vendas) {
            retorno = retorno + v.geraDescricao() + "\n" + "\n";
        }
        return retorno;
    }

    public String removerOsDadosDeUmaDeterminadaVenda(String stringNum) {
        try {
            long num = Long.parseLong(stringNum);
            for(Venda v : vendas) {
                if(v.getNum() == num) {
                    vendas.remove(v);
                    return "Venda removida";
                }
            }
        return "ERRO: Não existe venda com o id fornecido";
        } catch (Exception e) {
            return "ERRO: Id inválido";
        }
        
    }

    public String geraDescricao(){
        return this.getCod() + ";" + this.getNome() + ";" + this.getPais() + ";" + this.getEmail();
    }
}