package model;
import java.time.LocalDate;

public class Pagamento {

    private int id_pagamento;
    private LocalDate data_pagamento;
    private double valorTotal ;

    public Pagamento() {

    }

    public int getId_pagamento() {
        return id_pagamento;
    }

    public void setId_pagamento(int id_pagamento) {
        this.id_pagamento = id_pagamento;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pagamento(int idPagamento, LocalDate data, double valorTotal) {
    }


    public void processarPagamento() {
        System.out.println("Processando pagamento...");
        System.out.println("Pagamento por dinheiro confirmado!!!");

    }
}
