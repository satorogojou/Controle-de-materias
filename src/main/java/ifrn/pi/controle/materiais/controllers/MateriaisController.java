package ifrn.pi.controle.materiais.controllers;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ifrn.pi.controle.materiais.models.Materiais;
import ifrn.pi.controle.materiais.respositories.MateriaisRespository;

@Controller
public class MateriaisController {

	@Autowired
	private MateriaisRespository mr;

	@RequestMapping("/materiais/form")
	public String form(Materiais material) {
		return "materiais/formMateriais";
	}

	@PostMapping("/materiais")
	public String adicionar(Materiais material) {

		System.out.println(material);
		mr.save(material);

		return "material-adicionado";

	}

	@PostMapping
	public String Salvar( Materiais material, BindingResult resultado, RedirectAttributes attributes) {

		if (resultado.hasErrors()) {
			return form(material);
		}
		System.out.println(material);
		mr.save(material);
		attributes.addFlashAttribute("mensagem", "Seu material foi emprestado com sucesso!");
		
		return ("redirect:/materiais");
	}
	
	public ModelAndView listar() {
		List<Materiais> material = mr.findAll();
		ModelAndView mv = new ModelAndView("materiais/lista");
		mv.addObject("materiais", material);
		return mv;
	}
	
	@GetMapping("{id}/remover")
	public String apagar(@PathVariable Long id, RedirectAttributes attributes) {
		
		Optional<Materiais> opt = mr.findById(id);
		
		if(opt.isEmpty()) {
			
			Materiais material = opt.get();
			
			mr.delete(material);
			
			attributes.addFlashAttribute("mensagem", "Seu material de empréstimo foi removido com sucesso!");
		}
		
		return "redirect:/materiais";
	}
}
