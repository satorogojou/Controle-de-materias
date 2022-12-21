package ifrn.pi.controle.materiais.implementations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;

import ifrn.pi.controle.materiais.dto.AccountDto;
import ifrn.pi.controle.materiais.entities.Account;
import ifrn.pi.controle.materiais.entities.Role;
import ifrn.pi.controle.materiais.respositories.AccountRepository;
import ifrn.pi.controle.materiais.respositories.RoleRepository;

// Implementação dos serviços para Account

public class AccountServiceImplementation {
	
	private AccountRepository accountRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder encoder;

	public AccountServiceImplementation(AccountRepository accountRepository, RoleRepository roleRepository,
			PasswordEncoder encoder) {
		this.accountRepository = accountRepository;
		this.roleRepository = roleRepository;
		this.encoder = encoder;
	}

	// Recebe o DTO do controle e cria um novo usuário

	public void saveAccount(AccountDto accountDto) {
		Account account = new Account();
		account.setCpf(accountDto.getCpf());
		account.setName(accountDto.getName());
		account.setEmail(accountDto.getEmail());
		account.setPassword(this.encoder.encode(accountDto.getPassword()));

		// Por padrão, está criando todos os usuários com o papel de ADMIN
		// Para implementar o sistema na prática, com vários papéis, é preciso
		// capturar no AccountDto o papel e incluir no banco o registro de papel
		// correspondente.

		Role role = this.roleRepository.findByName("ROLE_ADMIN");
		if (role == null) {
			role = checkRoleExist();
		}

		account.setRoles(Arrays.asList(role));

		this.accountRepository.save(account);
	}

	public Account findUserByCpf(String cpf) {
		return this.accountRepository.findByCpf(cpf);
	}

	public List<AccountDto> findAllAccounts() {
		List<Account> accounts = this.accountRepository.findAll();
		return accounts.stream().map((account) -> mapToAccountDto(account)).collect(Collectors.toList());
	}

	// Este método faz a conversão de uma Account (entidade) para
	// AccountDto, Data Transfer Object

	private AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setCpf(account.getCpf());
		accountDto.setEmail(account.getEmail());
		accountDto.setName(account.getName());
		return accountDto;
	}

	// Checa se existe o papel do usuário a ser incluído no
	// banco de dados, caso não exista, cria o novo tipo de papel

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_ADMIN");
		return roleRepository.save(role);
	}

}
