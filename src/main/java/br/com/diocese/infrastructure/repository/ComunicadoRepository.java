package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.entity.Comunicado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComunicadoRepository extends JpaRepository<Comunicado, Long> {
}
