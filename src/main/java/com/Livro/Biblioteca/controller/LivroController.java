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

    private List<Livro> livros = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio(){return "livros/inicio";}

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