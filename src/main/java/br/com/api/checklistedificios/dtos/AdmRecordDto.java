package br.com.api.checklistedificios.dtos;

import jakarta.validation.constraints.NotBlank;

public record AdmRecordDto(@NotBlank String nome,@NotBlank String email,@NotBlank String cpf) {
}
