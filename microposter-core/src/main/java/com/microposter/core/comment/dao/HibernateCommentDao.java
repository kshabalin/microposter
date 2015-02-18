package com.microposter.core.comment.dao;


import com.microposter.core.comment.domain.Comment;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HibernateCommentDao implements CommentDao {
private static String ALL_COMMENTS_BY_POST_QUERY = "SELECT * FROM comments WHERE pid = ?";
private static String ALL_COMMENTS_BY_USER_QUERY = "SELECT * FROM comments WHERE uid = ?";

@Autowired
private SessionFactory sessionFactory;

public void createComment(Comment comment) {
  sessionFactory.getCurrentSession().save(comment);
}

public void deleteComment(int cid) {
  Comment comment = (Comment) sessionFactory.getCurrentSession().load(Comment.class, cid);
  if (comment != null) {
    sessionFactory.getCurrentSession().delete(comment);
  }
}

public List<Comment> getAllCommentsByUser(int uid) {
  String getCommentsByUserQuery = String.format(ALL_COMMENTS_BY_USER_QUERY, uid);
  List<Comment> comments = sessionFactory.getCurrentSession().createSQLQuery(getCommentsByUserQuery).addEntity(Comment.class).list();
  return comments;
}

public List<Comment> getAllCommentsByPost(int pid) {
  String getCommentsByPostQuery = String.format(ALL_COMMENTS_BY_POST_QUERY, pid);
  List<Comment> comments = sessionFactory.getCurrentSession().createSQLQuery(getCommentsByPostQuery).addEntity(Comment.class).list();
  return comments;
}
}
