package com.stacke.blogapi.service;

import com.stack.blogapi.model.user.User;
import com.stack.blogapi.payload.ApiResponse;
import com.stack.blogapi.payload.InfoRequest;
import com.stack.blogapi.payload.UserIdentityAvailability;
import com.stack.blogapi.payload.UserProfile;
import com.stack.blogapi.payload.UserSummary;
import com.stack.blogapi.security.UserPrincipal;

public interface UserService {

	UserSummary getCurrentUser(UserPrincipal currentUser);

	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username, UserPrincipal currentUser);

	ApiResponse deleteUser(String username, UserPrincipal currentUser);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest);

}