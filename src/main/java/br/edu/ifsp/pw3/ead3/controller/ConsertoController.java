package br.edu.ifsp.pw3.ead3.controller;

import br.edu.ifsp.pw3.ead3.conserto.Conserto;
import br.edu.ifsp.pw3.ead3.conserto.DadosConserto;
import br.edu.ifsp.pw3.ead3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consertos")
public class ConsertoController {
    @Autowired private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosConserto dados){
        repository.save(new Conserto(dados));

    }
}
