package com.microposter.core.user.dao;

import com.microposter.core.user.domain.User;

import java.util.List;

public interface UserDao {
void createUser(User user);
void deleteUser(int uid);
void updateUser(User user);
User getUserById(int uid);
List<User> getAllUsers();
}
