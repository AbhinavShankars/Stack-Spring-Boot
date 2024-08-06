package com.stack.blogapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

import com.stack.blogapi.model.user.Address;
import com.stack.blogapi.model.user.Company;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfile {
	public UserProfile(Long id2, String username2, String firstName2, String lastName2, Object createdAt, String email2,
			Address address2, String phone2, String website2, Company company2, Long postCount2) {
		// TODO Auto-generated constructor stub
	}
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private Instant joinedAt;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	private Long postCount;
}
