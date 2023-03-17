package br.com.fiap.autorizadora.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CartaoCadastroDTO(
     @NotNull(message = "ID do aluno precisa ser preenchido.")
     @Size(min = 1, message = "ID do aluno inválido")
     Long idAluno

) {
}
