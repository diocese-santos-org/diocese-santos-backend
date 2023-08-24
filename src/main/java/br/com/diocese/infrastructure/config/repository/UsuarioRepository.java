package br.com.diocese.infrastructure.config.repository;


import br.com.diocese.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByConcessionaria_Cnpj(String cnpj);



}
