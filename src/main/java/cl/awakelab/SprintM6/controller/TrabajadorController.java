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

import java.util.ArrayList;
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
    public String crearTrabajador(@ModelAttribute Trabajador trabajador, @RequestParam("empleadores") List<Integer> idsEmpleadores){
        List<Empleador>empleadores= new ArrayList<>();
        for(Integer idEmpleador : idsEmpleadores){
            Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
            empleadores.add(empleador);
        }
        trabajador.setListaEmpleadores(empleadores);
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
    @GetMapping("/editar/{idTrabajador}")
    public String mostrarFormularioEditarTrabajador(@PathVariable int idTrabajador, Model model){
        Trabajador trabajadorParaEditar = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        model.addAttribute("trabajador",trabajadorParaEditar);
        List<Empleador> listaEmpleadores = objEmpleadorService.listarEmpleadores();
        List<Integer> idsEmpleadoresDesignados = new ArrayList<>();
        for(Empleador empleador : trabajadorParaEditar.getListaEmpleadores()){
            idsEmpleadoresDesignados.add(empleador.getIdEmpleador());
        }
        model.addAttribute("listaEmpleadores",listaEmpleadores);
        model.addAttribute("idsEmpleadores", idsEmpleadoresDesignados);
        List<InstitucionPrevision> listaInstitucionesPrevision = objInstitucionPrevisionService.listarInstitucionesPrevision();
        model.addAttribute("listaInstitucionesPrevision", listaInstitucionesPrevision);
        List<InstitucionSalud> listaInstitucionSalud = objInstitucionSaludService.listarInstitucionesSalud();
        model.addAttribute("listaInstitucionSalud", listaInstitucionSalud);
        return "editarTrabajador";
    }
    @PostMapping("/editar/{idTrabajador}")
    public String actualizarTrabajador(@PathVariable int idTrabajador, @ModelAttribute Trabajador trabajador, @RequestParam("empleadores") List<Integer> idsEmpleadores){
        List<Empleador> empleadores = new ArrayList<>();
        for(Integer idEmpleador: idsEmpleadores){
            Empleador empleador = objEmpleadorService.buscarEmpleadorPorId(idEmpleador);
            empleadores.add(empleador);
        }
        trabajador.setListaEmpleadores(empleadores);
        trabajador.setIdTrabajador(idTrabajador);
        objTrabajadorService.actualizarTrabajador(trabajador, idTrabajador);
        return "redirect:/trabajador/trabajadores";
    }

    @PostMapping("/eliminar/{idtrabajador}")
    public String eliminarTrabajador(@PathVariable int idtrabajador){
        objTrabajadorService.eliminarTrabajador(idtrabajador);
        return "redirect:/trabajador/trabajadores";
    }

}
