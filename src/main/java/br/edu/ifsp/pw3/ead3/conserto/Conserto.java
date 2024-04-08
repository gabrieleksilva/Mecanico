package br.edu.ifsp.pw3.ead3.conserto;

import br.edu.ifsp.pw3.ead3.mecanico.Mecanico;
import br.edu.ifsp.pw3.ead3.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "consertos")
@Entity(name = "Conserto")
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dtEntrada;
    private String dtSaida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;

    public Conserto(DadosConserto dadosConserto) {
        this.dtEntrada = dadosConserto.dtEntrada();
        this.dtSaida = dadosConserto.dtSaida();
        this.mecanico = new Mecanico(dadosConserto.mecanico());
        this.veiculo = new Veiculo(dadosConserto.veiculo());
    }
}
