package com.microposter.core.post.manager;


import com.microposter.core.post.dao.PostDao;
import com.microposter.core.post.domain.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "postManager")
public class PostManagerImpl implements PostManager {
private static final Log LOG = LogFactory.getLog(PostManagerImpl.class);

@Value("#{postDao}")
private PostDao postDao;

@Transactional
public void createPost(Post post) {
  postDao.createPost(post);
}

@Transactional
public void deletePost(int id) {
  postDao.deletePost(id);
}

@Transactional
public List<Post> getAllPosts() {
  List<Post> posts = postDao.getAllPosts();
  return posts;
}

@Transactional
public List<Post> getPostsByUser(int uid) {
  List<Post> posts = postDao.getPostsByUser(uid);
  return posts;
}

@Transactional
public Post getPost(int pid) {
  Post post = postDao.getPost(pid);
  return post;
}
}
