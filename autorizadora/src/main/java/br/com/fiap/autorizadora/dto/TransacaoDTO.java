package br.com.fiap.autorizadora.dto;

import java.util.Date;

public class TransacaoDTO {

    private Long id;

    private Date dataTransacao;

    private Double valor;

    private CartaoDTO cartaoDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public CartaoDTO getCartaoDTO() {
        return cartaoDTO;
    }

    public void setCartaoDTO(CartaoDTO cartaoDTO) {
        this.cartaoDTO = cartaoDTO;
    }
}
