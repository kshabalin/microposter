package com.microposter.core.comment.manager;


import com.microposter.core.comment.domain.Comment;

import java.util.List;

public interface CommentManager {
void createComment(Comment comment);
void deleteComment(int cid);
List<Comment> getAllCommentsByUser(int uid);
List<Comment> getAllCommentsByPost(int pid);
}
