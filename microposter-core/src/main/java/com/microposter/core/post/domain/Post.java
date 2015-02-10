package com.microposter.core.post.domain;


import java.util.Collections;
import java.util.Set;

public class Post {
private int id;
private int uid; //Owner ID;
private String title;
private String desc;
private Set<String> hashtags = Collections.emptySet();

public int getId() {
  return id;
}

public void setId(int id) {
  this.id = id;
}

public int getUid() {
  return uid;
}

public void setUid(int uid) {
  this.uid = uid;
}

public String getTitle() {
  return title;
}

public void setTitle(String title) {
  this.title = title;
}

public String getDesc() {
  return desc;
}

public void setDesc(String desc) {
  this.desc = desc;
}

public Set<String> getHashtags() {
  return hashtags;
}

public void setHashtags(Set<String> hashtags) {
  this.hashtags = hashtags;
}
}
