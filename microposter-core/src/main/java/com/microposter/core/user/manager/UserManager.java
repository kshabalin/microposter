package com.microposter.core.user.manager;

import com.microposter.core.user.domain.User;

import java.util.List;

public interface UserManager {
void create(User user);
void delete(int uid);
void update(User user);
List<User> getAll();
User getById(int uid);
}
