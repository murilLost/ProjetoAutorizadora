package br.com.fiap.autorizadora.dto;

import jakarta.validation.constraints.NotNull;

public record CartaoCadastroDTO(
     @NotNull(message = "ID do aluno precisa ser preenchido.")
     Long idAluno

) {
}
