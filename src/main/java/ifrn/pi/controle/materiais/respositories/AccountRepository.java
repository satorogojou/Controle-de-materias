package ifrn.pi.controle.materiais.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifrn.pi.controle.materiais.entities.Account;

public interface AccountRepository  extends JpaRepository<Account, Long> {
	Account findByCpf(String cpf);
}
