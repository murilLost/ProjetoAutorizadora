package br.com.fiap.autorizadora.model;

public class DataExpiracaoModel {

    private String mesDataExpiracao;

    private String anoDataExpiracao;

    public DataExpiracaoModel(String mesDataExpiracao, String anoDataExpiracao) {
        this.mesDataExpiracao = mesDataExpiracao;
        this.anoDataExpiracao = anoDataExpiracao;
    }

    public String getMesDataExpiracao() {
        return mesDataExpiracao;
    }

    public void setMesDataExpiracao(String mesDataExpiracao) {
        this.mesDataExpiracao = mesDataExpiracao;
    }

    public String getAnoDataExpiracao() {
        return anoDataExpiracao;
    }

    public void setAnoDataExpiracao(String anoDataExpiracao) {
        this.anoDataExpiracao = anoDataExpiracao;
    }
}
