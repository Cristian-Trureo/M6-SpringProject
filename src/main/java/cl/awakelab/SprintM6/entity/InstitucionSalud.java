package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="institucion_salud")
public class InstitucionSalud {
    @Id
    @Column(name="id_inst_salud", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstSalud;
    @Column(nullable = false)
    private String descripcion;
    @Column(name="porc_dcto", nullable = false)
    private float porcDcto;

    @OneToMany(mappedBy = "institucion_salud")
    private List<Trabajador> listaTrabajadores;


    @OneToMany(mappedBy = "institucion_salud")
    private List<Liquidacion> listaLiquidaciones;
}
