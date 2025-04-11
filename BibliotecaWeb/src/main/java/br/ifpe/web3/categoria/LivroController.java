package br.ifpe.web3.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivroController {
	
	@Autowired
	private LivroDAO livroDAO;
	
	@Autowired
	private CategoriaDAO categoriaDAO;

	@GetMapping("/cadLivros")
	public String exibirCadastroLivros(Model model) {
		
		model.addAttribute("lista_categ", 
			this.categoriaDAO.findAll(Sort.by("nome")));
		
		model.addAttribute("lista_livros", this.livroDAO.findAll());
		
		return "cadastrar_livro";
	}
	
	@PostMapping("/salvarLivro")
	public String salvarLivro(Livro livro) {
		this.livroDAO.save(livro);
		return "redirect:/cadLivros";
	}

	
}
