package com.microposter.core.comment.manager;

import com.microposter.core.comment.dao.CommentDao;
import com.microposter.core.comment.domain.Comment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentManager")
public class CommentManagerImpl implements CommentManager {
private static final Log LOG = LogFactory.getLog(CommentManagerImpl.class);

@Autowired
private CommentDao commentDao;

@Transactional
@Override
public void create(Comment comment) {
  commentDao.create(comment);
}

@Transactional
@Override
public void delete(int cid) {
  commentDao.delete(cid);
}

@Transactional(readOnly = true)
@Override
public List<Comment> getAllByUser(int uid) {
  return commentDao.getAllByUser(uid);
}

@Transactional(readOnly = true)
@Override
public List<Comment> getAllByPost(int pid) {
  return commentDao.getAllByPost(pid);
}

}
