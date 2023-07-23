package cl.awakelab.SprintM6.controller;

import cl.awakelab.SprintM6.entity.Empleador;
import cl.awakelab.SprintM6.entity.InstitucionPrevision;
import cl.awakelab.SprintM6.entity.InstitucionSalud;
import cl.awakelab.SprintM6.entity.Trabajador;
import cl.awakelab.SprintM6.service.IEmpleadorService;
import cl.awakelab.SprintM6.service.IInstitucionPrevisionService;
import cl.awakelab.SprintM6.service.IInstitucionSaludService;
import cl.awakelab.SprintM6.service.ITrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
    @Autowired
    ITrabajadorService objTrabajadorService;
    @Autowired
    private IInstitucionSaludService objInstitucionSaludService;
    @Autowired
    private IInstitucionPrevisionService objInstitucionPrevisionService;
    @Autowired
    private IEmpleadorService objEmpleadorService;

    @GetMapping("/crearTrabajador")
    public String mostrarFormTrabajador(Model model){
        List<InstitucionPrevision> listaInstitucionPrevision = objInstitucionPrevisionService.listarInstitucionesPrevision();
        List<InstitucionSalud> listaInstitucionSalud = objInstitucionSaludService.listarInstitucionesSalud();
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        model.addAttribute("listaInstitucionSalud", listaInstitucionSalud);
        model.addAttribute("listaInstitucionesPrevision", listaInstitucionPrevision);
        model.addAttribute("listaEmpleadores", listaEmpleadores);
        model.addAttribute("paginaActual", "crearTrabajador");
        return "crearTrabajador";
    }
    @PostMapping("/crearTrabajador")
    public String crearTrabajador(@ModelAttribute Trabajador trabajador){
        objTrabajadorService.crearTrabajador(trabajador);
        return "redirect:/trabajador/trabajadores";
    }
    @GetMapping("/trabajadores")
    public String mostrarTrabajadores(Model model){
        List<Trabajador> listaTrabajadores = objTrabajadorService.listarTrabajadores();
        model.addAttribute("paginaActual","trabajadores");
        model.addAttribute("trabajadores", listaTrabajadores);
        return "listatrabajadores";
    }


    @PostMapping("/eliminar/{idtrabajador}")
    public String eliminarTrabajador(@PathVariable int idtrabajador){
        objTrabajadorService.eliminarTrabajador(idtrabajador);
        return "redirect:/trabajador/trabajadores";
    }
}
