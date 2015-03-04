package com.microposter.core.comment.dao;

import com.microposter.core.comment.domain.Comment;

import java.util.List;

public interface CommentDao {
void create(Comment comment);
void delete(int cid);
List<Comment> getAllByUser(int uid);
List<Comment> getAllByPost(int pid);
}
