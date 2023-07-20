package cl.awakelab.SprintM6.service.serviceimpl;

import cl.awakelab.SprintM6.entity.Perfil;
import cl.awakelab.SprintM6.entity.Usuario;
import cl.awakelab.SprintM6.repository.IPerfilRepository;
import cl.awakelab.SprintM6.repository.IUsuarioRepository;
import cl.awakelab.SprintM6.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service("usuarioImpl")
public class UsuarioImpl implements IUsuarioService {
    @Autowired
    IUsuarioRepository objUsuarioRepo;
    @Autowired
    IPerfilRepository objPerfilRepo;
    @Override
    public Usuario crearUsuario(Usuario usuario){
        return objUsuarioRepo.save(usuario);
    }
    @Override
    public List<Usuario> listarUsuarios(){
        return objUsuarioRepo.findAll();
    }

    @Override
    public Usuario buscarUsuarioPorId(int idUsuario){
        return objUsuarioRepo.findById(idUsuario).orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuarioActualizar, int idUsuario){
        Usuario usuario = objUsuarioRepo.findById(idUsuario).orElseThrow(()->new NoSuchElementException("Usuario no encontrado"));
        usuario.setRun(usuarioActualizar.getRun());
        usuario.setClave(usuarioActualizar.getClave());
        usuario.setNombre(usuarioActualizar.getNombre());
        usuario.setApellido1(usuarioActualizar.getApellido1());
        usuario.setApellido2(usuarioActualizar.getApellido2());
        usuario.setEmail(usuarioActualizar.getEmail());
        usuario.setTelefono(usuarioActualizar.getTelefono());
        usuario.setPerfil(usuarioActualizar.getPerfil());
        // aca tomamos el id que viene desde el html y con repository de perfil vamos a buscarlo a la base de datos x id
/*        Optional<Perfil> perfilOptional = objPerfilRepo.findById(usuarioActualizar.getPerfil().getIdPerfil());
        // si existe se setea el registro completo a usuario (id, descripcion, estado)
        if (perfilOptional.isPresent()) {
            usuario.setPerfil(perfilOptional.get());
        }*/
        return objUsuarioRepo.save(usuario);
    }
    @Override
    public void eliminarUsuario(int idUsuario) {
        objUsuarioRepo.deleteById(idUsuario);
    }
}









