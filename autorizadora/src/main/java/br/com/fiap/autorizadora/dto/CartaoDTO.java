package br.com.fiap.autorizadora.dto;

import br.com.fiap.autorizadora.entity.CartaoEntity;
import jakarta.validation.constraints.NotNull;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public record CartaoDTO(

        String numero,
        Integer cvv,
        String mesDataExpiracao,
        String anoDataExpiracao

){
}
