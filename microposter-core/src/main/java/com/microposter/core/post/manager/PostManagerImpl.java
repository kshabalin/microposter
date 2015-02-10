package com.microposter.core.post.manager;


import com.microposter.core.post.dao.PostDao;
import com.microposter.core.post.domain.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "postManager")
public class PostManagerImpl implements PostManager {
private static final Log LOG = LogFactory.getLog(PostManagerImpl.class);

@Value("#{postDao}")
private PostDao postDao;

public void createPost(Post post) {
  postDao.createPost(post);
}

public void deletePost(int id) {
  postDao.deletePost(id);
}

public List<Post> getAllPosts() {
  List<Post> posts = postDao.getAllPosts();
  return posts;
}

public List<Post> getPostsByUser(int uid) {
  List<Post> posts = postDao.getPostsByUser(uid);
  return posts;
}

public Post getPost(int pid) {
  Post post = postDao.getPost(pid);
  return post;
}
}
