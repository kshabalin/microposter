package com.microposter.core.post.dao;


import com.microposter.core.post.domain.Post;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernatePostDAO implements PostDao{
private static String ALL_POST_BY_USER_QUERY = "SELECT * FROM CUSTOMER WHERE uid = ?";

@Autowired
private SessionFactory sessionFactory;

@SuppressWarnings("unchecked")
@Override
public int create(Post post) {
  return Integer.parseInt(sessionFactory.getCurrentSession().save(post).toString());
}

@SuppressWarnings("unchecked")
@Override
public void delete(int id) {
  Post post = (Post) sessionFactory.getCurrentSession().load(Post.class, id);
  if (post != null) {
    getSession().delete(post);
  }
}

@SuppressWarnings("unchecked")
@Override
public List<Post> getAll() {
  List<Post> posts = getSession().createCriteria(Post.class).list();
  return posts;
}

@SuppressWarnings("unchecked")
@Override
public List<Post> getByUser(int uid) {
  String getPostByUserQuery = String.format(ALL_POST_BY_USER_QUERY, uid);
  List<Post> posts = getSession().createSQLQuery(getPostByUserQuery).addEntity(Post.class).list();
  return posts;
}

@SuppressWarnings("unchecked")
@Override
public Post getById(int pid) {
  Post post = (Post) getSession().load(Post.class, pid);
  return post;
}

private Session getSession() {
  return sessionFactory.getCurrentSession();
}
}
