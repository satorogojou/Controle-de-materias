package ifrn.pi.controle.materiais.implementations;

import java.util.List;

import ifrn.pi.controle.materiais.dto.AccountDto;
import ifrn.pi.controle.materiais.entities.Account;

// Esta é a interface de serviços de Account, informando
// que métodos devem ser implementados para atender o sistema.
// Os serviços intermediam o acesso entre o controle e as entidades

public interface AccountService {
	
	void saveAccount(AccountDto accountDto);
	Account findUserByCpf(String cpf);
	List<AccountDto> findAllAccounts();
}
