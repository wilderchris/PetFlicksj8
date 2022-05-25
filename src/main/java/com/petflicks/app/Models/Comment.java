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
	private int commentId;
	@Column
	private int userId;
	@Column
	private int postId;
	@Column
	private String commentText;
	
	
	
	public Comment() {
		super();
	}



	public Comment(int commentId, int userId, int postId, String commentText) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.postId = postId;
		this.commentText = commentText;
	}
	
	
	
	public int getCommentId() {
		return commentId;
	}



	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getPostId() {
		return postId;
	}



	public void setPostId(int postId) {
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
