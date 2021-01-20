package com.demo.mobile.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.demo.mobile.dto.UserStatus;

@Entity
@Table(name = "user_status")
public class UStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long id;

	@Enumerated(EnumType.STRING)
	private UserStatus name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserStatus getName() {
		return name;
	}

	public void setName(UserStatus name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UStatus [id=" + id + ", name=" + name + "]";
	}

}
