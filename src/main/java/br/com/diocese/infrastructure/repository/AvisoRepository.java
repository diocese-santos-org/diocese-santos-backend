package br.com.diocese.infrastructure.repository;

import br.com.diocese.domain.entity.Aviso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvisoRepository extends JpaRepository<Aviso, Long> {

    List<Aviso> findAllByOrderByIdDesc();
}
