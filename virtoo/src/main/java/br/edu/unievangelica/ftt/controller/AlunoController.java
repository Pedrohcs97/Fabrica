package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Aluno;
import br.edu.unievangelica.ftt.entity.Curso;
import br.edu.unievangelica.ftt.entity.Pais;
import br.edu.unievangelica.ftt.entity.Unidade;
import br.edu.unievangelica.ftt.service.AlunoService;
import br.edu.unievangelica.ftt.service.CursoService;
import br.edu.unievangelica.ftt.service.PaisService;
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
@RequestMapping("/aluno")
public class AlunoController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Aluno());
        mv.setViewName("/aluno/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Aluno aluno) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(aluno);
        mv.setViewName("/aluno/formulario");
        return mv;
    }

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("alunos", alunoService.Listar());
        mv.setViewName("/aluno/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Aluno aluno, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            System.out.println("=======================================");
            System.out.println(errors.hasErrors());
            System.out.println("=======================================");
            return "/aluno/formulario";
        }

        alunoService.salvar(aluno);
        attributes.addFlashAttribute("mensagem", "Aluno salvo com sucesso!");
        return "redirect:/aluno";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            alunoService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Aluno excluido com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir aluno!");
        }
        return "redirect:/aluno";
    }

    @Autowired
    private PaisService paisService;

    @ModelAttribute("listarPais")
    public List<Pais> listapais() {
        return paisService.Listar();
    }

    @Autowired
    private UnidadeService unidadeService;

    @ModelAttribute("listarUnidade")
    public List<Unidade> listaUnidade() {
        return unidadeService.Listar();
    }

    @Autowired
    private CursoService cursoService;

    @ModelAttribute("listarCurso")
    public List<Curso> listaCurso() {
        return cursoService.Listar();
    }
}
