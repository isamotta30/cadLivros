package com.Livros.Livros.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Livros.Livros.entities.Livro;
import com.Livros.Livros.services.LivroServices;

@RestController
@RequestMapping("/livro")
public class LivroController {

	private final LivroServices livroServices;

	@Autowired
	public LivroController(LivroServices livroServices) {
		this.livroServices = livroServices;
	}

	@PostMapping
	public Livro createLivro(@RequestBody Livro livro) {
		return livroServices.saveLivro(livro);
	}

	@GetMapping("/{id}")
	public Livro getLivro(@PathVariable Long id) {
		return livroServices.getLivroById(id);
	}

	@GetMapping
	public List<Livro> getAllLivro() {
		return livroServices.getAllLivro();
	}

	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable Long id) {
		livroServices.deleteLivro(id);
	}
}
