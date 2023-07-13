package cl.awakelab.SprintM6.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @Column(name="id_usuario",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(nullable = false)
    private int run;
    @Column(nullable = false)
    private String clave;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido1;
    private String apellido2;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil", nullable = false)
    public Perfil perfil;
    @Column(nullable = false)
    private String email;
    @Column(name="fecha_creacion",nullable = false)
    private LocalDateTime fechaCreacion;
    @Column
    private long telefono;

    @OneToMany(mappedBy = "idUsuario")
    private List<Empleador> listaEmpleadores;
}
