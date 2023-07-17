package cl.awakelab.SprintM6.entity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="perfil")
public class Perfil {
    @Id
    @Column(nullable = false, name = "id_perfil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPerfil;
    @Column(nullable = false, length = 50)
    private String descripcion;
    @Column(nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "perfil")
    private List<Usuario> listaUsuarios;
}
