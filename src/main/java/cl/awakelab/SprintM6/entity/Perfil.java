package cl.awakelab.SprintM6.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

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
    public boolean getEstado() {
        return estado;
    }


    @OneToMany(mappedBy = "perfil")
    //@JsonBackReference
    //@JsonIgnore
    @ToString.Exclude
    private List<Usuario> listaUsuarios;

}
