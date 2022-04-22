package com.petflicks.app.Models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Follow {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long followId;//userid?
	@Column
	private long userId;// who was followed nullable
	@Column
	private long petId;// or pet followed  nullable
	public Follow(long followId, long userId, long petId) {
		super();
		this.followId = followId;
		this.userId = userId;
		this.petId = petId;
	}
	public long getFollowId() {
		return followId;
	}
	public void setFollowId(long followId) {
		this.followId = followId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(followId, petId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follow other = (Follow) obj;
		return followId == other.followId && petId == other.petId && userId == other.userId;
	}
	@Override
	public String toString() {
		return "Follow [followId=" + followId + ", userId=" + userId + ", petId=" + petId + "]";
	}
	
	
	
}
