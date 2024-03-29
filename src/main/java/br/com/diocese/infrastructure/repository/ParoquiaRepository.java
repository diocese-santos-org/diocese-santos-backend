package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.entity.Paroquia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParoquiaRepository extends JpaRepository<Paroquia, Long> {
}
