package br.com.api.checklistedificios.dtos;

import br.com.api.checklistedificios.models.EdificioModel;
import jakarta.validation.constraints.NotBlank;

public record DetalhesEdificioRecordDto(

        @NotBlank EdificioModel edificioModel,
        @NotBlank String nomeDoAndar,
        @NotBlank int quantidadeDeAndares,
        @NotBlank int quantidadeDeGaragens,
        @NotBlank int quantidadeDeSalaoDeFesta,
        @NotBlank int quantidadeDeGuaritas,
        @NotBlank int quantidadeDeTerracos
) {
}
