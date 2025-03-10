package ProyectoG2.dao;

import ProyectoG2.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository <User, Long> {

}