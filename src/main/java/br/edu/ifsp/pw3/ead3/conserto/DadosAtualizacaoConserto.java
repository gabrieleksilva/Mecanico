package br.edu.ifsp.pw3.ead3.conserto;

import br.edu.ifsp.pw3.ead3.mecanico.DadosMecanico;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosAtualizacaoConserto(
        @NotNull
        Long id,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato inválido. Use o formato xx/xx/xxxx.")
        String dtSaida,
        DadosMecanico dadosMecanico) { }
