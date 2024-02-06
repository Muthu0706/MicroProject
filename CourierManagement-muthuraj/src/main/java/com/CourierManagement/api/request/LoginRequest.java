package com.CourierManagement.api.request;

import com.CourierManagement.api.entity.User;

public class LoginRequest {

    private String username;
    private User usernamee;
    public User getUsernamee() {
		return usernamee;
	}

	public void setUsernamee(User usernamee) {
		this.usernamee = usernamee;
	}

	private String password;

    

    public LoginRequest() {
       
    }

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
