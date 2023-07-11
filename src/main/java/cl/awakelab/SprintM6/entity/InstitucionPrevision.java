package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column(name="id_inst_prevision", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstSaludPrevision;
    @Column(nullable = false)
    private String descripcion;
    @Column(name="porc_dcto", nullable = false)
    private float porcDcto;

    @OneToMany(mappedBy = "institucion_prevision")
    private List<Trabajador> listaTrabajadores;

    @OneToMany(mappedBy = "institucion_prevision")
    private List<Liquidacion> listaLiquidaciones;
}