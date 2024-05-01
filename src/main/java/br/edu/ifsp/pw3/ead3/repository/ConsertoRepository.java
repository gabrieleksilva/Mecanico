package br.edu.ifsp.pw3.ead3.repository;

import br.edu.ifsp.pw3.ead3.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {

    List<Conserto> findAllByAtivoTrue();
}
