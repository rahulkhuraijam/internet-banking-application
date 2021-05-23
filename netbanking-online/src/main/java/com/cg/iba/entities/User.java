package com.cg.iba.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Eisha
 * @version 1.0
 *
 */
@Entity
@Table(name="internet_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long customerId;
	private String password;
	private Role role;
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private Set<Account> account;

	public User(String password, Role role, long customerId) {
		super();
		this.customerId = customerId;

		this.password = password;
		this.role = role;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User() {
		super();
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}
	
	public User(Set<Account> account) {
		super();
		this.account = account;
	}

	@Override
	public String toString() {
		return "User [userId=" + customerId + ", password=" + password + ", role=" + role + "]";
	}

}
