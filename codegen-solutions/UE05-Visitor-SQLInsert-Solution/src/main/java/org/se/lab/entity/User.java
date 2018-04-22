package org.se.lab.entity;

@Entity(table = "USERS", autoCommit = true)
public class User {
	@Column(column="name")
	public String username;
	public int age;
	public String gender;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
}
