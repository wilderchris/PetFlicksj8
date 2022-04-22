package com.petflicks.app.Models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Board {

	@Id
	@Column
	private int boardId;
	@Column
	private String title;
	@Column
	private String description;
	@Column
	private String postId;
	public Board(int boardId, String title, String description, String postId) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.description = description;
		this.postId = postId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(boardId, description, postId, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		return boardId == other.boardId && Objects.equals(description, other.description)
				&& Objects.equals(postId, other.postId) && Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", description=" + description + ", postId=" + postId
				+ "]";
	}
	
	
	
	
	
}
