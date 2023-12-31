package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, name = "apellido_1", length = 100)
    private String apellido1;

    @Column(name = "apellido_2", length = 100)
    private String apellido2;

    @Column(columnDefinition = "TEXT",length = 500)
    private String direccion;

    @Column(length = 100)
    private String email;

    @Column
    private long telefono;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario",nullable = false)
    @ToString.Exclude
    private Usuario idUsuario;


    @ManyToMany(mappedBy = "listaEmpleadores")
    @ToString.Exclude
    private List<Trabajador> listaTrabajadores;
}
