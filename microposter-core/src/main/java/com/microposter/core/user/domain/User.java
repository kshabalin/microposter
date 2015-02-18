package com.microposter.core.user.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

@Id
@Column(name = "uid")
@GeneratedValue
private int id;

@Column(name = "email")
private String email;

@Column(name = "name")
private String name;

@Transient
private String firstName;

@Transient
private String middleName;

@Transient
private String lastName;

@Transient
private String gender;

@Transient
private String birthday;

@Transient
private String photoId;

@Column(name = "password")
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
