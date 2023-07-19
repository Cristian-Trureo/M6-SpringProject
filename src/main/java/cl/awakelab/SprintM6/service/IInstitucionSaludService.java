package cl.awakelab.SprintM6.service;

import cl.awakelab.SprintM6.entity.InstitucionSalud;

import java.util.List;

public interface IInstitucionSaludService {
    List<InstitucionSalud> listarInstitucionesSalud();
    InstitucionSalud crearInstitucionSalud (InstitucionSalud institucionSalud);
    InstitucionSalud buscarInstitucionSaludPorId (int idInstSalud);
    InstitucionSalud actualizarInstitucionSalud (InstitucionSalud institucionSalud, int idInstSalud);
    public void eliminarInstitucionSalud (int idInstSalud);
}
