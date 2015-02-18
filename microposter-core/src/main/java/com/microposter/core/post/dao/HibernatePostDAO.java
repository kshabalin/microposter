package com.microposter.core.post.dao;


import com.microposter.core.post.domain.Post;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernatePostDAO implements PostDao{
private static String ALL_POST_BY_USER_QUERY = "SELECT * FROM CUSTOMER WHERE uid = ?";

@Autowired
private SessionFactory sessionFactory;

public void createPost(Post post) {
  sessionFactory.getCurrentSession().save(post);
}

public void deletePost(int id) {
  Post post = (Post) sessionFactory.getCurrentSession().load(Post.class, id);
  if (post != null) {
    sessionFactory.getCurrentSession().delete(post);
  }
}

public List<Post> getAllPosts() {
  List<Post> posts = sessionFactory.getCurrentSession().createCriteria(Post.class).list();
  return posts;
}

public List<Post> getPostsByUser(int uid) {
  String getPostByUserQuery = String.format(ALL_POST_BY_USER_QUERY, uid);
  List<Post> posts = sessionFactory.getCurrentSession().createSQLQuery(getPostByUserQuery).addEntity(Post.class).list();
  return posts;
}

public Post getPost(int pid) {
  Post post = (Post) sessionFactory.getCurrentSession().load(Post.class, pid);
  return post;
}
}
