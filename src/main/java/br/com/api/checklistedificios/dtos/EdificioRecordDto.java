package br.com.api.checklistedificios.dtos;

import jakarta.validation.constraints.NotBlank;

public record EdificioRecordDto (@NotBlank String nome, @NotBlank String cnpj, @NotBlank String endereco){
}