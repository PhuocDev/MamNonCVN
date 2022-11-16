package com.example.mamnoncvn.BlogManager.models.mapper;

import com.example.mamnoncvn.BlogManager.entity.Blog;
import com.example.mamnoncvn.BlogManager.models.request.CreateBlogRequest;

public class BlogMapper {
    public static Blog requestToBlog(CreateBlogRequest blogRequest){
        Blog blog = new Blog();
        blog.setAuthor(blogRequest.getAuthor());
        blog.setCategory(blogRequest.getCategory());
        blog.setContent(blogRequest.getContent());
        blog.setDescription(blogRequest.getDescription());
        blog.setThumbnail(blogRequest.getThumbnail());
        blog.setTitle(blogRequest.getTitle());

        return blog;
    }
}
