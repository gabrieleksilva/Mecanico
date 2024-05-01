package br.edu.ifsp.pw3.ead3.veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculo(
        @NotBlank
        String marca,
        @NotBlank
        String modelo,
        @Pattern(regexp = "\\d{4}")
        String ano,
        String cor
) {
}
