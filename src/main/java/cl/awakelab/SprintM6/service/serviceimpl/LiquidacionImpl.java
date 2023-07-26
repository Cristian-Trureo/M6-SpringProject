package cl.awakelab.SprintM6.service.serviceimpl;

import cl.awakelab.SprintM6.entity.Liquidacion;
import cl.awakelab.SprintM6.repository.ILiquidacionRepository;
import cl.awakelab.SprintM6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service("liquidacionImpl")
public class LiquidacionImpl implements ILiquidacionService {
    @Autowired
    ILiquidacionRepository objLiquidacionRepo;

    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion){
        return objLiquidacionRepo.save(liquidacion);
    }
    @Override
    public List<Liquidacion> listarLiquidaciones(){
        return objLiquidacionRepo.findAll();
    }
    @Override
    public Liquidacion buscarLiquidacionPorId(Long idLiquidacion){
        return objLiquidacionRepo.findById(idLiquidacion).orElseThrow(() -> new NoSuchElementException("Liquidacion no encontrada"));
    }
    @Override
    public Liquidacion actualizarLiquidacion(Liquidacion liquidacionActualizar, Long idLiquidacion){
        Liquidacion liquidacion = objLiquidacionRepo.findById(idLiquidacion).orElseThrow(()-> new NoSuchElementException("Liquidación no encontrada"));

        liquidacion.setIdTrabajador(liquidacionActualizar.getIdTrabajador());
        liquidacion.setPeriodo(liquidacionActualizar.getPeriodo());
        liquidacion.setSueldoImponible(liquidacionActualizar.getSueldoImponible());
        liquidacion.setSueldoLiquido(liquidacionActualizar.getSueldoLiquido());
        liquidacion.setIdInstSalud(liquidacionActualizar.getIdInstSalud());
        liquidacion.setMontoInstSalud(liquidacionActualizar.getMontoInstSalud());
        liquidacion.setInstitucionPrevision(liquidacionActualizar.getInstitucionPrevision());
        liquidacion.setMontoInstPrevisional(liquidacionActualizar.getMontoInstPrevisional());
        liquidacion.setTotalDescuento(liquidacionActualizar.getTotalDescuento());
        liquidacion.setTotalHaberes(liquidacionActualizar.getTotalHaberes());
        liquidacion.setAnticipo(liquidacionActualizar.getAnticipo());

        return objLiquidacionRepo.save(liquidacion);
    }

    @Override
    public void eliminarLiquidacion(Long idLiquidacion){
        objLiquidacionRepo.deleteById(idLiquidacion);
    }

}
