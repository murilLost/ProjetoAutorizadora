package br.com.fiap.autorizadora.dto;

import java.time.LocalDateTime;

public record TransacaoSimpleDTO(
        Double valor,
        LocalDateTime dataTransacao
) {
}
