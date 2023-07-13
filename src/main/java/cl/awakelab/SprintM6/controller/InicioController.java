package cl.awakelab.SprintM6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/registro")
    public String registro(){ return "registro";}

    @GetMapping("/iniciosesion")
    public String iniciarsesion(){ return "inicioSesion";}

    @GetMapping("/bienvenido")
    public String bienvenido(){ return "bienvenido";}
}