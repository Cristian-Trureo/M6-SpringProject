package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="empleador")
public class Empleador {
    @Id
    @Column(name="id_empleador", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEmpleador;
    @Column(nullable = false, unique = true)
    private int run;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido1;
    @Column(nullable = false)
    private String apellido2;
    @Column
    private String direccion;
    @Column
    private String email;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario",nullable = false)
    private Usuario idUsuario;

    @Column
    private long telefono;

    @ManyToMany(mappedBy = "listaEmpleadores")
    private List<Trabajador> listaTrabajadores;
}
