package com.petfriends.controller;


import com.petfriends.dao.PostDao;
import com.petfriends.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *  REST API
 *  Routes
 *  - GET /post  - This returns all the posts ordered newest to oldest
 *  - GET /post/{id} - Return the post with that id
 *  - POST /post - This adds a new POST
 *  - DELETE /post/{id} - Remove the post with the specified id
 *  - PUT /post/{id} - Allows us to edit an existing post
 *
 */

@RestController //Receives incoming web requests
@RequestMapping("/post") //sets up URL use
public class PostController {

    @Autowired
    private PostDao postDao;

    public PostController(PostDao postDao) {
        this.postDao = postDao;
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Post> getPosts(){
        return postDao.getPosts();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id) {
        return postDao.getPost(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "", method = RequestMethod.POST)
    public Post addPost(@Valid @RequestBody Post postData) {

        return postDao.createPost(postData);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void deletePost(@PathVariable int id) {
        postDao.deletePost(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Post updatePost(@Valid @PathVariable int id, @RequestBody Post postData) {
        return postDao.updatePost(id, postData);
    }

}
