package com.microposter.server.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Greeting {

private final long id;
private final String content;
private final String tmp;

public Greeting(long id, String content, String tmp) {
  this.id = id;
  this.content = content;
  this.tmp = tmp;
}

@JsonIgnore
public String getTmp() {
  return tmp;
}

public long getId() {
  return id;
}

public String getContent() {
  return content;
}
}
