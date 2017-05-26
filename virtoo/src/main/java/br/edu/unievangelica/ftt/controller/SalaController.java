package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Piso;
import br.edu.unievangelica.ftt.entity.Sala;
import br.edu.unievangelica.ftt.service.PisoService;
import br.edu.unievangelica.ftt.service.SalaService;
import ch.qos.logback.core.CoreConstants;
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
@RequestMapping("/sala")
public class SalaController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Sala());
        mv.setViewName("/sala/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Sala sala) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(sala);
        mv.setViewName("/sala/formulario");
        return mv;
    }

    @Autowired
    private SalaService salaService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("salas", salaService.Listar());
        mv.setViewName("/sala/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Sala sala, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/sala/formulario";
        }

        salaService.salvar(sala);
        attributes.addFlashAttribute("mensagem", "Sala salva com sucesso!");
        return "redirect:/sala";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            salaService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Sala excluida com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir sala");
        }
        return "redirect:/sala";
    }

    @Autowired
    private PisoService pisoService;

    @ModelAttribute("listarPiso")
    public List<Piso> listaBloco() {
        return pisoService.Listar();
    }
}
