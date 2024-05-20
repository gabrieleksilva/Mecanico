package br.edu.ifsp.pw3.ead3.controller;

import br.edu.ifsp.pw3.ead3.conserto.*;
import br.edu.ifsp.pw3.ead3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired private ConsertoRepository repository;

    //http://localhost:8080/consertos
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosConserto dados,
                          UriComponentsBuilder uriBuilder){
        var conserto = new Conserto(dados);
        repository.save(conserto);
        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(conserto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoConserto(conserto));
    }

    //body para teste de cadastro
    /* {
            "dtEntrada": "23/01/2019",
            "dtSaida": "01/02/2020",
            "mecanico": {
                "nome": "Julia",
                "experiencia": ""
            },
            "veiculo": {
                "marca": "Chevrolet",
                "modelo": "Celta",
                "ano": "2015",
                "cor":"azul"
            }
        }
    *
    * */
    //http://localhost:8080/consertos?page=0&size=1
    @GetMapping
    public ResponseEntity listar(Pageable paginacao) {
        return ResponseEntity.ok(repository.findAll(paginacao));
    }
    //http://localhost:8080/algunsDados
    @GetMapping("algunsDados")
    public ResponseEntity listarAlgunsDados() {
        var pagina = repository.findAllByAtivoTrue().stream().map(DadosListagemConserto::new);
        return ResponseEntity.ok(pagina);
    }
    @GetMapping("/{id}")
    public ResponseEntity getConsertoById(@PathVariable Long id) {
        Optional<Conserto> consertoOptional = repository.findById(id);
            return ResponseEntity.ok(new DadosDetalhamentoConserto(consertoOptional.get()));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoConserto dados) {
        Conserto conserto = repository.getReferenceById( dados.id() );
        conserto.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConserto(conserto));
    }
    /* body para teste de update
    * {
        "id": 7,
        "dtSaida": "02/25/2021",
        "dadosMecanico": {
            "nome": "Rafael",
            "experiencia": "25"
        }
      }
    * */

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
