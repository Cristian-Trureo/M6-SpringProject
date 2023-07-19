package cl.awakelab.SprintM6.restcontroller;

import cl.awakelab.SprintM6.entity.Usuario;
import cl.awakelab.SprintM6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {

    @Autowired
    IUsuarioService objUsuarioservice;
    @PostMapping //tipo de request // enviar información
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return objUsuarioservice.crearUsuario(usuario);
    }
    @GetMapping("/{idUsuario}") //traer información
    public Usuario buscarUsuarioPorId(@PathVariable int idUsuario){
        return objUsuarioservice.buscarUsuarioPorId(idUsuario);
    }
    @GetMapping
    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = objUsuarioservice.listarUsuarios();
        usuarios.forEach(usuario -> usuario.setDescripcionPerfil(usuario.getDescripcionPerfil()));
        return usuarios;
    }
    @PutMapping("/{idUsuario}")
    public Usuario actualizarUsuario(@RequestBody Usuario usuarioActualizar, @PathVariable int idUsuario){
        return objUsuarioservice.actualizarUsuario(usuarioActualizar,idUsuario);
    }
    @DeleteMapping("/{idUsuario}")
    public void eliminarUsuario(@PathVariable int idUsuario){
        objUsuarioservice.eliminarUsuario(idUsuario);
    }
}
