package com.microposter.core.user.dao;

import com.microposter.core.user.domain.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HibernateUserDao implements UserDao{

@Autowired
private SessionFactory sessionFactory;

public void createUser(User user) {
  sessionFactory.getCurrentSession().save(user);
}

public void deleteUser(int uid) {
  User user = (User) sessionFactory.getCurrentSession().load(User.class, uid);
  if (user != null) {
    sessionFactory.getCurrentSession().delete(user);
  }
}

public void updateUser(User user) {
  sessionFactory.getCurrentSession().update(user);
}

public User getUserById(int uid) {
  return (User) sessionFactory.getCurrentSession().load(User.class, uid);
}

public List<User> getAllUsers() {
  List<User> users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
  return users;
}
}
