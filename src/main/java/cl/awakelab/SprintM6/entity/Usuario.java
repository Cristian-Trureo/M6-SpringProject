package cl.awakelab.SprintM6.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @Column(nullable = false, unique = true)
    private int run;
    @Column(nullable = false, length = 200)
    private String clave;
    @Column(nullable = false, length = 100)
    private String nombre;
    @Column(name="apellido_1", nullable = false, length = 100)
    private String apellido1;
    @Column(name="apellido_2", length = 100)
    private String apellido2;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_perfil", nullable = false)
    @JsonManagedReference
    //@JsonIgnore
    public Perfil perfil;

    @Column(nullable = false, length = 100)
    private String email;
    @Column(name="fecha_creacion",nullable = false)
    private LocalDateTime fechaCreacion;

    @Column
    private long telefono;

    @OneToMany(mappedBy = "idUsuario", cascade = CascadeType.ALL)
    private List<Empleador> listaEmpleadores;
}
