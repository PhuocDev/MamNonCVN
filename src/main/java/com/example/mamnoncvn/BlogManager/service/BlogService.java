package com.example.mamnoncvn.BlogManager.service;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.models.mapper.BlogMapper;
import com.example.mamnoncvn.BlogManager.models.request.CreateBlogRequest;
import com.example.mamnoncvn.BlogManager.models.request.UpdateBlogRequest;
import com.example.mamnoncvn.BlogManager.repository.BlogRepository;
import com.example.mamnoncvn.exception.BadRequestException;
import com.example.mamnoncvn.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository;

    public Blog save(CreateBlogRequest createBlogRequest) {
        Blog blog = blogRepository.findByTitle(createBlogRequest.getTitle());
        if (blog != null) {
            throw new BadRequestException("Tilte Blog đã tồn tại trong hệ thống");
        }
        createBlogRequest.setDateCreated(LocalDate.now());
        createBlogRequest.setDateModified(LocalDate.now());
        blog = BlogMapper.requestToBlog(createBlogRequest);
        blogRepository.save(blog);
        return blog;
    }
    public List<Blog> findAllBlogs(String keyword) {
        if (keyword != null || !keyword.equals("")) {
            return  blogRepository.findAllByKeyword(keyword);
        }
        else return blogRepository.findAll();
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

    public Blog update(UpdateBlogRequest updateBlogRequest) {
        Blog blog = blogRepository.findById(updateBlogRequest.getId()).get();
        blog.setContent(updateBlogRequest.getContent());
        blog.setThumbnail(updateBlogRequest.getThumbnail());
        blog.setDescription(updateBlogRequest.getDescription());
        blog.setTitle(updateBlogRequest.getTitle());
        blog.setAuthor(updateBlogRequest.getAuthor());
        blog.setDateModified(updateBlogRequest.getDateModified());
        blog.setDateCreated(updateBlogRequest.getDateCreated());
        blog.setCategory(updateBlogRequest.getCategory());
        blogRepository.saveAndFlush(blog);
        return blog;
    }

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public List<Blog> findAllByCategory(String category) {
        return blogRepository.findAllByCategory(category);
    }
    public List<Blog> findAllInOneCategory(String category, String keyword) {
        return blogRepository.findAllInOneCategory(keyword, category);
    }
}
