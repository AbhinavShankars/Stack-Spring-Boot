package com.stacke.blogapi.service;

import com.stack.blogapi.model.Post;
import com.stack.blogapi.payload.ApiResponse;
import com.stack.blogapi.payload.PagedResponse;
import com.stack.blogapi.payload.PostRequest;
import com.stack.blogapi.payload.PostResponse;
import com.stack.blogapi.security.UserPrincipal;

public interface PostService {

	PagedResponse<Post> getAllPosts(int page, int size);

	PagedResponse<Post> getPostsByCreatedBy(String username, int page, int size);

	PagedResponse<Post> getPostsByCategory(Long id, int page, int size);

	PagedResponse<Post> getPostsByTag(Long id, int page, int size);

	Post updatePost(Long id, PostRequest newPostRequest, UserPrincipal currentUser);

	ApiResponse deletePost(Long id, UserPrincipal currentUser);

	PostResponse addPost(PostRequest postRequest, UserPrincipal currentUser);

	Post getPost(Long id);

}
