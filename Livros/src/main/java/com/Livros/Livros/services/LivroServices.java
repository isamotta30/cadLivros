package com.Livros.Livros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Livros.Livros.entities.Livro;
import com.Livros.Livros.repository.LivroRepository;

@Service
public class LivroServices {
	private final LivroRepository livroRepository;

	@Autowired
	public LivroServices(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public List<Livro> getAllLivro() {
		return livroRepository.findAll();
	}

	public Livro getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}

}
