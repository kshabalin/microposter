package com.microposter.core.post.dao;

import com.microposter.core.post.domain.Post;

import java.util.List;

public interface PostDao {
int create(Post post);
void delete(int id);
List<Post> getAll();
List<Post> getByUser(int uid);
Post getById(int pid);
}
