package model;

import java.io.Serializable;

public class User implements Serializable {
	
	private String userId;

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public IRole getUserRole() {
		return userRole;
	}

	private String password;
	private IRole userRole;

	public User(String userId, String password, IRole userRole) {
		this.userId = userId;
		this.password = password;
		this.userRole = userRole;

	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password
				+ ", userRole=" + userRole + "]";
	}
	

}
