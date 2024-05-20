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
    public void atualizarInformacoes(DadosMecanico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.experiencia() != null) {
            this.experiencia = dados.experiencia();
        }
    }
}
