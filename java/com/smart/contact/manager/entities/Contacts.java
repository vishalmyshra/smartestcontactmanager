package com.smart.contact.manager.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONTACTS")
public class Contacts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contact_id")
	private int contactId;
	
	@Column(name = "contact_name")
	private String contactName;
	
	@Column(name = "contact_nickname")
	private String contactNickName;
	
	@Column(name = "contact_email")
	private String contactEmail;
	
	@Column(name = "contact_phone")
	private String contactPhone;
	
	@Column(name = "contact_description", length = 1000)
	private String contactDescription;
	
	@Column(name = "contact_work")
	private String contactWork;

	
	
	//mapping many to one to user to get user when we have a contact
	
	@ManyToOne
	private User user;
	
	@Override
	public String toString() {
		return "Contacts [contactId=" + contactId + ", contactName=" + contactName + ", contactNickName="
				+ contactNickName + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone
				+ ", contactDescription=" + contactDescription + ", contactWork=" + contactWork + "]";
	}

	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contacts(String contactName, String contactNickName, String contactEmail, String contactPhone,
			String contactDescription, String contactWork) {
		super();
		this.contactName = contactName;
		this.contactNickName = contactNickName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.contactDescription = contactDescription;
		this.contactWork = contactWork;
	}

	public Contacts(int contactId, String contactName, String contactNickName, String contactEmail, String contactPhone,
			String contactDescription, String contactWork) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactNickName = contactNickName;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
		this.contactDescription = contactDescription;
		this.contactWork = contactWork;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNickName() {
		return contactNickName;
	}

	public void setContactNickName(String contactNickName) {
		this.contactNickName = contactNickName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	public String getContactWork() {
		return contactWork;
	}

	public void setContactWork(String contactWork) {
		this.contactWork = contactWork;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
