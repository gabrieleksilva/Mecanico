package br.edu.ifsp.pw3.ead3.conserto;

import br.edu.ifsp.pw3.ead3.mecanico.DadosMecanico;
import br.edu.ifsp.pw3.ead3.veiculo.DadosVeiculo;

public record DadosConserto(String dtEntrada, String dtSaida, DadosMecanico mecanico, DadosVeiculo veiculo) {
}
