package com.example.mamnoncvn.BlogManager.models.mapper;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.models.request.CreateBlogRequest;
import com.example.mamnoncvn.BlogManager.models.request.UpdateBlogRequest;

public class BlogMapper {
    public static Blog requestToBlog(CreateBlogRequest blogRequest){
        Blog blog = new Blog();
        blog.setAuthor(blogRequest.getAuthor());
        blog.setCategory(blogRequest.getCategory());
        blog.setContent(blogRequest.getContent());
        blog.setDescription(blogRequest.getDescription());
        blog.setThumbnail(blogRequest.getThumbnail());
        blog.setTitle(blogRequest.getTitle());
        blog.setDateCreated(blogRequest.getDateCreated());
        blog.setDateModified(blogRequest.getDateModified());
        return blog;
    }
    public static Blog updateRequestToBlog(UpdateBlogRequest updateBlogRequest){
        Blog blog = new Blog();
        blog.setAuthor(updateBlogRequest.getAuthor());
        blog.setCategory(updateBlogRequest.getCategory());
        blog.setContent(updateBlogRequest.getContent());
        blog.setDescription(updateBlogRequest.getDescription());
        blog.setDateCreated(updateBlogRequest.getDateCreated());
        blog.setDateModified(updateBlogRequest.getDateModified());
        blog.setThumbnail(updateBlogRequest.getThumbnail());
        blog.setDescription(updateBlogRequest.getDescription());
        return blog;
    }
}
