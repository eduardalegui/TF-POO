package src.entidades;

import java.text.DateFormat;
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

    public String cadastrarVenda(String stringNum, String stringDate, Comprador comprador, Tecnologia tecnologia) {
        try {
            long num = Long.parseLong(stringNum);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR"));

            if (stringDate.length() < 10) {
                return "ERRO: Data inválida";
            }
            if (stringDate.equals("")) {
                return "ERRO: A data não pode estar vazia";
            }
            if(comprador == null){
                return "ERRO: Comprador não pode ser nulo";
            }
            if(tecnologia == null){
                return "ERRO: Tecnologia não pode ser nula";
            }
            for(Venda v : vendas) {
                if(v.getNum() == num) {
                    return "ERRO:numero repetido";
                }
            }
            Date date = dateFormat.parse(stringDate);

            Venda venda = new Venda(num, date, comprador, tecnologia);
            vendas.add(venda);

            return "Venda cadastrada";
        } catch(NullPointerException e) {
            return "Preencha os dados corretamente e tente novamente";
        } catch(NumberFormatException e){
            return "ERRO: " + e.getLocalizedMessage();
        } catch (Exception e) {
            return "Revise seus dados e tente novamente";
        }
        
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
        return "ERRO: não existe venda com o id fornecido";
        } catch (Exception e) {
            return "ERRO: Id inválido";
        }
        
    }

    public String consultarVendaComMaiorValor(){
        ArrayList<Venda> vendasEmpatadas = new ArrayList<>();
        String retorno = "";
        if (vendas.isEmpty()) {
            return "Erro: Não há vendas cadastradas";
        }
        Venda maior = vendas.peek();
        for (Venda venda : vendas) {
            if (maior.calculaValorFinal() < venda.calculaValorFinal()) {
                maior = venda;
            }
        }
        vendasEmpatadas.add(maior);
        for (Venda venda : vendas) {
            if (maior.calculaValorFinal() == venda.calculaValorFinal()) {
                vendasEmpatadas.add(venda);
            }
        }
        for (Venda venda : vendasEmpatadas) {
            retorno = retorno + venda.geraDescricao() + "\n";
        }
        return retorno;
    }

    public String geraDescricao(){
        return this.getCod() + ";" + this.getNome() + ";" + this.getPais() + ";" + this.getEmail();
    }
}