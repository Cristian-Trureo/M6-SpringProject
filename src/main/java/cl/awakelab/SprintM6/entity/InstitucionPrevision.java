package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name="institucion_prevision")
public class InstitucionPrevision {
    @Id
    @Column(name="id_inst_prevision", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstPrevision;

    @Column(nullable = false, length = 50)
    private String descripcion;

    @Column(name="porc_dcto", nullable = false)
    private float porcDcto;

    @OneToMany(mappedBy = "idInstPrevision")
    @ToString.Exclude
    private List<Trabajador> listaTrabajadores;

    @OneToMany(mappedBy = "institucionPrevision")
    @ToString.Exclude
    private List<Liquidacion> listaLiquidaciones;

}
