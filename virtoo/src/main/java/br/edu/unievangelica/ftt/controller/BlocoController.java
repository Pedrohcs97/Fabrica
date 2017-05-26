package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Bloco;
import br.edu.unievangelica.ftt.entity.Unidade;
import br.edu.unievangelica.ftt.service.BlocoService;
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
@RequestMapping("/bloco")
public class BlocoController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Bloco());
        mv.setViewName("/bloco/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Bloco bloco) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(bloco);
        mv.setViewName("/bloco/formulario");
        return mv;
    }

    @Autowired
    private BlocoService blocoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("blocos", blocoService.Listar());
        mv.setViewName("/bloco/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Bloco bloco, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/bloco/formulario";
        }

        blocoService.salvar(bloco);
        attributes.addFlashAttribute("mensagem", "Bloco salvo com sucesso!");
        return "redirect:/bloco";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            blocoService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Bloco excluido com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir bloco!");
        }
        return "redirect:/bloco";
    }
    @Autowired
    private UnidadeService unidadeService;

    @ModelAttribute("listarUnidade")
    public List<Unidade> listaUnidade() {
        return unidadeService.Listar();
    }
}
