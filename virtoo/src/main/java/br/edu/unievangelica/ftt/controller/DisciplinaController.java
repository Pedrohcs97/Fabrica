package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Curso;
import br.edu.unievangelica.ftt.entity.Disciplina;
import br.edu.unievangelica.ftt.service.DisciplinaService;
import br.edu.unievangelica.ftt.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Disciplina());
        mv.setViewName("/disciplina/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Disciplina disciplina) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(disciplina);
        mv.setViewName("/disciplina/formulario");
        return mv;
    }

    @Autowired
    private DisciplinaService disciplinaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("disciplinas", disciplinaService.Listar());
        mv.setViewName("/disciplina/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Disciplina disciplina, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/disciplina/formulario";
        }

        disciplinaService.salvar(disciplina);
        attributes.addFlashAttribute("mensagem", "Disciplina salva com sucesso!");
        return "redirect:/disciplina";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            disciplinaService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Disciplina excluida com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir disciplina!");
        }
        return "redirect:/disciplina";
    }

    @Autowired
    private CursoService cursoService;

    @ModelAttribute("listarCurso")
    public List<Curso> listaCurso() {
        return cursoService.Listar();
    }
}
