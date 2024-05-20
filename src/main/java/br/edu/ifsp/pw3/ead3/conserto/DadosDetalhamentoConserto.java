package br.edu.ifsp.pw3.ead3.conserto;

import br.edu.ifsp.pw3.ead3.mecanico.Mecanico;
import br.edu.ifsp.pw3.ead3.veiculo.Veiculo;

public record DadosDetalhamentoConserto(
        Long id,
        String dtEntrada,
        String dtSaida,
        Mecanico mecanico,
        Veiculo veiculo,
        Boolean ativo
) {
    public DadosDetalhamentoConserto(Conserto conserto) {
        this(conserto.getId(), conserto.getDtEntrada(), conserto.getDtSaida(), conserto.getMecanico(),
                conserto.getVeiculo(), conserto.getAtivo());
    }
}
