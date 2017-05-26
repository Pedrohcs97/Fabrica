package br.edu.unievangelica.ftt.controller;

import br.edu.unievangelica.ftt.entity.Instituicao;
import br.edu.unievangelica.ftt.entity.Pais;
import br.edu.unievangelica.ftt.entity.Unidade;
import br.edu.unievangelica.ftt.service.InstituicaoService;
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
@RequestMapping("/unidade")
public class UnidadeController {

    @RequestMapping("/novo")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject(new Unidade());
        mv.setViewName("/unidade/formulario");
        return mv;
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") Unidade unidade) {
        ModelAndView mv = new ModelAndView();
        mv.addObject(unidade);
        mv.setViewName("/unidade/formulario");
        return mv;
    }

    @Autowired
    private UnidadeService unidadeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Listar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("unidades", unidadeService.Listar());
        mv.setViewName("/unidade/listar");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(@Validated Unidade unidade, Errors errors, RedirectAttributes attributes) {

        if (errors.hasErrors()) {
            return "/unidade/formulario";
        }

        unidadeService.salvar(unidade);
        attributes.addFlashAttribute("mensagem", "Unidade salva com sucesso!");
        return "redirect:/unidade";
    }

    @RequestMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") long id, RedirectAttributes attributes) {

        try {
            unidadeService.excluir(id);
            attributes.addFlashAttribute("mensagem", "Unidade excluida com sucesso!");
        } catch (Exception ex) {
            attributes.addFlashAttribute("mensagem", "Erro ao excluir unidade!");
        }
        return "redirect:/unidade";
    }
    @Autowired
    private PaisService paisService;

    @ModelAttribute("listarPais")
    public List<Pais> listapais() {
        return paisService.Listar();
    }

    @Autowired
    private InstituicaoService instituicaoService;

    @ModelAttribute("listarInstituicao")
    public List<Instituicao> listaInstituicao() {
        return instituicaoService.Listar();
    }

}
