package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Pais;
import br.edu.unievangelica.ftt.service.PaisService;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pais")
public class PaisController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Pais());
        mv.setViewName("/pais/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Pais pais) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(pais);
        mv.setViewName("/pais/formulario");
        return mv;
    }

    @Autowired
    private PaisService paisService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("paises", paisService.Listar());
        mv.setViewName("/pais/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Pais pais, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/pais/formulario";
        }
        paisService.salvar(pais);
        attributes.addFlashAttribute("mensagem", "País salvo com sucesso!");
        return "redirect:/pais";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            paisService.excluir(id);
            attributes.addFlashAttribute("mensagem", "País excluido com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir!");
        }
        return "redirect:/pais";
    }
}
