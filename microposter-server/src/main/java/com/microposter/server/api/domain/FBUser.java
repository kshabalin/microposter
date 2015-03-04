package com.microposter.server.api.domain;

public class FBUser {
private String id;
private String email;
private String username;
private String name;
private String firstName;
private String middleName;
private String lastName;
private String gender;
private Integer timezone;
private String birthday;
private String uid; //User#id
private String token;

public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getEmail() {
  return email;
}

public void setEmail(String email) {
  this.email = email;
}

public String getUsername() {
  return username;
}

public void setUsername(String username) {
  this.username = username;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public String getFirstName() {
  return firstName;
}

public void setFirstName(String firstName) {
  this.firstName = firstName;
}

public String getMiddleName() {
  return middleName;
}

public void setMiddleName(String middleName) {
  this.middleName = middleName;
}

public String getLastName() {
  return lastName;
}

public void setLastName(String lastName) {
  this.lastName = lastName;
}

public String getGender() {
  return gender;
}

public void setGender(String gender) {
  this.gender = gender;
}

public Integer getTimezone() {
  return timezone;
}

public void setTimezone(Integer timezone) {
  this.timezone = timezone;
}

public String getBirthday() {
  return birthday;
}

public void setBirthday(String birthday) {
  this.birthday = birthday;
}

public String getUid() {
  return uid;
}

public void setUid(String uid) {
  this.uid = uid;
}

public String getToken() {
  return token;
}

public void setToken(String token) {
  this.token = token;
}
}
