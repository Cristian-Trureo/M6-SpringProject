package cl.awakelab.SprintM6.service;

import cl.awakelab.SprintM6.entity.Liquidacion;

import java.util.List;

public interface ILiquidacionService {
    List<Liquidacion> listarLiquidaciones();
    Liquidacion crearLiquidacion (Liquidacion liquidacion);
    Liquidacion buscarLiquidacionPorId (Long idLiquidacion);
    Liquidacion actualizarLiquidacion (Liquidacion liquidacion, Long idLiquidacion);
    public void eliminarLiquidacion (Long idLiquidacion);
}
