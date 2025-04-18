package ProyectoG2.service;

import ProyectoG2.domain.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> getAllBlogs();
    void saveBlog(Blog blog);
    void deleteBlog(Long id);
    Optional<Blog> getBlogById(Long id);
}