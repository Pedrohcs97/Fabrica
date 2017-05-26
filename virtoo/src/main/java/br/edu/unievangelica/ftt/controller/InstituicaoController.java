package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Instituicao;
import br.edu.unievangelica.ftt.entity.Mantenedora;
import br.edu.unievangelica.ftt.entity.Pais;
import br.edu.unievangelica.ftt.service.InstituicaoService;
import br.edu.unievangelica.ftt.service.MantenedoraService;
import br.edu.unievangelica.ftt.service.PaisService;
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
@RequestMapping("/instituicao")
public class InstituicaoController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Instituicao());
        mv.setViewName("/instituicao/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Instituicao instituicao) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(instituicao);
        mv.setViewName("/instituicao/formulario");
        return mv;
    }

    @Autowired
    private InstituicaoService instituicaoService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("instituicoes", instituicaoService.Listar());
        mv.setViewName("/instituicao/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Instituicao instituicao, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/instituicao/formulario";
        }

        instituicaoService.salvar(instituicao);
        attributes.addFlashAttribute("mensagem", "Instituação salva com sucesso!");
        return "redirect:/instituicao";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {

        try {
            instituicaoService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Instituição excluida com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir!");
        }
        return "redirect:/instituicao";
    }
    @Autowired
    private PaisService paisService;

    @ModelAttribute("listarPais")
    public List<Pais> listapais() {
        return paisService.Listar();
    }

    @Autowired
    private MantenedoraService mantenedoraService;

    @ModelAttribute("listarMantenedora")
    public List<Mantenedora> listaMantenedora() {
        return mantenedoraService.Listar();
    }

}
