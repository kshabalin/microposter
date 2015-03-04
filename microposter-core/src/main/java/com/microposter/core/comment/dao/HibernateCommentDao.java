package com.microposter.core.comment.dao;


import com.microposter.core.comment.domain.Comment;
import org.hibernate.classic.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HibernateCommentDao implements CommentDao {
private static String ALL_COMMENTS_BY_POST_QUERY = "SELECT * FROM comments WHERE pid = ?";
private static String ALL_COMMENTS_BY_USER_QUERY = "SELECT * FROM comments WHERE uid = ?";

@Autowired
private SessionFactory sessionFactory;

@SuppressWarnings("unchecked")
@Override
public void create(Comment comment) {
  sessionFactory.getCurrentSession().save(comment);
}

@SuppressWarnings("unchecked")
@Override
public void delete(int cid) {
  Comment comment = (Comment) getSession().load(Comment.class, cid);
  if (comment != null) {
    sessionFactory.getCurrentSession().delete(comment);
  }
}

@SuppressWarnings("unchecked")
@Override
public List<Comment> getAllByUser(int uid) {
  String getCommentsByUserQuery = String.format(ALL_COMMENTS_BY_USER_QUERY, uid);
  List<Comment> comments = getSession().createSQLQuery(getCommentsByUserQuery).addEntity(Comment.class).list();
  return comments;
}

@SuppressWarnings("unchecked")
@Override
public List<Comment> getAllByPost(int pid) {
  String getCommentsByPostQuery = String.format(ALL_COMMENTS_BY_POST_QUERY, pid);
  List<Comment> comments = getSession().createSQLQuery(getCommentsByPostQuery).addEntity(Comment.class).list();
  return comments;
}

private Session getSession() {
  return sessionFactory.getCurrentSession();
}
}
