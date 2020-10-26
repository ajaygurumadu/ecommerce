package com.loginreg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
		private int id;
	@Column(name="email")
		private String email;
	@Column(name="username")
		private String userName;
	@Column(name="passwords")
		private String password;
	@Column(name="mobile")
		private int mobile;
		
		public User()
		{
			
		}
		
		
		public User(int id, String email, String userName, String password, int mobile) {
			super();
			this.id = id;
			this.email = email;
			this.userName = userName;
			this.password = password;
			this.mobile = mobile;
		}


		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

		public int getMobile() {
			return mobile;
		}

		public void setMobile(int mobile) {
			this.mobile = mobile;
		}
		 
}
