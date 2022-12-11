package ifrn.pi.controle.materiais.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MateriaisController {
	
	@RequestMapping("/materiais/form")
	public String form() {
		return "formMateriais";
	}
	@PostMapping("/materiais")
	public String adicionar() {
		return "material-adicionado";
	}
}
