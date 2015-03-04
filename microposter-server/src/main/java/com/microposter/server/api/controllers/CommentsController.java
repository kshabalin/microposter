package com.microposter.server.api.controllers;

import com.microposter.core.comment.domain.Comment;
import com.microposter.core.comment.manager.CommentManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentsController {
private static final Log LOG = LogFactory.getLog(CommentsController.class);

@Autowired
private CommentManager commentManager;

@Transactional
@RequestMapping(method = RequestMethod.POST)
@ResponseBody
public Comment create(@RequestBody Comment comment) {
  try {
    commentManager.create(comment);
    return comment;
  } catch (Exception e) {
    LOG.error("Failed to create the comment, %s", e);
    throw new RuntimeException(e);
  }
}

@Transactional(readOnly = true)
@RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
@ResponseBody
public List<Comment> getAllByUser(@PathVariable("uid") int uid) {
  try {
    List<Comment> comments = commentManager.getAllByUser(uid);
    return comments;
  } catch (Exception e) {
    LOG.error("Failed to get all comments by user, %s", e);
    throw new RuntimeException(e);
  }
}

@Transactional(readOnly = true)
@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
@ResponseBody
public List<Comment> getAllByPost(@PathVariable("pid") int pid) {
  try {
    List<Comment> comments = commentManager.getAllByPost(pid);
    return comments;
  } catch (Exception e) {
    LOG.error("Failed to get all comments by post, %s", e);
    throw new RuntimeException(e);
  }
}

@Transactional
@RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
public void delete(@PathVariable("pid") String pid) {
  try {
    commentManager.delete(Integer.parseInt(pid));
  } catch (Exception e) {
    LOG.error("Failed to delete the comment, %s", e);
    throw new RuntimeException(e);
  }
}
}
