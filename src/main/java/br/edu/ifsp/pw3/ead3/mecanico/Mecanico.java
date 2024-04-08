package br.edu.ifsp.pw3.ead3.mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private String experiencia;

    public Mecanico(DadosMecanico dadosMecanico) {
        this.nome = dadosMecanico.nome();
        this.experiencia = dadosMecanico.experiencia();
    }
}
