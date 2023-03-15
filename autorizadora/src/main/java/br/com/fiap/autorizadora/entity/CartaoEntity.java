package br.com.fiap.autorizadora.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "TB_CARTAO")
@EntityListeners(AuditingEntityListener.class)
public class CartaoEntity {

    public CartaoEntity(){
    }

    public CartaoEntity(String numero, Integer cvv, LocalDate dataExpiracao) {
        this.numero = numero;
        this.cvv = cvv;
        this.dataExpiracao = dataExpiracao;
    }

    public CartaoEntity(String numero, Long idCliente, Integer cvv, LocalDate dataExpiracao, Double limite) {
        this.numero = numero;
        this.idCliente = idCliente;
        this.cvv = cvv;
        this.dataExpiracao = dataExpiracao;
        this.limite = limite;
    }

    @Id
    private String numero;

    @Column
    @NotNull
    private Integer cvv;

    @Column
    @NotNull
    private LocalDate dataExpiracao;

    @Column
    @NotNull
    private Long idCliente;

    @Column
    @NotNull
    private Double limite;

    @OneToMany(mappedBy = "cartao")
    private List<TransacaoEntity> transacoes;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getId() { return idCliente; }
    public void setId(Long id) { this.idCliente = id; }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Double getLimite() {
        return limite;
    }

    public void setLimite(Double limite) {
        this.limite = limite;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public List<TransacaoEntity> getTransacoes() {
        return transacoes;
    }
}
