package br.edu.ifsp.pw3.ead3.conserto;

import br.edu.ifsp.pw3.ead3.mecanico.DadosMecanico;
import br.edu.ifsp.pw3.ead3.veiculo.DadosVeiculo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;

public record DadosConserto(
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato inválido. Use o formato xx/xx/xxxx.")
        String dtEntrada,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato inválido. Use o formato xx/xx/xxxx.")
        String dtSaida,
        @Valid
        DadosMecanico mecanico,
        @Valid
        DadosVeiculo veiculo) {
}
