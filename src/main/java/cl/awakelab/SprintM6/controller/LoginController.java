package cl.awakelab.SprintM6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String iniciarsesion(){
        return "inicioSesion";
    }


    @GetMapping("/bienvenido")
    public String bienvenido(){
        return "bienvenido";
    }

}
