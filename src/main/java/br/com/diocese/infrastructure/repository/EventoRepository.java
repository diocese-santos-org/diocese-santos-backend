package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findAllOrderByDataDesc();

}
