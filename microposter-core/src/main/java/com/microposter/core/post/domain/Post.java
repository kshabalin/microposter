package com.microposter.core.post.domain;


import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

@Id
@Column(name = "pid")
@GeneratedValue
private Integer id;

@Column(name = "uid")
private Integer uid; //Owner ID;

@Column(name = "title")
private String title;

@Column(name = "description")
private String desc;

@Transient
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
