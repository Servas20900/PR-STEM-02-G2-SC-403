package ProyectoG2.dao;

import ProyectoG2.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogDao extends JpaRepository<Blog, Long> {

}
