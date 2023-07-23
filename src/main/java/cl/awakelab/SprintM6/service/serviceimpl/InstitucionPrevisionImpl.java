package cl.awakelab.SprintM6.service.serviceimpl;

import cl.awakelab.SprintM6.entity.InstitucionPrevision;
import cl.awakelab.SprintM6.repository.IInstitucionPrevisionRepository;
import cl.awakelab.SprintM6.service.IInstitucionPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("institucionPrevisionImpl")
public class InstitucionPrevisionImpl implements IInstitucionPrevisionService{
    @Autowired
    IInstitucionPrevisionRepository objInstitucionPrevisionRepo;
    @Override
    public InstitucionPrevision crearInstitucionPrevision(InstitucionPrevision institucionPrevision){
        return objInstitucionPrevisionRepo.save(institucionPrevision);
    }
    @Override
    public List<InstitucionPrevision> listarInstitucionesPrevision(){
        return objInstitucionPrevisionRepo.findAll();
    }
    @Override
    public InstitucionPrevision buscarInstitucionPrevisionPorId(int idInstPrevision){
        return objInstitucionPrevisionRepo.findById(idInstPrevision).orElseThrow(() -> new NoSuchElementException("Institucion no encontrada"));
    }
    @Override
    public InstitucionPrevision actualizarInstitucionPrevision(InstitucionPrevision institucionPrevisionActualizar, int idInstPrevision){
        InstitucionPrevision institucionPrevision = objInstitucionPrevisionRepo.findById(idInstPrevision).orElseThrow(()->new NoSuchElementException("Institución no encontrada"));
        institucionPrevision.setIdInstPrevision(institucionPrevisionActualizar.getIdInstPrevision());
        institucionPrevision.setDescripcion(institucionPrevisionActualizar.getDescripcion());
        institucionPrevision.setPorcDcto(institucionPrevisionActualizar.getPorcDcto());
        return objInstitucionPrevisionRepo.save(institucionPrevision);
    }
    @Override
    public void eliminarInstitucionPrevision(int idInstPrevision){
        objInstitucionPrevisionRepo.deleteById(idInstPrevision);
    }
}
