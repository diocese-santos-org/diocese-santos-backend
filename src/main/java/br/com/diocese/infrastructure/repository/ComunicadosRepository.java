package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.entity.Comunicados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunicadosRepository extends JpaRepository<Comunicados, Long> {
}
