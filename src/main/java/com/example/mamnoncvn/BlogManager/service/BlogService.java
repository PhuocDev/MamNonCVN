package com.example.mamnoncvn.BlogManager.service;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.repository.BlogRepository;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public void save(Blog newBlog) {
        blogRepository.save(newBlog);
    }
    public List<Blog> findAllBlogs() {
        return blogRepository.findAll();
    }

    public Blog findBlogById(Long id) {
        if (blogRepository.existsById(id)) {
            return blogRepository.findById(id).get();
        } else return null;
    }

    public void deleteBlogById(Long id) {
        if (blogRepository.existsById(id)){
            blogRepository.deleteById(id);
        } else throw new NotFoundException("Can not found blog id: " + id);
    }
}
