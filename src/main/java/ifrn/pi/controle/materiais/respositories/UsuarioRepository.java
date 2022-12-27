package ifrn.pi.controle.materiais.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.controle.materiais.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmail(String email);

}
