package com.smart.contact.manager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	@NotBlank(message = "Username cannot be blank")
	@Size(min = 3,max = 10, message = "username must be between 3 to 10 characters")
	private String userName;
	
	@Column(unique = true, name = "user_email")
	private String userEmail;
	
	@Column(name = "user_password")
	private String userPassword;
	
	@Column(name = "user_profile_image_url")
	private String profileImageUrl;
	
	@Column(name = "user_enabled")
	private boolean isEnabled;
	
	@Column(name = "user_about")
	private String userAbout;
	
	@Column(name = "user_role")
	private String userRole;
	
	
	//mapping user to contacts with oneToMany mapping
	
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "user")
		private List<Contacts> contacts = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userEmail, String userPassword, String profileImageUrl, boolean isEnabled,
			String userAbout, String userRole) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.profileImageUrl = profileImageUrl;
		this.isEnabled = isEnabled;
		this.userAbout = userAbout;
		this.userRole = userRole;
	}

	public User(int userId, String userName, String userEmail, String userPassword, String profileImageUrl,
			boolean isEnabled, String userAbout, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.profileImageUrl = profileImageUrl;
		this.isEnabled = isEnabled;
		this.userAbout = userAbout;
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getUserAbout() {
		return userAbout;
	}

	public void setUserAbout(String userAbout) {
		this.userAbout = userAbout;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "Contacts [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", profileImageUrl=" + profileImageUrl + ", isEnabled=" + isEnabled + ", userAbout="
				+ userAbout + ", userRole=" + userRole + "]";
	}
	

	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	}

}
