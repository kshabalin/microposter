package com.microposter.core.user.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collections;
import java.util.Set;

public class User {
private int id;
private String email;
private String name;
private String firstName;
private String middleName;
private String lastName;
private String gender;
private String birthday;
private String photoId;
private String password;

public int getId() {
  return id;
}

public void setId(int id) {
  this.id = id;
}

public String getEmail() {
  return email;
}

public void setEmail(String email) {
  this.email = email;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

@JsonIgnore
public String getFirstName() {
  return firstName;
}

public void setFirstName(String firstName) {
  this.firstName = firstName;
}

@JsonIgnore
public String getMiddleName() {
  return middleName;
}

public void setMiddleName(String middleName) {
  this.middleName = middleName;
}

@JsonIgnore
public String getLastName() {
  return lastName;
}

public void setLastName(String lastName) {
  this.lastName = lastName;
}

@JsonIgnore
public String getGender() {
  return gender;
}

public void setGender(String gender) {
  this.gender = gender;
}

@JsonIgnore
public String getBirthday() {
  return birthday;
}

public void setBirthday(String birthday) {
  this.birthday = birthday;
}

@JsonIgnore
public String getPhotoId() {
  return photoId;
}

public void setPhotoId(String photoId) {
  this.photoId = photoId;
}

public String getPassword() {
  return password;
}

public void setPassword(String password) {
  this.password = password;
}
}
