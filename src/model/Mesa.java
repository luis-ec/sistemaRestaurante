package model;

public class Mesa {

    private int id_mesa;
    private int qtd_cadeira;
    public enum StatusMesa {
        LIVRE,
        OCUPADA,
        RESERVADA
    }
    private StatusMesa status;

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getQtd_cadeira() {
        return qtd_cadeira;
    }

    public void setQtd_cadeira(int qtd_cadeira) {
        this.qtd_cadeira = qtd_cadeira;
    }

    public StatusMesa getStatus() {
        return status;
    }

    public void setStatus(StatusMesa status) {
        this.status = status;
    }
}
