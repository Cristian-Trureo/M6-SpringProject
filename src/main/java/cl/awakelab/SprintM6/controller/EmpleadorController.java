package cl.awakelab.SprintM6.controller;

import cl.awakelab.SprintM6.entity.Empleador;
import cl.awakelab.SprintM6.entity.Usuario;
import cl.awakelab.SprintM6.service.IEmpleadorService;
import cl.awakelab.SprintM6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
@RequestMapping("/empleador")
public class EmpleadorController {
    @Autowired
    IEmpleadorService objEmpleadorService;
    @Autowired
    private IUsuarioService objUsuarioService;

    @GetMapping("/crearEmpleador")
    public String mostrarFormUsuario(Model model) {
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("paginaActual", "crearEmpleador");
        model.addAttribute("listaUsuarios", listaUsuarios);
        return "crearEmpleador";
    }
    @PostMapping("/crearEmpleador")
    public String crearEmpleador(@ModelAttribute Empleador empleador){
        objEmpleadorService.crearEmpleador(empleador);
        return "redirect:/empleador/empleadores";
    }

    @GetMapping("/empleadores")
    public String mostrarEmpleadores(Model model){
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("paginaActual","empleadores");
        model.addAttribute("empleadores", listaEmpleadores);
        return "listaempleadores";
    }

    @GetMapping("/editar/{idEmpleador}")
    public String mostrarFormularioEditarEmpleador(@PathVariable int idEmpleador, Model model){
        Empleador empleadorParaEditar = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
        model.addAttribute("empleador",empleadorParaEditar);
        return "editarEmpleador";
    }

    @PostMapping("/editar/{idEmpleador}")
    public String actualizarEmpleador(@PathVariable int idEmpleador, @ModelAttribute Empleador empleador){
        objEmpleadorService.actualizarEmpleador(empleador, idEmpleador);
        return "redirect:/empleador/empleadores";

    }

    @PostMapping("/eliminar/{idEmpleador}")
    public String eliminarEmpleador(@PathVariable int idEmpleador){
        objEmpleadorService.eliminarEmpleador(idEmpleador);
        return "redirect:/empleador/empleadores";
    }
}
