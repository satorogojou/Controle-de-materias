package ifrn.pi.controle.materiais.respositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifrn.pi.controle.materiais.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, UUID> {
	

	Optional<UserModel> findByUsername(String username);
	
}
