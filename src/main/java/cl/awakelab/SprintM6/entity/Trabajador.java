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
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido1;
    @Column(nullable = false)
    private String apellido2;
    @Column
    private String mail;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_inst_prevision", nullable = false )
    private int idInstPrevision;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_inst_salud", nullable = false )
    private int idInstSalud;
    @Column
    private long telefono;

    @ManyToMany
    @JoinTable(name = "empl_trab",
            joinColumns = @JoinColumn(name = "id_trabajador", nullable=false),
            inverseJoinColumns = @JoinColumn(name = "id_empleador", nullable = false))
    private List<Empleador> listaEmpleadores;

    @OneToMany(mappedBy = "trabajador")
    private List<Liquidacion> listaLiquidaciones;
}
