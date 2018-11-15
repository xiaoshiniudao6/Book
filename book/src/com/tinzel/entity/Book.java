package com.tinzel.entity;

public class Book {
	private int id ;
	private String bookName;
	private String author;
	private double price;
	private BookType bookType;

	public Book() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public double getPrice() {
		return price;
	}
	public Book(String bookName, String author, double price, BookType bookType) {
		super();
		
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.bookType = bookType;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}
