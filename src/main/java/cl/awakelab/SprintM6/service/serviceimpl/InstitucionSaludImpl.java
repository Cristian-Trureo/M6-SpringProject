package cl.awakelab.SprintM6.service.serviceimpl;


import cl.awakelab.SprintM6.entity.InstitucionSalud;
import cl.awakelab.SprintM6.repository.IInstitucionSaludRepository;
import cl.awakelab.SprintM6.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("institucionSaludImpl")
public class InstitucionSaludImpl implements IInstitucionSaludService {
    @Autowired
    IInstitucionSaludRepository objInstitucionSaludRepo;

    @Override
    public InstitucionSalud crearInstitucionSalud(InstitucionSalud institucionSalud){
        return objInstitucionSaludRepo.save(institucionSalud);
    }

    @Override
    public List<InstitucionSalud> listarInstitucionesSalud(){
        return objInstitucionSaludRepo.findAll();
    }

    @Override
    public InstitucionSalud buscarInstitucionSaludPorId(int idInstSalud){
        return objInstitucionSaludRepo.findById(idInstSalud).orElseThrow(() -> new NoSuchElementException("Institucion no encontrada"));
    }

    @Override
    public InstitucionSalud actualizarInstitucionSalud(InstitucionSalud institucionSaludActualizar, int idInstSalud){
        InstitucionSalud institucionSalud = objInstitucionSaludRepo.findById(idInstSalud).orElseThrow(()->new NoSuchElementException("Institución no encontrada"));
        institucionSalud.setIdInstSalud(institucionSaludActualizar.getIdInstSalud());
        institucionSalud.setDescripcion(institucionSaludActualizar.getDescripcion());
        institucionSalud.setPorcDcto(institucionSaludActualizar.getPorcDcto());
        return objInstitucionSaludRepo.save(institucionSalud);
    }
    @Override
    public void eliminarInstitucionSalud(int idInstSalud){
        objInstitucionSaludRepo.deleteById(idInstSalud);
    }

}
