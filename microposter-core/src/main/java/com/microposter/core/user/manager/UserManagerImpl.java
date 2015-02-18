package com.microposter.core.user.manager;


import com.microposter.core.user.dao.UserDao;
import com.microposter.core.user.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserManagerImpl implements UserManager {
private static final Log LOG = LogFactory.getLog(UserManagerImpl.class);

@Value("#{userDao}")
private UserDao userDao;

@Transactional
public void createUser(User user) {
  userDao.createUser(user);
}

@Transactional
public void deleteUser(int uid) {
  userDao.deleteUser(uid);
}

@Transactional
public void updateUser(User user) {
  userDao.updateUser(user);
}

@Transactional
public List<User> getAllUsers() {
  return userDao.getAllUsers();
}

@Transactional
public User getUserById(int uid) {
  return userDao.getUserById(uid);
}
}
