package cl.awakelab.SprintM6.service.serviceimpl;

import cl.awakelab.SprintM6.entity.Trabajador;
import cl.awakelab.SprintM6.repository.ITrabajadorRepository;
import cl.awakelab.SprintM6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("trabajadorImpl")
public class TrabajadorImpl implements ITrabajadorService {
    @Autowired
    ITrabajadorRepository objTrabajadorRepo;

    @Override
    public Trabajador crearTrabajador(Trabajador trabajador){
        return objTrabajadorRepo.save(trabajador);
    }
    @Override
    public List<Trabajador> listarTrabajadores(){
        return objTrabajadorRepo.findAll();
    }
    @Override
    public Trabajador buscarTrabajadorPorId(int idTrabajador){
        return objTrabajadorRepo.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
    }

    @Override
    public Trabajador actualizarTrabajador(Trabajador trabajadorActualizar, int idTrabajador) {
        Trabajador trabajador = objTrabajadorRepo.findById(idTrabajador).orElseThrow(() -> new NoSuchElementException("Trabajador no encontrado"));
        trabajador.setRun(trabajadorActualizar.getRun());
        trabajador.setNombre(trabajadorActualizar.getNombre());
        trabajador.setApellido1(trabajadorActualizar.getApellido1());
        trabajador.setApellido2(trabajadorActualizar.getApellido2());
//        trabajador.setDireccion(trabajadorActualizar.getDireccion());
        trabajador.setEmail(trabajadorActualizar.getEmail());
        trabajador.setTelefono(trabajadorActualizar.getTelefono());
        trabajador.setIdInstSalud(trabajadorActualizar.getIdInstSalud());
        trabajador.setIdInstPrevision(trabajadorActualizar.getIdInstPrevision());

        return objTrabajadorRepo.save(trabajador);
    }
    @Override
    public void eliminarTrabajador(int idTrabajador){
        objTrabajadorRepo.deleteById(idTrabajador);
    }
}
