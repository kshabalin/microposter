package com.microposter.core.comment.manager;


import com.microposter.core.comment.domain.Comment;

import java.util.List;

public interface CommentManager {
void create(Comment comment);
void delete(int cid);
List<Comment> getAllByUser(int uid);
List<Comment> getAllByPost(int pid);
}
