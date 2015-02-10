package com.microposter.core.user.manager;

import com.microposter.core.user.domain.User;

import java.util.List;

public interface UserManager {
void createUser(User user);
void deleteUser(int uid);
void updateUser(User user);
List<User> getAllUsers();
User getUserById(int uid);
}
