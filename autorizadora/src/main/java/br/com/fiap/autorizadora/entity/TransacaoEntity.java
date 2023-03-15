package br.com.fiap.autorizadora.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table(name = "TB_TRANSACAO")
public class TransacaoEntity {

    public TransacaoEntity() {
    }

    public TransacaoEntity(LocalDateTime dataTransacao, Double valor, CartaoEntity cartao) {
        this.dataTransacao = dataTransacao;
        this.valor = valor;
        this.cartao = cartao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private LocalDateTime dataTransacao;

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

    public LocalDateTime getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(LocalDateTime dataTransacao) {
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
