package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Mantenedora;
import br.edu.unievangelica.ftt.entity.Pais;
import br.edu.unievangelica.ftt.service.MantenedoraService;
import br.edu.unievangelica.ftt.service.PaisService;
import java.util.List;
import javax.validation.ConstraintViolationException;
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
@RequestMapping("/mantenedora")
public class MantenedoraController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Mantenedora());
        mv.setViewName("/mantenedora/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Mantenedora mantenedora) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(mantenedora);
        mv.setViewName("/mantenedora/formulario");
        return mv;
    }

    @Autowired
    private MantenedoraService mantenedoraService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("mantenedoras", mantenedoraService.Listar());
        mv.setViewName("/mantenedora/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Mantenedora mantenedora, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/mantenedora/formulario";
        }

        mantenedoraService.salvar(mantenedora);
        attributes.addFlashAttribute("mensagem", "Mantenedora salva com sucesso!");
        return "redirect:/mantenedora";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {
        String resp = "";

        try {
            mantenedoraService.excluir(id);
            resp = "Mantenedora excluida com sucesso!";
        } catch (Exception e) {
            resp = "Mantenedora está vinculada a uma instituição.";
        }

        attributes.addFlashAttribute("mensagem", resp);
        return "redirect:/mantenedora";
    }

    @Autowired
    private PaisService paisService;

    @ModelAttribute("listarPais")
    public List<Pais> listapais() {
        return paisService.Listar();
    }
}
