package com.microposter.core.post.dao;

import com.microposter.core.post.domain.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;

public class MySQLPostDao implements PostDao {
private static final Log LOG = LogFactory.getLog(MySQLPostDao.class);
private DataSource dataSource;

private static String CREATE_POST_QUERY = "INSERT INTO posts (uid, title, description) VALUES (?, ?, ?)";
private static String DELETE_POST_QUERY = "DELETE FROM posts WHERE pid=?";
private static String ALL_POSTS_QUERY = "SELECT * FROM posts";
private static String ALL_POST_BY_USER_QUERY = "SELECT * FROM CUSTOMER WHERE uid = ?";
private static String GET_POST_QUERY = "SELECT * FROM CUSTOMER WHERE pid = ?";

public void setDataSource(DataSource dataSource) {
  this.dataSource = dataSource;
}

@Override
public int create(Post post) {
  String query = CREATE_POST_QUERY;
  Connection conn = null;
  int pid = -1;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, post.getUid());
    ps.setString(2, post.getTitle());
    ps.setString(3, post.getDesc());
    pid = ps.executeUpdate();
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
  return pid;
}

@Override
public void delete(int pid) {
  String query = DELETE_POST_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, pid);
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

@Override
public List<Post> getAll() {
  String query = ALL_POSTS_QUERY;
  List<Post> posts = new ArrayList<Post>();
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      Post post = new Post();
      post.setId(rs.getInt("pid"));
      post.setTitle(rs.getString("title"));
      post.setDesc(rs.getString("description"));
      posts.add(post);
    }
    rs.close();
    ps.close();
    return posts;
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

@Override
public List<Post> getByUser(int uid) {
  String query = ALL_POST_BY_USER_QUERY;
  List<Post> posts = new ArrayList<Post>();
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, uid);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
      Post post = new Post();
      post.setId(rs.getInt("pid"));
      post.setTitle(rs.getString("title"));
      post.setDesc(rs.getString("description"));
      posts.add(post);
    }
    rs.close();
    ps.close();
    return posts;
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

@Override
public Post getById(int pid) {
  String query = GET_POST_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, pid);
    ResultSet rs = ps.executeQuery();
    Post post = new Post();
    if (rs.next()) {
      post.setId(rs.getInt("pid"));
      post.setTitle(rs.getString("title"));
      post.setDesc(rs.getString("description"));
    }
    rs.close();
    ps.close();
    return post;
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
