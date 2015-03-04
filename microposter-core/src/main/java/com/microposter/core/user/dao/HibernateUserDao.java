package com.microposter.core.user.dao;

import com.microposter.core.user.domain.User;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HibernateUserDao implements UserDao{

@Autowired
private SessionFactory sessionFactory;

@SuppressWarnings("unchecked")
@Override
public void create(User user) {
  getSession().save(user);
}

@SuppressWarnings("unchecked")
@Override
public void delete(int uid) {
  User user = (User) sessionFactory.getCurrentSession().load(User.class, uid);
  if (user != null) {
    getSession().delete(user);
  }
}

@SuppressWarnings("unchecked")
@Override
public void update(User user) {
  getSession().update(user);
}

@SuppressWarnings("unchecked")
@Override
public User getById(int uid) {
  return (User) getSession().load(User.class, uid);
}

@SuppressWarnings("unchecked")
@Override
public List<User> getAll() {
  List<User> users = getSession().createCriteria(User.class).list();
  return users;
}

private Session getSession() {
  return sessionFactory.getCurrentSession();
}
}
