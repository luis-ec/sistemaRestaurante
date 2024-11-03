package model;

public class Cardapio {

    private int id_cardapio;
    private String nome_prato;
    private String descricao_prato;
    private double valor_prato;
    private int quantidade;
    private Ingrediente ingrediente;

    public int getId_cardapio() {
        return id_cardapio;
    }

    public void setId_cardapio(int id_cardapio) {
        this.id_cardapio = id_cardapio;
    }

    public String getNome_prato() {
        return nome_prato;
    }

    public void setNome_prato(String nome_prato) {
        this.nome_prato = nome_prato;
    }

    public String getDescricao_prato() {
        return descricao_prato;
    }

    public void setDescricao_prato(String descricao_prato) {
        this.descricao_prato = descricao_prato;
    }

    public double getValor_prato() {
        return valor_prato;
    }

    public void setValor_prato(double valor_prato) {
        this.valor_prato = valor_prato;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }
}
