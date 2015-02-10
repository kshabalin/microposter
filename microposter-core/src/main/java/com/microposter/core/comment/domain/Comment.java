package com.microposter.core.comment.domain;


public class Comment {
private int id;
private int uid; //Owner ID;
private int pid;
private String title;
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
