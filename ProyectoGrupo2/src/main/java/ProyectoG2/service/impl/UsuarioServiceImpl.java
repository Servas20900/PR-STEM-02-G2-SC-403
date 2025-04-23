package ProyectoG2.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ProyectoG2.dao.UsuarioDao;
import ProyectoG2.domain.Usuario;
import ProyectoG2.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public Usuario getUsuario(Usuario usuario) {
        return usuarioDao.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    public Usuario getUsuarioPorUsername(String username) {
        return usuarioDao.findByUsername(username);
    }

    @Override
    public Usuario getUsuarioPorUsernameYPassword(String username, String password) {
        return usuarioDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public Usuario getUsuarioPorUsernameOCorreo(String username, String correo) {
        return usuarioDao.findByUsernameOrCorreo(username, correo);
    }
    @Override
    public void save(Usuario usuario) {
        usuarioDao.save(usuario);
    }

    @Override
    public void save1(Usuario usuario) {
        // ver si el usuario ya existe en la base de datos antes de decidir si debemos encriptar la contraseña o no
        Optional<Usuario> usuarioExistente = usuarioDao.findById(usuario.getIdUsuario());

        if (usuarioExistente.isPresent()) {
            Usuario existente = usuarioExistente.get();

            // Solo encriptar si la contraseña fue modificada y no ya está encriptada
            if (!usuario.getPassword().equals(existente.getPassword()) && !usuario.getPassword().startsWith("$2a$")) {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }
        } else {
            // Nuevo usuario: encriptar siempre
            usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        }

        usuarioDao.save(usuario);
    }

    @Override
    public void delete(Usuario usuario) {
        usuarioDao.delete(usuario);
    }



}