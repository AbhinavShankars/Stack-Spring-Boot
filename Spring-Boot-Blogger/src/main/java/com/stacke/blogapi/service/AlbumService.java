package com.stacke.blogapi.service;

import com.stack.blogapi.model.Album;
import com.stack.blogapi.payload.AlbumResponse;
import com.stack.blogapi.payload.ApiResponse;
import com.stack.blogapi.payload.PagedResponse;
import com.stack.blogapi.payload.request.AlbumRequest;
import com.stack.blogapi.security.UserPrincipal;

import org.springframework.http.ResponseEntity;

public interface AlbumService {

	PagedResponse<AlbumResponse> getAllAlbums(int page, int size);

	ResponseEntity<Album> addAlbum(AlbumRequest albumRequest, UserPrincipal currentUser);

	ResponseEntity<Album> getAlbum(Long id);

	ResponseEntity<AlbumResponse> updateAlbum(Long id, AlbumRequest newAlbum, UserPrincipal currentUser);

	ResponseEntity<ApiResponse> deleteAlbum(Long id, UserPrincipal currentUser);

	PagedResponse<Album> getUserAlbums(String username, int page, int size);

}
