package br.com.fiap.autorizadora.dto;

import br.com.fiap.autorizadora.entity.CartaoEntity;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CartaoDTO(

        Long numero,
        Integer id,
        Integer cvv,
        Date dataExpiracao

){
}
