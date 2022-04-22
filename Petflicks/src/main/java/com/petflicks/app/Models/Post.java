package com.petflicks.app.Models;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Post {

	@Id
	@Column
	private long postId;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private long videoId;
	@Column
	private LocalDateTime tdPosted;
	public Post(long postId, String title, String description, long videoId, LocalDateTime tdPosted) {
		super();
		this.postId = postId;
		this.title = title;
		this.description = description;
		this.videoId = videoId;
		this.tdPosted = tdPosted;
	}
	public long getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public LocalDateTime getTdPosted() {
		return tdPosted;
	}
	public void setTdPosted(LocalDateTime tdPosted) {
		this.tdPosted = tdPosted;
	}
	@Override
	public int hashCode() {
		return Objects.hash(description, postId, tdPosted, title, videoId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(description, other.description) && postId == other.postId
				&& Objects.equals(tdPosted, other.tdPosted) && Objects.equals(title, other.title)
				&& videoId == other.videoId;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", description=" + description + ", videoId=" + videoId
				+ ", tdPosted=" + tdPosted + "]";
	}
	
	
}
