package com.petfriends.dao;

import com.petfriends.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component //Without the post controller class is incomplete and will produce error -- DEPENDENCY
public class MemoryPostDao implements PostDao {

    private List<Post> postList;
    private int nextId = 5;

    public MemoryPostDao() {
        postList = new ArrayList<>();

        // Make some test posts to send back to test the controller
        for (int i=0; i<5; i++) {
            Post post = new Post();
            post.setId(i);
            post.setTitle("Test Post " + i);
            post.setText("Test text " + i);
            postList.add(post);
        }
    }

    @Override
    public Post createPost(Post postData) {
        postData.setId(nextId++);
        postList.add(postData);
        return postData;
    }

    @Override
    public List<Post> getPosts() {
        return postList;
    }

    @Override
    public Post getPost(int id) {
        Post post = null;

        for (Post current : postList) {
            if (current.getId() == id) {
                post = current;
            }
        }

        return post;
    }

    @Override
    public Post updatePost(int id, Post postData) {
        // Find post to update - replace it with the new postData
        Post post = null;
        for (int i=0; i< postList.size(); i++) {
            Post current = postList.get(i);
            if (current.getId() == id) {
                post = postData;
                postList.remove(i);
                postData.setId(id);
                postList.add(postData);
            }
        }

        return post;
    }

    @Override
    public void deletePost(int id) {
        for (int i=0; i< postList.size(); i++) {
            Post current = postList.get(i);
            if (current.getId() == id) {
                postList.remove(i);
            }
        }
    }
}