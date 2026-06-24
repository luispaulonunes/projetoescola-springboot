package br.com.projetoescola.projetoescola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.projetoescola.projetoescola.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email); // método extra
}
