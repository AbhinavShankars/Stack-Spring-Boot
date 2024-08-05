package com.stack.blogapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserIdentityAvailability {
	public UserIdentityAvailability(Boolean isAvailable) {
		// TODO Auto-generated constructor stub
	}

	private Boolean available;

}
