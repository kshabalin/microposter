package com.microposter.core.user.manager;


import com.microposter.core.user.dao.UserDao;
import com.microposter.core.user.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userManager")
public class UserManagerImpl implements UserManager {
private static final Log LOG = LogFactory.getLog(UserManagerImpl.class);

@Autowired
private UserDao userDao;

@Transactional
@Override
public void create(User user) {
  userDao.create(user);
}

@Transactional
@Override
public void delete(int uid) {
  userDao.delete(uid);
}

@Transactional(readOnly = true)
@Override
public void update(User user) {
  userDao.update(user);
}

@Transactional(readOnly = true)
@Override
public List<User> getAll() {
  return userDao.getAll();
}

@Transactional(readOnly = true)
@Override
public User getById(int uid) {
  return userDao.getById(uid);
}
}
