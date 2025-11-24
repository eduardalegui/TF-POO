package src.entidades;

public enum Area {
    TI("TI"), ANDROIDES("ANDROIDES"), EMERGENTE("EMERGENTE"), ALIMENTOS("ALIMENTOS");

    private String nome;

    private Area(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}