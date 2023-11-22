package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findAllByOrderByDataDesc();

}
