package src.entidades;

public class Tecnologia {
    private long id;
    private String modelo;
    private String descricao;
    private double valorBase;
    private double peso;
    private double temperatura;
    private Fornecedor fornecedor;

    public Tecnologia(long id, String modelo, String descricao, double valorBase, double peso, double temperatura, Fornecedor fornecedor) {
        this.id = id;
        this.modelo = modelo;
        this.descricao = descricao;
        this.valorBase = valorBase;
        this.peso = peso;
        this.temperatura = temperatura;
        this.fornecedor = fornecedor;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorBase() {
        return this.valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return this.temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public Fornecedor getFornecedor() {
        return this.fornecedor;
    }

    public void defineFornecedor(Fornecedor f) {
        this.fornecedor = f;
    }

    public String geraDescricao() {
        return this.id + ";" + this.modelo + ";" + this.descricao + ";" + this.valorBase + ";" + this.peso + ";" + 
            this.temperatura + ";" + this.fornecedor.geraDescricao();
    }
}
