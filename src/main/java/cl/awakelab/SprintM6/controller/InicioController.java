package cl.awakelab.SprintM6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("/")
    public String mostrarHome(Model model) {
        model.addAttribute("paginaActual", "/");
        return "index";
    }
}