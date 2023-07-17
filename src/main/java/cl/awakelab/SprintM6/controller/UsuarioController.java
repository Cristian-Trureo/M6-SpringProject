package cl.awakelab.SprintM6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {
    @GetMapping("/registro")
    public String registro(){ return "registro";}


}
