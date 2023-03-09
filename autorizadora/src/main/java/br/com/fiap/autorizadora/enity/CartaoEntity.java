package br.com.fiap.autorizadora.enity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_CARTAO")
public class CartaoEntity {

    public CartaoEntity(){
    }

    @Id
    private Long numero;

    @Column
    @NotNull
    private Integer cvv;

    @Column
    @NotNull
    private Date dataExpiracao;

    @OneToMany(mappedBy = "cartao")
    private List<TransacaoEntity> transacoes;

    public Long getNumber() {
        return numero;
    }

    public void setNumber(Long number) {
        this.numero = number;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

}
