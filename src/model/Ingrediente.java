package model;

public class Ingrediente {

    private int id_ingrediente;
    private String nome_ingrediente;
    private String descricao_ingrediente;
    private int quantidade_ingrediente;

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNome_ingrediente() {
        return nome_ingrediente;
    }

    public void setNome_ingrediente(String nome_ingrediente) {
        this.nome_ingrediente = nome_ingrediente;
    }

    public String getDescricao_ingrediente() {
        return descricao_ingrediente;
    }

    public void setDescricao_ingrediente(String descricao_ingrediente) {
        this.descricao_ingrediente = descricao_ingrediente;
    }

    public int getQuantidade_ingrediente() {
        return quantidade_ingrediente;
    }

    public void setQuantidade_ingrediente(int quantidade_ingrediente) {
        this.quantidade_ingrediente = quantidade_ingrediente;
    }
}
