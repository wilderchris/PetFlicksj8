package com.petflicks.app.Models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Pet {

	@Id
	@Column(name="pet_id")
	private int petId;
	@Column(name="pet_pic_url")
	private String petPicURL;
	@Column(name="name")
	private String name;
	@Column(name="age")
	private int age;
	@Column(name="description")
	private String description;
	@Column(name="breed")
	private String breed;
	@Column(name="user_id")
	private int userId;
	
	
	
	public Pet() {
		super();
	}
	public Pet(int petId, String petPicURL, String name, int age, String description, String breed, int userId) {
		super();
		this.petId = petId;
		this.petPicURL = petPicURL;
		this.name = name;
		this.age = age;
		this.description = description;
		this.breed = breed;
		this.userId = userId;
	}
	public int getPetId() {
		return petId;
	}
	public void setPetId(int petId) {
		this.petId = petId;
	}
	public String getPetPicURL() {
		return petPicURL;
	}
	public void setPetPicURL(String petPicURL) {
		this.petPicURL = petPicURL;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, breed, description, name, petId, petPicURL, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return age == other.age && Objects.equals(breed, other.breed) && Objects.equals(description, other.description)
				&& Objects.equals(name, other.name) && petId == other.petId
				&& Objects.equals(petPicURL, other.petPicURL) && userId == other.userId;
	}
	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", petPicURL=" + petPicURL + ", name=" + name + ", age=" + age + ", description="
				+ description + ", breed=" + breed + ", userId=" + userId + "]";
	}
	
	
	
	
	
	
	
}
