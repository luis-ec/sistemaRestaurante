package model;

import java.time.LocalDate;

public class PagamentoCartao extends Pagamento { // HERANÇA

    private String numeroCartao;
    private String Bandeira;
    private String dataExpiracao;
    private int CVV;

    public PagamentoCartao(int idPagamento, LocalDate data, double valorTotal) {
        super(idPagamento,
                data,
                valorTotal);
    }

    public PagamentoCartao() {

    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getBandeira() {
        return Bandeira;
    }

    public void setBandeira(String bandeira) {
        Bandeira = bandeira;
    }

    public String getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(String dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public int getCVV() {
        return CVV;
    }

    public void setCVV(int CVV) {
        this.CVV = CVV;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    private String nomeCartao;

    public void processarPagamento() { //sobreescrita
        System.out.println("Processando pagamento via cartão...");
        System.out.println("Pagamento Confirmado!!!");
    }


}
