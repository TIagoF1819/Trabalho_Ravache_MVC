package com.Livro.Biblioteca.controller;

import com.Livro.Biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/livros")
public class LivroController {

    @GetMapping
    public String exibirLivro(Model model) {
        Livro livro = new Livro();

        livro.setTitulo("Livro 1");
        livro.setAutor("Autor");
        livro.setIsbn("ISBN");

        model.addAttribute("livro", livro);

        return "livros/inicio";
    }
}