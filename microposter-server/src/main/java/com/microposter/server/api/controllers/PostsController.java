package com.microposter.server.api.controllers;

import com.microposter.core.post.domain.Post;
import com.microposter.core.post.manager.PostManager;
import com.microposter.server.common.JsonResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostsController {

private static final Log LOG = LogFactory.getLog(PostsController.class);

@Value("#{postManager}")
private PostManager postManager;

@RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
@ResponseBody
public Post create(@RequestBody Post post) {
  try {
    postManager.createPost(post);
    return post;
  } catch (Exception e) {
    LOG.error("Failed to create the post, %s", e);
    throw new RuntimeException(e);
  }
}

@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
@ResponseBody
public List<Post> getAllPostsByUser(@PathVariable("uid") String uid) {
  try {
    List<Post> posts = postManager.getPostsByUser(Integer.parseInt(uid));
    return posts;
  } catch (Exception e) {
    LOG.error("Failed to get all posts by user, %s", e);
    throw new RuntimeException(e);
  }
}

@RequestMapping(value = "/", method = RequestMethod.GET)
@ResponseBody
public List<Post> getAllPosts() {
  try {
    List<Post> posts = postManager.getAllPosts();
    return posts;
  } catch (Exception e) {
    LOG.error("Failed to get all posts, %s", e);
    throw new RuntimeException(e);
  }
}

@RequestMapping(value = "/{pid}", method = RequestMethod.GET)
@ResponseBody
public Post getPost(@PathVariable("pid") String pid) {
  try {
    Post post = postManager.getPost(Integer.parseInt(pid));
    return post;
  } catch (Exception e) {
    LOG.error("Failed to get the post, %s", e);
    throw new RuntimeException(e);
  }
}

@RequestMapping(value = "/{pid}", method = RequestMethod.DELETE)
public void delete(@PathVariable("pid") String pid) {
  try {
    postManager.deletePost(Integer.parseInt(pid));
  } catch (Exception e) {
    LOG.error("Failed to delete the post, %s", e);
    throw new RuntimeException(e);
  }
}
}
