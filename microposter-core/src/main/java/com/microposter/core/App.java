package com.microposter.core;


import com.microposter.core.post.dao.PostDao;
import com.microposter.core.post.domain.Post;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class App {

@Value("#{postDao}")
private PostDao postDao;

public void afterPropertiesSet() {
  MainThread thread = new MainThread();
  thread.start();
}

private class MainThread extends Thread {
  @Override
  public void run() {
    List<Post> posts = postDao.getAllPosts();
    for(Post p : posts) {
      System.out.println(String.format("%s %s %s", p.getId(), p.getTitle(), p.getDesc()));
    }
  }
}
}
