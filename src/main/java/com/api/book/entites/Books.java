package com.api.book.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="book_id")
	private int id;
	
	@Column(name="book_name")
	private String name;
	
	@Column(name="book_title")
	private String title;
	
	public Books(int id, String name, String title) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
	}

	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", title=" + title + "]";
	}
	

}
