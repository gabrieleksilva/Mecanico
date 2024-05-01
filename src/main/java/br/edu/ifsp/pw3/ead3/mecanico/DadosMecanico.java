package br.edu.ifsp.pw3.ead3.mecanico;

import jakarta.validation.constraints.NotBlank;

public record DadosMecanico(
        @NotBlank
        String nome,
        String experiencia) {
}
