package cl.awakelab.SprintM6.service;

import cl.awakelab.SprintM6.entity.InstitucionPrevision;


import java.util.List;

public interface IInstitucionPrevisionService {
    List<InstitucionPrevision> listarInstitucionesPrevision();
    InstitucionPrevision crearInstitucionPrevision (InstitucionPrevision institucionPrevision);
    InstitucionPrevision buscarInstitucionPrevisionPorId (int idInstPrevision);
    InstitucionPrevision actualizarInstitucionPrevision (InstitucionPrevision institucionPrevision, int idInstPrevision);
    public void eliminarInstitucionPrevision (int idInstPrevision);
}
