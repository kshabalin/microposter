package com.microposter.core.comment.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

@Id
@Column(name = "cid")
@GeneratedValue
private int id;

@Column(name = "uid")
private int uid; //Owner ID;

@Column(name = "uid")
private int pid;

@Column(name = "title")
private String title;

@Column(name = "body")
private String desc;

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

public int getPid() {
  return pid;
}

public void setPid(int pid) {
  this.pid = pid;
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
}
