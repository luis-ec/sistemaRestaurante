package model;
import java.time.LocalDate;

public class Pagamento {

    private int id_pagamento;
    private LocalDate data_pagamento;
    private double valorTotal ;
    public enum tipoPagamento{
        PIX,
        CARTÃO,
        DINHEIRO
    }
    private tipoPagamento tipoPagamento;

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

    public Pagamento.tipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(Pagamento.tipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
