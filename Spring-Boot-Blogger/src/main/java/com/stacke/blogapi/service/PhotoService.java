package com.stacke.blogapi.service;

import com.stack.blogapi.payload.ApiResponse;
import com.stack.blogapi.payload.PagedResponse;
import com.stack.blogapi.payload.PhotoRequest;
import com.stack.blogapi.payload.PhotoResponse;
import com.stack.blogapi.security.UserPrincipal;

public interface PhotoService {

	PagedResponse<PhotoResponse> getAllPhotos(int page, int size);

	PhotoResponse getPhoto(Long id);

	PhotoResponse updatePhoto(Long id, PhotoRequest photoRequest, UserPrincipal currentUser);

	PhotoResponse addPhoto(PhotoRequest photoRequest, UserPrincipal currentUser);

	ApiResponse deletePhoto(Long id, UserPrincipal currentUser);

	PagedResponse<PhotoResponse> getAllPhotosByAlbum(Long albumId, int page, int size);

}