package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.entity.Comunicado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunicadoRepository extends JpaRepository<Comunicado, Long> {
}
