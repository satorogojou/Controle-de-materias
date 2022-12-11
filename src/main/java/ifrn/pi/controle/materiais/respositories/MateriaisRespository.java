package ifrn.pi.controle.materiais.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.pi.controle.materiais.models.Materiais;

public interface MateriaisRespository extends JpaRepository<Materiais, Long>{
	
}
