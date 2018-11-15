package com.tinzel.it.dao;

import java.util.List;

import com.tinzel.entity.Book;

public interface BookDao {
	public List queryBook(String typeId);
	public Book getBook (int id);
	public boolean updateBook(int id,String bookName,String author,double price,int bookTypeID);
	public boolean addBook(Book book);
			
}
