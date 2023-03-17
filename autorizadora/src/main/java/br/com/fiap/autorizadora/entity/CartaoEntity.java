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

    public CartaoEntity(String numero, Integer cvv, String mesDataExpiracao, String anoDataExpiracao) {
        this.numero = numero;
        this.cvv = cvv;
        this.mesDataExpiracao = mesDataExpiracao;
        this.anoDataExpiracao = anoDataExpiracao;
    }

    public CartaoEntity(String numero, Long idCliente, Integer cvv, String mesDataExpiracao, String anoDataExpiracao, Double limite) {
        this.numero = numero;
        this.idCliente = idCliente;
        this.cvv = cvv;
        this.mesDataExpiracao = mesDataExpiracao;
        this.anoDataExpiracao = anoDataExpiracao;
        this.limite = limite;
    }

    @Id
    private String numero;

    @Column
    @NotNull
    private Integer cvv;

    @Column
    @NotNull
    private String mesDataExpiracao;

    @Column
    @NotNull
    private String anoDataExpiracao;

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

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
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

    public List<TransacaoEntity> getTransacoes() {
        return transacoes;
    }
}
