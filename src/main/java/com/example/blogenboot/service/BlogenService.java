package com.example.blogenboot.service;

import com.example.blogenboot.dao.CategoryDao;
import com.example.blogenboot.dao.PostDao;
import com.example.blogenboot.dao.UserDao;
import com.example.blogenboot.ds.Category;
import com.example.blogenboot.ds.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogenService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostDao postDao;
    public void saveCategory(Category category){

    }
    public String findAllCategories() {
        return "list-categories";
    }

    public String findAllUsers() {
        return "list-users";
    }

    public List<Post> findAllPosts() {
        return postDao.findAll();
    }

    public void savePost(Post post) {
        post.setCategory(categoryDao.findById(post.getCategory().getId()).get());
        post.setUser(userDao.findById(post.getUser().getId()).get());
        postDao.savePost(post);
    }
}
