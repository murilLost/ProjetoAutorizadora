package br.com.fiap.autorizadora.dto;

import jakarta.validation.constraints.Size;

public record TransacoesConsultaDTO(
        @Size(max = 16, min = 16, message = "O número de cartão inválido")
        String numeroCartao
) {
}
