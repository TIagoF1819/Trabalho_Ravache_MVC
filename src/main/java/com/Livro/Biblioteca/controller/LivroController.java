package com.Livro.Biblioteca.controller;

import com.Livro.Biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final List<Livro> livros = new ArrayList<>();

    // Dados de teste: carregados uma vez, quando a aplicação sobe
    public LivroController() {
        livros.add(new Livro("Dom Casmurro", "Machado de Assis", "978-85-359-0277-5"));
        livros.add(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "978-85-359-0279-9"));
        livros.add(new Livro("O Cortiço", "Aluísio Azevedo", "978-85-359-0278-2"));
    }

    @GetMapping
    public String exibirLivros(Model model) {
        model.addAttribute("livros", livros);
        return "livros/inicio";
    }

    @GetMapping("/novo")
    public String exibirFormulario(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/salvar")
    public String salvarLivro(@ModelAttribute Livro livro) {
        livros.add(livro);
        return "redirect:/livros";
    }
}