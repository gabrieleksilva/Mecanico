package br.edu.ifsp.pw3.ead3.conserto;

public record DadosListagemConserto(
        Long id,
        String dtEntrada,
        String dtSaida,
        String marca,
        String modelo,
        String ano
) {
    public DadosListagemConserto(Conserto conserto) {
        this(conserto.getId(), conserto.getDtEntrada(), conserto.getDtSaida(),
                conserto.getVeiculo().getMarca(), conserto.getVeiculo().getModelo(),
                conserto.getVeiculo().getAno());
    }
}
