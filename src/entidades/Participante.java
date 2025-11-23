package src.entidades;

public abstract class Participante{
    private long cod;
    private String nome;

    public Participante(long cod, String nome){
        this.cod = cod;
        this.nome = nome;
    }

    public long getCod() {
        return this.cod;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract String geraDescricao();
}