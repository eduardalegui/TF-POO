package src.entidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class CatalogoParticipantes {
    private List<Participante> participantes;
    private List<Tecnologia> tecnologiasVendidas;
    private List<Tecnologia> tecnologiasSemFornecedor;

    public CatalogoParticipantes() {
        this.participantes = new ArrayList<>();
        this.tecnologiasVendidas = new ArrayList<>();
        this.tecnologiasSemFornecedor = new ArrayList<>();
    }

    public List<Participante> getParticipantes() {
        return this.participantes;
    }

    public List<Tecnologia> getTecnologiasSemFornecedor() {
        return this.tecnologiasSemFornecedor;
    }
    
    public String cadastrarFornecedor(String stringCod, String nome, String stringFundacao, String stringArea) {
        try {
            DateFormat date = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR"));
            boolean cadastrado = false;
            long cod = Long.parseLong(stringCod);
            
            if(cod < 1) {
                return "ERRO: Código inválido";
            }
            if(nome.equals("")) {
                return "ERRO: O nome não pode estar vazio";
            }
            if (nome.matches(".*\\d.*")) {
                return "ERRO: O nome não pode conter números";
            }
            if (stringFundacao.length() < 10) {
                return "ERRO: Data inválida";
            }
            if (stringFundacao.length() > 10) {
                return "ERRO: Data inválida";
            }
            if (stringFundacao.equals("")) {
                return "ERRO: A data não pode estar vazia";
            }
            if (stringArea.equals("")) {
                return "ERRO: A área não pode estar vazia";
            }
            String data = stringFundacao.trim();
            Date fundacao = date.parse(data);
            

            for(Participante p : participantes) {
                if (p instanceof Fornecedor) {
                    if(p.getCod() == cod) {
                        return "ERRO: Codigo repetido";
                    }
                }
            }

            Area area = verificarArea(stringArea);

            Fornecedor f = new Fornecedor(cod, nome, fundacao, area);
            for(int i = 0; i < participantes.size(); i++) {
                if(participantes.get(i).getCod() > cod) {
                    cadastrado = true;
                    participantes.add(i, f);
                    break;
                }
            }

            if(!cadastrado) {
                participantes.add(f);
            }

            return "Fornecedor cadastrado";
        } catch(NullPointerException e) {
            return "ERRO: Preencha todos os campos corretamente";
        } catch (ParseException e) {
            return "ERRO:Data no formato incorreto";
        } catch (Exception e) {
            return "ERRO: Revise seus dados e tente novamente";
        }
    }

    public String cadastrarComprador(String stringCod, String nome, String pais, String email) {
        try {
            boolean cadastrado = false;
            long cod = Long.parseLong(stringCod);

            if(nome.equals("")) {
                return "ERRO: O nome não pode estar vazio";
            }
            if (nome.matches(".*\\d.*")) {
                return "ERRO: O nome não pode conter números";
            }
            if (pais.matches(".*\\d.*")) {
                return "ERRO: O pais não pode conter números";
            }
            if (email.equals("")) {
                return "ERRO: O email não pode estar vazio";
            }
            if (!email.contains("@")) {
                return "ERRO: O email deve conter '@'";
            }
            if (email.length() < 6) {
                return "ERRO: Email muito curto";
            }
            if (cod < 1) {
                return "ERRO: Código inválido";
            }

            for(Participante p : participantes) {
                if (p instanceof Comprador) {
                    if(p.getCod() == cod) {
                        return "ERRO: Código repetido";
                    }
                }
            }

            Comprador c = new Comprador(cod, nome, pais, email);
            for (int i = 0; i < participantes.size(); i++) {
                if (participantes.get(i).getCod() > cod) {
                    cadastrado = true;
                    participantes.add(i, c);
                    break;
                }
            }

            if (!cadastrado) {
                participantes.add(c);
            }
            return "Comprador cadastrado";
        } catch (NullPointerException e) {
            return "ERRO: Preencha todos os campos corretamente";
        } catch (Exception e) {
            return "ERRO: Revise seus dados e tente novamente";
        }
    }

    public Area verificarArea(String area) {
        String capsLock = area.toUpperCase();
        for(Area a : Area.values()) {
            if(a.getNome().equals(capsLock)) {
                return a;
            }
        } 
        return null;
    }

    public String consultarFornecedorComMaisTecnologias(){
        ArrayList<Fornecedor> fornecedoresEmpatados = new ArrayList<>();
        String retorno = "";
        ArrayList<Fornecedor> arrayFornecedores = new ArrayList<>();
        for (Participante p : participantes) {
            if (p instanceof Fornecedor) {
                arrayFornecedores.add((Fornecedor) p);
            }
        }
        if (arrayFornecedores.size() == 0) {
            return "ERRO: Não há fornecedores cadastrados";
        }
        Fornecedor maior = arrayFornecedores.get(0);
        for (Fornecedor f: arrayFornecedores) {
            if (maior.getArrayTecnologia().size() < f.getArrayTecnologia().size()) {
                maior = f;
            }
        }
        fornecedoresEmpatados.add(maior);
        for (Fornecedor f : arrayFornecedores) { 
            if (maior.getArrayTecnologia().size() == f.getArrayTecnologia().size() && maior.getCod() != f.getCod()) {
                fornecedoresEmpatados.add(f);
            }
        }
        for (Fornecedor f : fornecedoresEmpatados) {
            retorno = retorno + f.geraDescricao() + ";" + f.getArrayTecnologia().size() + "\n";
        }
        return retorno;
    }

    public String consultarCompradorComMaisVendas(){
        ArrayList<Comprador> compradoresEmpatados = new ArrayList<>();
        String retorno = "";
        ArrayList<Comprador> arrayCompradores = new ArrayList<>();
        for (Participante p : participantes) {
            if (p instanceof Comprador) {
                arrayCompradores.add((Comprador) p);
            }
        }
        if (arrayCompradores.size() == 0) {
            return "ERRO: Não há fornecedores cadastrados";
        }
        Comprador maior = arrayCompradores.get(0);
        for (Comprador c: arrayCompradores) {
            if (maior.getArrayVenda().size() < c.getArrayVenda().size()) {
                maior = c;
            }
        }
        compradoresEmpatados.add(maior);
        for (Comprador comprador : arrayCompradores) { 
            if (maior.getArrayVenda().size() == comprador.getArrayVenda().size()) {
                compradoresEmpatados.add(comprador);
            }
        }
        for (Comprador comprador : compradoresEmpatados) {
            retorno = retorno + comprador.geraDescricao() + "\n";
        }
        
        return maior.geraDescricao();
    }

    public List<String> mostrarRelatorioDeFornecedores() {
        List<String> retorno = new ArrayList<>();
        List<Fornecedor> fornecedores = new ArrayList<>();
        for(Participante p : participantes) {
            if(p instanceof Fornecedor) {
                Fornecedor fornecedor = (Fornecedor) p;
                fornecedores.add(fornecedor);
            }
        }
        if(fornecedores.size() == 0) {
            retorno.add("ERRO: Não existem fornecedores cadastrados");
            return retorno;
        }
        for(Fornecedor f : fornecedores) {
            retorno.add(f.geraDescricao());
        }
        return retorno;
    }

    public List<String> mostrarRelatorioDeCompradores() {
        List<String> retorno = new ArrayList<>();
        List<Comprador> compradores = new ArrayList<>();
        for(Participante p : participantes) {
            if(p instanceof Comprador) {
                Comprador comprador = (Comprador) p;
                compradores.add(comprador);
            }
        }
        if(compradores.size() == 0) {
            retorno.add("ERRO: Não existem compradores cadastrados");
        }
        for(Comprador c : compradores) {
            retorno.add(c.geraDescricao());
        }
        return retorno;
    }

    public String removerOsDadosDeUmDeterminadoComprador(long cod) {
        for(Participante p : participantes) {
            if(p instanceof Comprador) {
                if(p.getCod() == cod) {
                    Comprador comprador = (Comprador) p;
                    return comprador.geraDescricao();
                }
            }
        }
        return "ERRO: Não existe comprador com este código";
    }

    public String mostrarOsDadosDeUmDeterminadoComprador(String stringCod) {
        try {
            long cod = Long.parseLong(stringCod);
            for(Participante p : participantes) {
                if(p instanceof Comprador) {
                    Comprador c = (Comprador) p;
                    if(c.getCod() == cod) {
                        return c.getCod() + ";" + c.getNome() + ";" + c.getPais() + ";" + c.getEmail();
                    }
                }
            }
            return "ERRO: Comprador nao encontrado";
        } catch(NumberFormatException e) {
            return "ERRO: Codigo invalido";
        } catch(NullPointerException e) {
            return "ERRO: Comprador nao encontrado";
        }
    }

    public String alterarOsDadosDeUmDeterminadoComprador(String stringCod, String nome, String pais, String email) {
        try {
            Comprador c = null;
            boolean modificado = false;
            long cod = Long.parseLong(stringCod);
            for(Participante p : participantes) {
                if(p instanceof Comprador) {
                    c = (Comprador) p;
                    if(c.getCod() == cod) {
                        if (nome.matches(".*\\d.*")) {
                            return "ERRO: O nome não pode conter números";
                        }
                        if (!email.contains("@")) {
                            return "ERRO: O email deve conter '@'";
                        }
                        if (email.length() < 6) {
                            return "ERRO: Email muito curto";
                        }
                        if (pais.matches(".*\\d.*")) {
                            return "ERRO: O pais não pode conter números";
                        }
                        if(!nome.equals("")) {
                            modificado = true;
                            c.setNome(nome);
                        }
                        if(!pais.equals("")) {
                            modificado = true;
                            c.setPais(pais);
                        }
                        if(!email.equals("")) {
                            modificado = true;
                            c.setEmail(email);
                        }
                    }
                }
            }
            if(c == null) {
                return "ERRO: Comprador nao encontrado";
            } else if(modificado) {
                return "ERRO: Comprador modificado";
            } else {
                return "ERRO: Nenhum campo preenchido";
            }            
        } catch(NumberFormatException e) {
            return "ERRO: Codigo invalido";
        } catch(NullPointerException e) {
            return "ERRO: Comprador nao encontrado";
        }
    }

    public String consultarTecnologiaComMaiorValor() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        List<Tecnologia> arrayTecnologias = new ArrayList<>();
        for(Participante p : participantes) {
            if(p instanceof Fornecedor) {
                Fornecedor f = (Fornecedor) p;
                fornecedores.add(f);
            }
        }
        ArrayList<Tecnologia> tecnologiasEmpatadas = new ArrayList<>();
        String retorno = "";
        Tecnologia maior = null;
        for(Fornecedor f : fornecedores) {
            for(Tecnologia t : f.getArrayTecnologia()) {
                arrayTecnologias.add(t);
                if(maior == null) {
                    maior = t;
                } else if(maior.getValorBase() < t.getValorBase()) {
                    maior = t;
                }
            }
        }
        for(Tecnologia t : tecnologiasSemFornecedor) {
            arrayTecnologias.add(t);
            if(maior == null) {
                maior = t;
            } else if(maior.getValorBase() < t.getValorBase()){
                maior = t;
            }
        }
        if(maior == null) {
            return "ERRO: Nenhuma tecnologia cadastrada";
        }
        tecnologiasEmpatadas.add(maior);
        for (Tecnologia tecnologia : arrayTecnologias) {
            if (maior.getValorBase() == tecnologia.getValorBase() && maior.getId() != tecnologia.getId()) {
                tecnologiasEmpatadas.add(tecnologia);
            }
        }
        for (Tecnologia tecnologia : tecnologiasEmpatadas) {
            retorno = retorno + tecnologia.geraDescricao() + "\n";
        }
        return retorno;
    }

    public String consultarVendaComMaiorValor(){
        List<Venda> vendasEmpatadas = new ArrayList<>();
        List<Venda> vendas = new ArrayList<>();
        String retorno = "";
        for(Participante p : participantes) {
            if(p instanceof Comprador) {
                Comprador c = (Comprador) p;
                for(Venda v : c.getArrayVenda()) {
                    vendas.add(v);
                }
            }
        }
        if (vendas.isEmpty()) {
            return "ERRO: Não há vendas cadastradas";
        }
        Venda maior = vendas.get(0);
        for (Venda venda : vendas) {
            if (maior.getValorFinal() < venda.getValorFinal()) {
                maior = venda;
            }
        }
        vendasEmpatadas.add(maior);
        for (Venda venda : vendas) {
            if (maior.getValorFinal() == venda.getValorFinal() && maior.getNum() != venda.getNum()) {
                vendasEmpatadas.add(venda);
            }
        }
        for (Venda venda : vendasEmpatadas) {
            retorno = retorno + venda.geraDescricao() + "\n";
        }
        return retorno;
    }

    public ArrayList<String> getArrayNomesCompradores(){
        ArrayList<String> array = new ArrayList<>();
        array.add("");
        for (Participante p : participantes) {
            if (p instanceof Comprador) {
                Comprador c = (Comprador) p;
                array.add(c.getNome());
            }
        }
        return array;
    }

    public ArrayList<String> getIdsTecnologias(){
        ArrayList<String> array = new ArrayList<>();
        array.add("");
        for (Participante p : participantes) {
            if (p instanceof Fornecedor) {
                Fornecedor f = (Fornecedor) p;
                for (Tecnologia t : f.getArrayTecnologia()) {
                    array.add(String.valueOf(t.getId()));
                }
            }
        }
        for(Tecnologia t : tecnologiasSemFornecedor) {
            array.add(String.valueOf(t.getId()));
        }
        return array;
    }

    public ArrayList<String> getArrayNomesFornecedores(){
        ArrayList<String> array = new ArrayList<>();
        array.add("");
        for (Participante p : participantes) {
            if (p instanceof Fornecedor) {
                Fornecedor f = (Fornecedor) p;
                array.add(f.getNome() + " - " + f.getArea().getNome());
            }
        }
        return array;
    }

    public String cadastrarVenda(String stringNum, String stringDate, Comprador comprador, Tecnologia tecnologia) {
        try {
            List<Comprador> compradores = new ArrayList<>();
            long num = Long.parseLong(stringNum);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("pt", "BR"));
            
            if(num < 1) {
                return "ERRO: Número inválido";
            }
            if (stringDate.length() < 10) {
                return "ERRO: Data inválida";
            }
            if (stringDate.length() > 10) {
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
            for(Participante p : participantes) {
                if(p instanceof Comprador) {
                    Comprador c = (Comprador) p;
                    compradores.add(c);
                }
            }
            for(Comprador c : compradores) {
                for(Venda v : c.getArrayVenda()) {
                    if(v.getNum() == num) {
                        return "ERRO:numero repetido";
                    }
                }
            }
            for(Tecnologia t : tecnologiasVendidas) {
                if(t.getId() == tecnologia.getId()) {
                    return "ERRO: Tecnologia ja foi vendida";
                }
            }
            tecnologiasVendidas.add(tecnologia);
            Date date = dateFormat.parse(stringDate);

            Venda venda = new Venda(num, date, comprador, tecnologia);
            venda.calculaValorFinal();
            comprador.setVendas(venda);
            
            return "Venda cadastrada";
        } catch(NullPointerException e) {
            return "ERRO: Preencha os dados corretamente e tente novamente";
        } catch(NumberFormatException e){
            return "ERRO: O número da venda tem que ser um número inteiro";
        } catch (Exception e) {
            return "ERRO: Revise seus dados e tente novamente";
        }
    }

    public String cadastrarTecnologia(String idT, String modelo, String descricao, String valorBaseT, String pesoT, String temperaturaT, Fornecedor fornecedor){
        try {            
            List<Fornecedor> fornecedores = new ArrayList<>();
            long id = Long.parseLong(idT);
            double valorBase = Double.parseDouble(valorBaseT);
            double peso = Double.parseDouble(pesoT);
            double temperatura = Double.parseDouble(temperaturaT);

            if(id < 1) {
                return "ERRO: Id inválido";
            }
            if(modelo.equals("")) {
                return "ERRO: O modelo não pode estar vazio";
            }
            if(descricao.equals("")) {
                return "ERRO: O descricao não pode estar vazio";
            }
            if(valorBase < 0){
                return "ERRO: Valor base não pode ser negativo";
            }
            if(peso < 0){
                return "ERRO: Peso não pode ser negativo";
            }
            if(temperatura < 0){
                return "ERRO: Temperatura não pode ser negativo";
            }

            for(Participante p : participantes) {
                if(p instanceof Fornecedor) {
                    Fornecedor f = (Fornecedor) p;
                    fornecedores.add(f);
                }
            }
            for(Fornecedor f : fornecedores) {
                for (Tecnologia tecnologia : f.getArrayTecnologia()) {
                    if (tecnologia.getId() == id) {
                        return "ERRO: Id repetido";
                    }
                }
            }
            for(Tecnologia t : tecnologiasSemFornecedor) {
                if(t.getId() == id) {
                    return "ERRO: Id repetido";
                }
            }
            Tecnologia novaTecnologia = new Tecnologia(id, modelo, descricao, valorBase, peso, temperatura, fornecedor);

            if (fornecedor != null) {
                fornecedor.setArrayTecnologias(novaTecnologia);
            } else {
                tecnologiasSemFornecedor.add(novaTecnologia);
                Collections.sort(tecnologiasSemFornecedor, Comparator.comparing(Tecnologia::getId));
            }
            
            return "Tecnologia cadastrada";
        } catch(NumberFormatException e){
            return "ERRO: Preencha os campos corretamente";
        } catch (Exception e) {
            return "ERRO: Revise seus dados e tente novamente";
        }
    }
    public String mostrarRelatorioDeTecnologiasSemFornecedor() {
        String retorno = "";
        for(Tecnologia t : tecnologiasSemFornecedor) {
            retorno = retorno + t.geraDescricao() + "\n" + "\n";
        }
        return retorno; 
    } 

    public String definirFornecedor(String id, String fornecedorT){
        try {
            Fornecedor f = null;
            Fornecedor fornecedor = null;
            long cod = Long.parseLong(id);
            
            if(cod < 1) {
                return "ERRO: Id inválido";
            }
            
            
            for (Participante participante : participantes) {
                if (participante instanceof Fornecedor) {
                    fornecedor = (Fornecedor) participante;
                    if (fornecedorT == participante.getNome()) {
                        f = fornecedor;
                    }
                }
            }
            if (achaTecnologia(cod, f)) {
                return "Fornecedor definido";
            }
            else return "ERRO: Id não encontrado";
        } catch (Exception e) {
            return "ERRO: Revise seus dados e tente novamente";
        }
    }

    public boolean achaTecnologia(long cod, Fornecedor f){
        List<Fornecedor> fornecedores = new ArrayList<>();
        for(Participante p : participantes) {
            if(p instanceof Fornecedor) {
                Fornecedor fornecedor = (Fornecedor) p;
                fornecedores.add(fornecedor);
            }
        }
        for(Fornecedor fornecedor : fornecedores) {
            for (Tecnologia tecnologia : fornecedor.getArrayTecnologia()) {
                if (tecnologia.getId() == cod) {
                    tecnologia.defineFornecedor(f);
                    return true;
                }
            }
        }
        for (Tecnologia tecnologia : tecnologiasSemFornecedor){
            if (tecnologia.getId() == cod){
                tecnologia.defineFornecedor(f);
                return true;
            }
        }
        return false;
    } 
}