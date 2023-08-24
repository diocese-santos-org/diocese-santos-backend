package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.model.Paroquia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParoquiaRepository extends JpaRepository<Paroquia, Long> {
}
