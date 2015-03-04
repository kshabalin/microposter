package com.microposter.core.comment.dao;

import com.microposter.core.comment.domain.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.sql.DataSource;

public class MySQLCommentDao implements CommentDao {
private static final Log LOG = LogFactory.getLog(MySQLCommentDao.class);
private DataSource dataSource;

private static String CREATE_COMMENT_QUERY = "INSERT INTO comments (uid, pid, title, description) VALUES (?, ?, ?, ?)";
private static String DELETE_COMMENT_QUERY = "DELETE FROM comments WHERE cid=?";
private static String ALL_COMMENTS_BY_POST_QUERY = "SELECT * FROM comments WHERE pid = ?";
private static String ALL_COMMENTS_BY_USER_QUERY = "SELECT * FROM comments WHERE uid = ?";

public void setDataSource(DataSource dataSource) {
  this.dataSource = dataSource;
}

@Override
public void create(Comment comment) {
  String query = CREATE_COMMENT_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, comment.getUid());
    ps.setInt(2, comment.getPid());
    ps.setString(3, comment.getTitle());
    ps.setString(4, comment.getDesc());
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
public void delete(int cid) {
  String query = DELETE_COMMENT_QUERY;
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, cid);
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
public List<Comment> getAllByUser(int uid) {
  String query = ALL_COMMENTS_BY_USER_QUERY;
  List<Comment> comments = new ArrayList<Comment>();
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, uid);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      Comment comment = new Comment();
      comment.setId(rs.getInt("cid"));
      comment.setUid(rs.getInt("uid"));
      comment.setPid(rs.getInt("pid"));
      comment.setTitle(rs.getString("title"));
      comment.setDesc(rs.getString("description"));
      comments.add(comment);
    }
    rs.close();
    ps.close();
    return comments;
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
public List<Comment> getAllByPost(int pid) {
  String query = ALL_COMMENTS_BY_POST_QUERY;
  List<Comment> comments = new ArrayList<Comment>();
  Connection conn = null;

  try {
    conn = dataSource.getConnection();
    PreparedStatement ps = conn.prepareStatement(query);
    ps.setInt(1, pid);
    ResultSet rs = ps.executeQuery();
    while (rs.next()) {
      Comment comment = new Comment();
      comment.setId(rs.getInt("cid"));
      comment.setUid(rs.getInt("uid"));
      comment.setPid(rs.getInt("pid"));
      comment.setTitle(rs.getString("title"));
      comment.setDesc(rs.getString("description"));
      comments.add(comment);
    }
    rs.close();
    ps.close();
    return comments;
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
