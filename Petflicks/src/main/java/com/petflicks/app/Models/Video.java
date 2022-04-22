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
public class Video {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long videoId;
	
	@Column
	private String videoURL;
	@Column
	private long userId;
	@Column
	private String description;
	@Column
	private boolean like;
	
	public Video(long videoId, String videoURL, long userId, String description, boolean like) {
		super();
		this.videoId = videoId;
		this.videoURL = videoURL;
		this.userId = userId;
		this.description = description;
		this.like = like;
	}
	
	
	public long getVideoId() {
		return videoId;
	}


	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}


	public String getVideoURL() {
		return videoURL;
	}


	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isLike() {
		return like;
	}


	public void setLike(boolean like) {
		this.like = like;
	}


	@Override
	public int hashCode() {
		return Objects.hash(description, like, userId, videoId, videoURL);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Video other = (Video) obj;
		return Objects.equals(description, other.description) && like == other.like && userId == other.userId
				&& videoId == other.videoId && Objects.equals(videoURL, other.videoURL);
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", videoURL=" + videoURL + ", userId=" + userId + ", description="
				+ description + ", like=" + like + "]";
	}
	
	
	
}
