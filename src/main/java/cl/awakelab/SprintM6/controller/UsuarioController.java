package cl.awakelab.SprintM6.controller;

import cl.awakelab.SprintM6.entity.Usuario;
import cl.awakelab.SprintM6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    IUsuarioService objUsuarioService;

    @GetMapping("/registrar")
    public String mostrarRegistro(Model model) {
        model.addAttribute("paginaActual", "registrar");
        return "registrar";
    }

    @GetMapping("/crearUsuario")
    public String mostrarFormUsuario(Model model) {
        model.addAttribute("paginaActual", "crearUsuario");
        return "crearUsuario";
    }
    @PostMapping("/crearUsuario")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        usuario.setFechaCreacion(LocalDateTime.now());
        objUsuarioService.crearUsuario(usuario);
        return "redirect:/usuario/usuarios";
    }

    @GetMapping("/usuarios")
    public String mostrarUsuarios(Model model) {
        List<Usuario> listaUsuarios = objUsuarioService.listarUsuarios();
        model.addAttribute("paginaActual", "usuarios");
        model.addAttribute("usuarios", listaUsuarios);
        return "listausuarios";
    }

    @GetMapping("/editar/{idUsuario}")
    public String mostrarFormularioEditarUsuario(@PathVariable int idUsuario, Model model){
        Usuario usuarioParaEditar = objUsuarioService.buscarUsuarioPorId(idUsuario);
        model.addAttribute("usuario", usuarioParaEditar);
        return "editarUsuario";
    }
    @PostMapping("/editar/{idUsuario}")
    public String actualizarUsuario(@PathVariable int idUsuario, @ModelAttribute Usuario usuario){
        objUsuarioService.actualizarUsuario(usuario, idUsuario);
        return "redirect:/usuario/usuarios";
    }

    @PostMapping("/eliminar/{idUsuario}")
    public String eliminarUsuario(@PathVariable int idUsuario){
        objUsuarioService.eliminarUsuario(idUsuario);
        return "redirect:/usuario/usuarios";
    }
}
