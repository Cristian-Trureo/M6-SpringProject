package cl.awakelab.SprintM6.service;

import cl.awakelab.SprintM6.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {

    List<Empleador> listarEmpleadores();
    Empleador crearEmpleador (Empleador empleador);
    Empleador buscarEmpleadorPorId (int idEmpleador);
    Empleador actualizarEmpleador (Empleador empleador, int idEmpleador);
    public void eliminarEmpleador (int idEmpleador);
}
