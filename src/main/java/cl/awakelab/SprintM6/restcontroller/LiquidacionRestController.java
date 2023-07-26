package cl.awakelab.SprintM6.restcontroller;

import cl.awakelab.SprintM6.entity.Liquidacion;
import cl.awakelab.SprintM6.service.ILiquidacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/liquidacion")
public class LiquidacionRestController {

    @Autowired
    ILiquidacionService objLiquidacionService;

    @PostMapping
    public Liquidacion crearLiquidacion(@RequestBody Liquidacion liquidacion){
        return objLiquidacionService.crearLiquidacion(liquidacion);
    }
    @GetMapping("/{idLiquidacion}")
    public Liquidacion buscarLiquidacionPorId(@PathVariable Long idLiquidacion){
        return objLiquidacionService.buscarLiquidacionPorId(idLiquidacion);
    }
    @PutMapping("/{idLiquidacion}")
    public Liquidacion actualizarLiquidacion(@RequestBody Liquidacion liquidacionActualizar, @PathVariable Long idLiquidacion){
        return objLiquidacionService.actualizarLiquidacion(liquidacionActualizar, idLiquidacion);
    }
    @DeleteMapping("/{idLiquidacion}")
    public void eliminarLiquidacion(@PathVariable Long idLiquidacion){
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
    }
}
