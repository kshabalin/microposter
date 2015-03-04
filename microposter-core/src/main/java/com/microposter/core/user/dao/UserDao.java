package com.microposter.core.user.dao;

import com.microposter.core.user.domain.User;

import java.util.List;

public interface UserDao {
void create(User user);
void delete(int uid);
void update(User user);
User getById(int uid);
List<User> getAll();
}
