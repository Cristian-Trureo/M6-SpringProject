package cl.awakelab.SprintM6.service;

import cl.awakelab.SprintM6.entity.Usuario;

import java.util.List;


public interface IUsuarioService {

    List<Usuario> listarUsuarios();
    Usuario crearUsuario (Usuario usuario);
    Usuario buscarUsuarioPorId (int idUsuario);
    Usuario actualizarUsuario (Usuario usuario, int idUsuario);
    public void eliminarUsuario (int idUsuario);
}
