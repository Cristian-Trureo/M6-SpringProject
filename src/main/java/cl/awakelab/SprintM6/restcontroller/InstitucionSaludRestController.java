package cl.awakelab.SprintM6.restcontroller;

import cl.awakelab.SprintM6.entity.InstitucionSalud;
import cl.awakelab.SprintM6.service.IInstitucionSaludService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/institucionSalud")
public class InstitucionSaludRestController {
        @Autowired
        IInstitucionSaludService objInstitucionSaludService;

        @PostMapping
        public InstitucionSalud crearInstitucionSalud(@RequestBody InstitucionSalud institucionSalud){
            return objInstitucionSaludService.crearInstitucionSalud(institucionSalud);
        }
        @GetMapping("/{idInstSalud}")
        public InstitucionSalud buscarInstitucionSaludPorId(@PathVariable int idInstSalud){
            return objInstitucionSaludService.buscarInstitucionSaludPorId(idInstSalud);
        }

        @GetMapping
        public List<InstitucionSalud> listarInstitucionesSalud(){
            List<InstitucionSalud> institucionesSalud = objInstitucionSaludService.listarInstitucionesSalud();
            return institucionesSalud;
        }
        @PutMapping("/{idInstSalud}")
        public InstitucionSalud actualizarInstitucionSalud(@RequestBody InstitucionSalud institucionSaludActualizar, @PathVariable int idInstSalud){
            return objInstitucionSaludService.actualizarInstitucionSalud(institucionSaludActualizar, idInstSalud);
        }
    }

