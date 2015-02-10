package com.microposter.core.user.manager;


import com.microposter.core.user.dao.UserDao;
import com.microposter.core.user.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

public class UserManagerImpl implements UserManager {
private static final Log LOG = LogFactory.getLog(UserManagerImpl.class);

@Value("#{userDao}")
private UserDao userDao;

public void createUser(User user) {
  userDao.createUser(user);
}

public void deleteUser(int uid) {
  userDao.deleteUser(uid);
}

public void updateUser(User user) {
  userDao.updateUser(user);
}

public List<User> getAllUsers() {
  return userDao.getAllUsers();
}

public User getUserById(int uid) {
  return userDao.getUserById(uid);
}
}
