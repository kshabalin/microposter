package com.microposter.core.comment.manager;

import com.microposter.core.comment.dao.CommentDao;
import com.microposter.core.comment.domain.Comment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentManagerImpl implements CommentManager {
private static final Log LOG = LogFactory.getLog(CommentManagerImpl.class);

@Value("#{commentDao}")
private CommentDao commentDao;

@Transactional
public void createComment(Comment comment) {
  commentDao.createComment(comment);
}

@Transactional
public void deleteComment(int cid) {
  commentDao.deleteComment(cid);
}

@Transactional
public List<Comment> getAllCommentsByUser(int uid) {
  return commentDao.getAllCommentsByUser(uid);
}

@Transactional
public List<Comment> getAllCommentsByPost(int pid) {
  return commentDao.getAllCommentsByPost(pid);
}

}
