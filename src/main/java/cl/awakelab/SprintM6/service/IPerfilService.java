package cl.awakelab.SprintM6.service;

import cl.awakelab.SprintM6.entity.Perfil;


import java.util.List;

public interface IPerfilService {
    List<Perfil> listarPerfil();
    Perfil crearPerfil (Perfil perfil);
    Perfil buscarPerfilPorId (int idPerfil);
    Perfil actualizarPerfil (Perfil perfil, int idPerfil);
    public void eliminarPerfil (int idPerfil);
}
