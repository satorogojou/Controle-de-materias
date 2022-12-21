package ifrn.pi.controle.materiais.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.controle.materiais.models.Materiais;
import ifrn.pi.controle.materiais.respositories.MateriaisRespository;

@Controller
public class MateriaisController {
	
	@Autowired
	private MateriaisRespository mr;
	
	@RequestMapping("/materiais/form")
	public String form() {
		return "materiais/formMateriais";
	}
	@PostMapping("/materiais")
	public String adicionar(Materiais material) {
		
		System.out.println(material);
		mr.save(material);
		
		return "material-adicionado";
	}
}
