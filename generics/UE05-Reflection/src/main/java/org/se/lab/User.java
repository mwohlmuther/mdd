package org.se.lab;

public class User {

	protected int id;
	private String username;
	private String password;

	public User(int id, String username, String password) {
		setId(id);
		setUsername(username);
		setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username == null)
			throw new NullPointerException("username");
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		if (password == null)
			throw new NullPointerException("password");
		this.password = password;
	}

	public String toString() {
		return getId() + "," + getUsername() + "," + getPassword();
	}
}
