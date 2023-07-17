package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="trabajador")
public class Trabajador {
    @Id
    @Column(name="id_trabajador", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTrabajador;
    @Column(nullable = false, unique = true)
    private int run;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, name = "apellido_1", length = 100)
    private String apellido1;
    @Column(name = "apellido_2", length = 100)
    private String apellido2;
    @Column(name="email", length = 100)
    private String email;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_inst_prevision", nullable = false )
    private InstitucionPrevision idInstPrevision;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_inst_salud", nullable = false)
    private InstitucionSalud idInstSalud;
    @Column
    private long telefono;

    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_trabajador", nullable=false),
            inverseJoinColumns = @JoinColumn(name = "id_empleador", nullable = false))
    private List<Empleador> listaEmpleadores;

    @OneToMany(mappedBy = "idTrabajador")
    private List<Liquidacion> listaLiquidaciones;
}
