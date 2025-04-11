package br.ifpe.web3.categoria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
	
	
	private List<Categoria> lista = new ArrayList<Categoria>();
	
	@Autowired // Faz a injeção do objeto 
	private CategoriaDAO categoriaDAO;

	@ModelAttribute("categorias")
	public List<Categoria> getLista(){
		return this.categoriaDAO.findAll(Sort.by("nome"));
//		return this.lista;
	}
	
	@ModelAttribute("enum_situacao")
	public Situacao[] getEnumSituacao() {
		return Situacao.values();
	}
		
	
	@GetMapping("/listarCategorias")
	public String listaCat() {
		return "listar_categorias";
	}
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/categoria")
	public String exibirCategoria(Categoria categoria) {
		
		return "cadastrar_categoria";
	}
	
	@PostMapping("/salvarCategoria")
	public String cadastrarCategoria(Integer codigo, String nome) {
		System.out.println("Cod: " + codigo + ", nome: " + nome);
		return "index";
	}
	
	@PostMapping("/salvarCategoriaObj")
	public String cadastrarCategoriaObj(Categoria categoria) {
		this.lista.add(categoria);
		System.out.println(categoria);
		
		this.categoriaDAO.save(categoria);
		
		return "redirect:/listarCategorias";
	}

	@GetMapping("/exibirCategoria")
	public String exibirCategoria(Integer codigo, Model model) {
		Categoria cat = this.categoriaDAO.getOne(codigo);
		model.addAttribute("categoria", cat);
		return "cadastrar_categoria";
	}
	
	@GetMapping("/excluirCategoria")
	public String excluirCategoria(Integer codigo) {
		this.categoriaDAO.deleteById(codigo);
		return "redirect:/listarCategorias";
	}
}

