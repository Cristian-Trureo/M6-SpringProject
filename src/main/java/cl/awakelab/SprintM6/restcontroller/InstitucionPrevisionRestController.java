package cl.awakelab.SprintM6.restcontroller;

import cl.awakelab.SprintM6.entity.InstitucionPrevision;
import cl.awakelab.SprintM6.service.IInstitucionPrevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/institucionPrevision")
public class InstitucionPrevisionRestController {
    @Autowired
    IInstitucionPrevisionService objInstitucionPrevisionService;

    @PostMapping
    public InstitucionPrevision crearInstitucionPrevision(@RequestBody InstitucionPrevision institucionPrevision){
        return objInstitucionPrevisionService.crearInstitucionPrevision(institucionPrevision);
    }
    @GetMapping("/{idInstPrevision}")
    public InstitucionPrevision buscarInstitucionPrevisionPorId(@PathVariable int idInstPrevision){
        return objInstitucionPrevisionService.buscarInstitucionPrevisionPorId(idInstPrevision);
    }
    @GetMapping
    public List<InstitucionPrevision>listarInstitucionesPrevision(){
        List<InstitucionPrevision> institucionesPrevision = objInstitucionPrevisionService.listarInstitucionesPrevision();
        return institucionesPrevision;
    }
    @PutMapping("/{idInstPrevision}")
    public InstitucionPrevision actualizarInstitucionPrevision(@RequestBody InstitucionPrevision institucionPrevisionActualizar, @PathVariable int idInstPrevision){
        return objInstitucionPrevisionService.actualizarInstitucionPrevision(institucionPrevisionActualizar, idInstPrevision);
    }
}
