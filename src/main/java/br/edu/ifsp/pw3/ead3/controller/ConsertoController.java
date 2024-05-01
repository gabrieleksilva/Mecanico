package br.edu.ifsp.pw3.ead3.controller;

import br.edu.ifsp.pw3.ead3.conserto.Conserto;
import br.edu.ifsp.pw3.ead3.conserto.DadosConserto;
import br.edu.ifsp.pw3.ead3.conserto.DadosListagemConserto;
import br.edu.ifsp.pw3.ead3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired private ConsertoRepository repository;

    //http://localhost:8080/consertos
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosConserto dados){
        repository.save(new Conserto(dados));
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
    public Page<Conserto> listar(Pageable paginacao) {
        return repository.findAll(paginacao);
    }
    //http://localhost:8080/algunsDados
    @GetMapping("algunsDados")
    public Stream<DadosListagemConserto> listarAlgunsDados() {
        return repository.findAll().stream().map(DadosListagemConserto::new);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        Conserto conserto = repository.getReferenceById(id);
        conserto.excluir();
        return ResponseEntity.noContent().build();
    }
}
