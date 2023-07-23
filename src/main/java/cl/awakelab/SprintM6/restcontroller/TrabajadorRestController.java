package cl.awakelab.SprintM6.restcontroller;

import cl.awakelab.SprintM6.entity.Trabajador;
import cl.awakelab.SprintM6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/trabajador")
public class TrabajadorRestController {

    @Autowired
    ITrabajadorService objTrabajadorService;
    @PostMapping
    public Trabajador crearTrabajador(@RequestBody Trabajador trabajador){
        return objTrabajadorService.crearTrabajador(trabajador);
    }

    @GetMapping("/{idTrabajador}")
    public Trabajador buscarTrabajadorPorId(@PathVariable int idTrabajador){
        return objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
    }
    @GetMapping
    public List<Trabajador>listarTrabajadores(){
        List<Trabajador> trabajadores = objTrabajadorService.listarTrabajadores();
        return trabajadores;
    }
    @PutMapping("/{idTrabajador}")
    public Trabajador actualizarTrabajador(@RequestBody Trabajador trabajadorActualizar, @PathVariable int idTrabajador){
        return objTrabajadorService.actualizarTrabajador(trabajadorActualizar,idTrabajador);
    }

    @DeleteMapping("/{idTrabajador}")
    public void eliminarTrabajador(@PathVariable int idTrabajador){
        objTrabajadorService.eliminarTrabajador(idTrabajador);
    }
}
