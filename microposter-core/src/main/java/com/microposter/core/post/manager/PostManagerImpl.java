package com.microposter.core.post.manager;


import com.microposter.core.post.dao.PostDao;
import com.microposter.core.post.domain.Post;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("postManager")
public class PostManagerImpl implements PostManager {
private static final Log LOG = LogFactory.getLog(PostManagerImpl.class);

@Autowired
private PostDao postDao;

@Transactional
@Override
public int create(Post post) {
  return postDao.create(post);
}

@Transactional
@Override
public void delete(int id) {
  postDao.delete(id);
}

@Transactional(readOnly = true)
@Override
public List<Post> getAll() {
  List<Post> posts = postDao.getAll();
  return posts;
}

@Transactional(readOnly = true)
@Override
public List<Post> getByUser(int uid) {
  List<Post> posts = postDao.getByUser(uid);
  return posts;
}

@Transactional(readOnly = true)
@Override
public Post getById(int pid) {
  Post post = postDao.getById(pid);
  return post;
}
}
