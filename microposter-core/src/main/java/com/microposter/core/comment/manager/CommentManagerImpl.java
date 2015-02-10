package com.microposter.core.comment.manager;

import com.microposter.core.comment.dao.CommentDao;
import com.microposter.core.comment.domain.Comment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class CommentManagerImpl implements CommentManager {
private static final Log LOG = LogFactory.getLog(CommentManagerImpl.class);

@Value("#{commentDao}")
private CommentDao commentDao;

public void createComment(Comment comment) {
  commentDao.createComment(comment);
}

public void deleteComment(int cid) {
  commentDao.deleteComment(cid);
}

public List<Comment> getAllCommentsByUser(int uid) {
  return commentDao.getAllCommentsByUser(uid);
}

public List<Comment> getAllCommentsByPost(int pid) {
  return commentDao.getAllCommentsByPost(pid);
}

}
