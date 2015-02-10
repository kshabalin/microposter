package com.microposter.core.post.dao;

import com.microposter.core.post.domain.Post;

import java.util.List;

public interface PostDao {
void createPost(Post post);
void deletePost(int id);
List<Post> getAllPosts();
List<Post> getPostsByUser(int uid);
Post getPost(int pid);
}
