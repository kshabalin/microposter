package com.microposter.server.api.controllers;

import com.microposter.core.user.domain.User;
import com.microposter.core.user.manager.UserManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
private static final Log LOG = LogFactory.getLog(UsersController.class);

@Autowired
private UserManager userManager;

@Transactional
@RequestMapping(method = RequestMethod.POST)
@ResponseBody
public User create(@RequestBody User user) {
  try {
    userManager.create(user);
    return user;
  } catch (Exception e) {
    LOG.error("Failed to create the user, %s", e);
    throw new RuntimeException(e);
  }
}

@Transactional(readOnly = true)
@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
@ResponseBody
public User getById(@PathVariable("uid") int uid) {
  try {
    User user = userManager.getById(uid);
    return user;
  } catch (Exception e) {
    LOG.error("Failed to get the user, %s", e);
    throw new RuntimeException(e);
  }
}

@Transactional(readOnly = true)
@RequestMapping(method = RequestMethod.GET)
@ResponseBody
public List<User> getAll() {
  try {
    List<User> users = userManager.getAll();
    return users;
  } catch (Exception e) {
    LOG.error("Failed to get all users, %s", e);
    throw new RuntimeException(e);
  }
}

@Transactional(readOnly = true)
@RequestMapping(value = "/{uid}", method = RequestMethod.DELETE)
public void delete(@PathVariable("uid") String uid) {
  try {
    userManager.delete(Integer.parseInt(uid));
  } catch (Exception e) {
    LOG.error("Failed to delete the user, %s", e);
    throw new RuntimeException(e);
  }
}
}
