package model;

import java.time.LocalDate;

public class PagamentoPix extends Pagamento { // HERANÇA

    private String codigoTransacao;

    public PagamentoPix(int idPagamento, LocalDate data, double valorTotal) {
        super(idPagamento, data, valorTotal);
    }

    public PagamentoPix() {
        super();
    }

    public String getCodigoTransacao() {
        return codigoTransacao;
    }

    public void processarPagamento() { //sobreescrita e polimorfismo
        System.out.println("Processando pagamento via PIX...");
        System.out.println("Pagamento confirmado!!!");
    }

    public void setCodigoTransacao(String next) {
    }
}

