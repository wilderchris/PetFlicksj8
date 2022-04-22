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
public class Follower {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long followerId;//userid?
	@Column
	private long userId;// who was followed nullable
	@Column
	private long petId;// or pet followed  nullable
	public Follower(long followerId, long userId, long petId) {
		super();
		this.followerId = followerId;
		this.userId = userId;
		this.petId = petId;
	}
	public long getFollowId() {
		return followerId;
	}
	public void setFollowId(long followId) {
		this.followerId = followId;
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
		return Objects.hash(followerId, petId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follower other = (Follower) obj;
		return followerId == other.followerId && petId == other.petId && userId == other.userId;
	}
	@Override
	public String toString() {
		return "Follower [followerId=" + followerId + ", userId=" + userId + ", petId=" + petId + "]";
	}
	
	
	
}
