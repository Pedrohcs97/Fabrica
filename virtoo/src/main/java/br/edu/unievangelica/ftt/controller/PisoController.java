package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Bloco;
import br.edu.unievangelica.ftt.entity.Piso;
import br.edu.unievangelica.ftt.service.BlocoService;
import br.edu.unievangelica.ftt.service.PisoService;
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
@RequestMapping("/piso")
public class PisoController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Piso());
        mv.setViewName("/piso/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Piso piso) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(piso);
        mv.setViewName("/piso/formulario");
        return mv;
    }

    @Autowired
    private PisoService pisoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("pisos", pisoService.Listar());
        mv.setViewName("/piso/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Piso piso, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/piso/formulario";
        }

        pisoService.salvar(piso);
        attributes.addFlashAttribute("mensagem", "Piso salvo com sucesso!");
        return "redirect:/piso";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {
        try {
            pisoService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Piso excluido com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir piso!");
        }
        return "redirect:/piso";
    }
    @Autowired
    private BlocoService blocoService;

    @ModelAttribute("listarBloco")
    public List<Bloco> listaBloco() {
        return blocoService.Listar();
    }
}
