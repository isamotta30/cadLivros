package com.Livros.Livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Livros.Livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro,Long> {

}
