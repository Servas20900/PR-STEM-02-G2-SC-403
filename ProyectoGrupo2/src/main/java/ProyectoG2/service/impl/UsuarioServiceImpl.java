package ProyectoG2.service.impl;


import ProyectoG2.dao.UsuarioDao;
import ProyectoG2.domain.Usuario;
import ProyectoG2.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Long id) {
        Optional<Usuario> usuario = usuarioDao.findById(id);
        return usuario.orElse(null); // Retorna null si no se encuentra el usuario
    }

    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }
}