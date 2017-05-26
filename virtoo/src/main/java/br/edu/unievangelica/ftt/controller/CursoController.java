package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Curso;
import br.edu.unievangelica.ftt.entity.Unidade;
import br.edu.unievangelica.ftt.service.CursoService;
import br.edu.unievangelica.ftt.service.UnidadeService;
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
@RequestMapping("/curso")
public class CursoController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Curso());
        mv.setViewName("/curso/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Curso curso) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(curso);
        mv.setViewName("/curso/formulario");
        return mv;
    }

    @Autowired
    private CursoService cursoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("cursos", cursoService.Listar());
        mv.setViewName("/curso/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Curso curso, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/curso/formulario";
        }

        cursoService.salvar(curso);
        attributes.addFlashAttribute("mensagem", "Curso salvo com sucesso!");
        return "redirect:/curso";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {

        try {
            cursoService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Curso excluido com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir curso!");
        }
        return "redirect:/curso";
    }

    @Autowired
    private UnidadeService unidadeService;

    @ModelAttribute("listarUnidade")
    public List<Unidade> listaUnidade() {
        return unidadeService.Listar();
    }
}
