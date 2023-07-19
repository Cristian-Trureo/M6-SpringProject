package cl.awakelab.SprintM6.service;

import cl.awakelab.SprintM6.entity.Trabajador;

import java.util.List;

public interface ITrabajadorService {
    List<Trabajador> listarTrabajadores();
    Trabajador crearTrabajador (Trabajador trabajador);
    Trabajador buscarTrabajadorPorId (int idtrabajador);
    Trabajador actualizarTrabajador (Trabajador trabajador, int idTrabajador);
    public void eliminarTrabajador (int idTrabajador);
}
