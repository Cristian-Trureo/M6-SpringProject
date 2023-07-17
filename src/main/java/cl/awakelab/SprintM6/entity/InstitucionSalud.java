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
    @Column(nullable = false, length = 50)
    private String descripcion;
    @Column(name="porc_dcto", nullable = false)
    private float porcDcto;

    @OneToMany(mappedBy = "idInstSalud")
    private List<Trabajador> listaTrabajadores;


    @OneToMany(mappedBy = "idInstSalud")
    private List<Liquidacion> listaLiquidaciones;
}
