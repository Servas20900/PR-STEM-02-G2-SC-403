package ProyectoG2.service;

import java.util.List;
import ProyectoG2.domain.User;

public interface UserService {

    // Obtener la lista de usuarios
    List<User> getUsers();

    // Obtener un usuario específico
    User getUser(User user);

    // Guardar un usuario
    void save(User user);

    // Eliminar un usuario
    void delete(User user);
}
