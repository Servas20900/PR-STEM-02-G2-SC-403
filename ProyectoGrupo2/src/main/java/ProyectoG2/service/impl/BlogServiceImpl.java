package ProyectoG2.service.impl;

import ProyectoG2.domain.Blog;
import ProyectoG2.service.BlogService;
import ProyectoG2.dao.BlogDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;


    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.findAll();
    }

    @Override
    public void saveBlog(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteById(id);
    }

    @Override
    public Optional<Blog> getBlogById(Long id) {
        return blogDao.findById(id);
    }
}
