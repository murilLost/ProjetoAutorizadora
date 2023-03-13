package br.com.fiap.autorizadora.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TB_TRANSACAO")
public class TransacaoEntity {

    public TransacaoEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date dataTransacao;

    @Column
    private Double valor;

    @ManyToOne
    private CartaoEntity cartao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public CartaoEntity getCartao() {
        return cartao;
    }

    public void setCartao(CartaoEntity cartao) {
        this.cartao = cartao;
    }
}
