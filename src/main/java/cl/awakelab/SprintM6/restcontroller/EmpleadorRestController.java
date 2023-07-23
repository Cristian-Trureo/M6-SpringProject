package cl.awakelab.SprintM6.restcontroller;

import cl.awakelab.SprintM6.entity.Empleador;
import cl.awakelab.SprintM6.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/empleador")
public class EmpleadorRestController {

    @Autowired
    IEmpleadorService objEmpleadorservice;
    @PostMapping
    public Empleador crearEmpleador(@RequestBody Empleador empleador){
        return objEmpleadorservice.crearEmpleador(empleador);
    }
    @GetMapping("/{idEmpleador}")
    public Empleador buscarEmpleadorPorId(@PathVariable int idEmpleador){
        return objEmpleadorservice.buscarEmpleadorPorId(idEmpleador);
    }
    @GetMapping
    public List<Empleador>listarEmpleadores(){
        List<Empleador> empleadores = objEmpleadorservice.listarEmpleadores();
        return empleadores;
    }
    @PutMapping("/{idEmpleador}")
    public Empleador actualizarEmpleador(@RequestBody Empleador empleadorActualizar, @PathVariable int idEmpleador){
        return objEmpleadorservice.actualizarEmpleador(empleadorActualizar,idEmpleador);
    }
    @DeleteMapping("/{idEmpleador}")
    public void eliminarEmpleador(@PathVariable int idEmpleador){
        objEmpleadorservice.eliminarEmpleador(idEmpleador);
    }

}
