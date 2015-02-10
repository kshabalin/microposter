package com.microposter.core.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.microposter.core.user.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;

public class MySQLUserDao implements UserDao {
private static final Log LOG = LogFactory.getLog(MySQLUserDao.class);
private DataSource dataSource;

private static String CREATE_USER_QUERY = "INSERT INTO users (uid, title, description) VALUES (?, ?, ?)";
private static String DELETE_USER_QUERY = "DELETE FROM users WHERE uid=?";
private static String UPDATE_USER_QUERY = "UPDATE users SET email=?, name=?, password=? WHERE uid=?";
private static String ALL_USERS_QUERY = "SELECT * FROM users";
private static String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE uid=?";

public void setDataSource(DataSource dataSource) {
  this.dataSource = dataSource;
}

public void createUser(User user) {
  String query = CREATE_USER_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, user.getEmail());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());
    ps.executeUpdate();
    ps.close();

  } catch (SQLException e) {
    throw new RuntimeException(e);

  } finally {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
      }
    }
  }
}

public void deleteUser(int uid) {
  String query = DELETE_USER_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, uid);
    ps.executeUpdate();
    ps.close();

  } catch (SQLException e) {
    throw new RuntimeException(e);

  } finally {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
      }
    }
  }
}

public User getUserById(int uid) {
  String query = GET_USER_BY_ID_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, uid);
    ResultSet rs = ps.executeQuery();
    User user = new User();
    if (rs.next()) {
      user.setId(rs.getInt("pid"));
      user.setEmail(rs.getString("email"));
      user.setName(rs.getString("name"));
    }
    rs.close();
    ps.close();
    return user;
  } catch (SQLException e) {
    throw new RuntimeException(e);
  } finally {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
      }
    }
  }
}

public void updateUser(User user) {
  String query = UPDATE_USER_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setString(1, user.getEmail());
    ps.setString(2, user.getName());
    ps.setString(3, user.getPassword());
    ps.setInt(4, user.getId());
    ps.executeUpdate();
    ps.close();

  } catch (SQLException e) {
    throw new RuntimeException(e);

  } finally {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
      }
    }
  }
}

public List<User> getAllUsers() {
  String query = ALL_USERS_QUERY;
  List<User> users = new ArrayList<User>();
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      User user = new User();
      user.setId(rs.getInt("uid"));
      user.setEmail(rs.getString("email"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
      users.add(user);
    }
    rs.close();
    ps.close();
    return users;
  } catch (SQLException e) {
    throw new RuntimeException(e);
  } finally {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
      }
    }
  }
}

}
