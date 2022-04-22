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
public class Comment {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	@Column
	private long userId;
	@Column
	private long postId;
	@Column
	private String commentText;
	public Comment(long commentId, long userId, long postId, String commentText) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.postId = postId;
		this.commentText = commentText;
	}
	
	
	
	public long getCommentId() {
		return commentId;
	}



	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}



	public long getUserId() {
		return userId;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}



	public long getPostId() {
		return postId;
	}



	public void setPostId(long postId) {
		this.postId = postId;
	}



	public String getCommentText() {
		return commentText;
	}



	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}



	@Override
	public int hashCode() {
		return Objects.hash(commentId, commentText, postId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		return commentId == other.commentId && Objects.equals(commentText, other.commentText) && postId == other.postId
				&& userId == other.userId;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", userId=" + userId + ", postId=" + postId + ", commentText="
				+ commentText + "]";
	}
	
	
	
}
