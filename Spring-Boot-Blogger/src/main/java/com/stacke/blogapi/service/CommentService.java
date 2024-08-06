package com.stacke.blogapi.service;

import com.stack.blogapi.model.Comment;
import com.stack.blogapi.payload.ApiResponse;
import com.stack.blogapi.payload.CommentRequest;
import com.stack.blogapi.payload.PagedResponse;
import com.stack.blogapi.security.UserPrincipal;

public interface CommentService {

	PagedResponse<Comment> getAllComments(Long postId, int page, int size);

	Comment addComment(CommentRequest commentRequest, Long postId, UserPrincipal currentUser);

	Comment getComment(Long postId, Long id);

	Comment updateComment(Long postId, Long id, CommentRequest commentRequest, UserPrincipal currentUser);

	ApiResponse deleteComment(Long postId, Long id, UserPrincipal currentUser);

}
