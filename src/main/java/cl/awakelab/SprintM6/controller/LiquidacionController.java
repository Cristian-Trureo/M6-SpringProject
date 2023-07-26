package cl.awakelab.SprintM6.controller;

import cl.awakelab.SprintM6.entity.*;
import cl.awakelab.SprintM6.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/liquidacion")
public class LiquidacionController {
    @Autowired
    private ITrabajadorService objTrabajadorService;
    @Autowired
    private IInstitucionSaludService objInstitucionSaludService;
    @Autowired
    private IInstitucionPrevisionService objInstitucionPrevisionService;
    @Autowired
    private IEmpleadorService objEmpleadorService;
    @Autowired
    private IUsuarioService objUsuarioService;
    @Autowired
    private ILiquidacionService objLiquidacionService;


    //CREAR
    @GetMapping("/crearLiquidacion")
    public String mostrarFormLiquidacion(Model model){
        List<InstitucionPrevision> listaInstitucionPrevision = objInstitucionPrevisionService.listarInstitucionesPrevision();
        List<InstitucionSalud> listaInstitucionSalud = objInstitucionSaludService.listarInstitucionesSalud();
        List<Trabajador> listaTrabajadores = objTrabajadorService.listarTrabajadores();
        model.addAttribute("listaInstitucionSalud", listaInstitucionSalud);
        model.addAttribute("listaInstitucionesPrevision", listaInstitucionPrevision);
        model.addAttribute("listaTrabajadores", listaTrabajadores);
        model.addAttribute("paginaActual", "crearLiquidacion");
        return "crearLiquidacion";
    }
    @PostMapping("/crearLiquidacion")
    public String crearLiquidacion(@ModelAttribute Liquidacion liquidacion,
                                   RedirectAttributes redirectAttributes,
                                   @RequestParam("trabajador") int idTrabajador,
                                   @RequestParam("institucionPrevision") int idInstPrevision,
                                   @RequestParam("periodo") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate periodo) {
        Trabajador trabajador = objTrabajadorService.buscarTrabajadorPorId(idTrabajador);
        if (trabajador == null) {
            return "redirect:/liquidacion/crearLiquidacion";
        }
        liquidacion.setIdTrabajador(trabajador);
        liquidacion.setPeriodo(periodo);
        objLiquidacionService.crearLiquidacion(liquidacion);
        return "redirect:/liquidacion/liquidaciones";
    }


    //LISTAR
    @GetMapping("/liquidaciones")
    public String mostrarLiquidaciones(Model model){
        List<Liquidacion> listaLiquidaciones = objLiquidacionService.listarLiquidaciones();
        model.addAttribute("paginaActual","liquidaciones");
        model.addAttribute("liquidaciones",listaLiquidaciones);
        return "listaliquidaciones";
    }

    //EDITAR
    //ELIMINAR
    @PostMapping("/eliminar/{idLiquidacion}")
    public String eliminarLiquidacion(@PathVariable Long idLiquidacion){
        objLiquidacionService.eliminarLiquidacion(idLiquidacion);
        return "redirect:/liquidacion/liquidaciones";
    }

}
