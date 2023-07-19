package cl.awakelab.SprintM6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String iniciarsesion(Model model){
        model.addAttribute("paginaActual","login");
        return "inicioSesion";
    }


    @GetMapping("/bienvenido")
    public String bienvenido(Model model){
        model.addAttribute("paginaActual","bienvenido");
        return "bienvenido";
    }
}
