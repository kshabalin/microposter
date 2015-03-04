package com.microposter.core.post.manager;

import com.microposter.core.post.domain.Post;

import java.util.List;

public interface PostManager {
int create(Post post);
void delete(int id);
List<Post> getAll();
List<Post> getByUser(int uid);
Post getById(int pid);
}
