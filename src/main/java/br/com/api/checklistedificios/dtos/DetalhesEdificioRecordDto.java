package br.com.api.checklistedificios.dtos;

import jakarta.validation.constraints.NotBlank;

public record DetalhesEdificioRecordDto(
        @NotBlank String nomeDoAndar,
        @NotBlank int quantidadeDeAndares,
        @NotBlank int quantidadeDeGaragens,
        @NotBlank int quantidadeDeSalaoDeFesta,
        @NotBlank int quantidadeDeGuaritas,
        @NotBlank int quantidadeDeTerracos
) {
}
