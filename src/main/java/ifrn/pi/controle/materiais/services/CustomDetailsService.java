package ifrn.pi.controle.materiais.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ifrn.pi.controle.materiais.models.Usuario;
import ifrn.pi.controle.materiais.respositories.UsuarioRepository;

public class CustomDetailsService implements UserDetailsService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(username);

		if (usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
		}
		return (UserDetails) usuario;
	}
}
