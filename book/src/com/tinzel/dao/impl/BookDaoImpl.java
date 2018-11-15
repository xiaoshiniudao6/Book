package com.tinzel.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tinzel.entity.Book;
import com.tinzel.entity.BookType;
import com.tinzel.it.dao.BookDao;
import com.tinzel.util.DBUtil;


public class BookDaoImpl implements BookDao{

	@Override
	public List queryBook(String bookTypeID) {
		String sql = "select * from book";
		if (bookTypeID!= null && !bookTypeID.equals("")) {
			sql = sql + " where bookTypeID = ?";
		}
		// TODO Auto-generated method stub
		
	    String sql2 = "select * from bookType where typeid = ?";
		List<Book> list = new ArrayList<Book>();
		try {
			ResultSet rs = null;
			if (bookTypeID!= null && !bookTypeID.equals("")) {
				rs = DBUtil.executeQuery(sql,Integer.parseInt(bookTypeID));
			}else{
				rs = DBUtil.executeQuery(sql);
			}
				
			while(rs.next()){
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setBookName(rs.getString("bookName"));
				book.setId(rs.getInt("id"));
				book.setPrice(rs.getFloat("price"));
			    ResultSet rs2 = DBUtil.executeQuery(sql2,rs.getInt("bookTypeID"));
			    BookType bookType = new BookType();
			    while(rs2.next()){
			    	
			    	bookType.setTypeName(rs2.getString("typeName"));
			    }
			    book.setBookType(bookType);
				list.add(book);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	 
		
	}

	@Override
	public Book getBook(int id) {
		Book book  = new Book();
		ResultSet rs = null;
		try {
			String sql = "select * from book where id = ?";
			String sql2 = "select * from bookType where typeid = ?";
			rs = DBUtil.executeQuery(sql,id);
			while (rs.next()) {
				book.setAuthor(rs.getString("author"));
				book.setBookName(rs.getString("bookName"));
				book.setId(rs.getInt("id"));
				book.setPrice(rs.getFloat("price"));
				ResultSet rs2 = DBUtil.executeQuery(sql2,rs.getInt("bookTypeID"));
			    BookType bookType = new BookType();
				while (rs2.next()) {
					bookType.setTypeid(rs2.getInt("typeid"));
					bookType.setTypeName(rs2.getString("typeName"));
					
				}
				  book.setBookType(bookType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public boolean updateBook(int id, String bookName, String author, double price, int bookTypeID) {
		// TODO Auto-generated method stub
		String sql = "update book set  bookTypeID = ? , bookName = ? , author = ? , price = ? where id = ?";
		boolean bo = false;
		try {
			bo = DBUtil.executeUpdate(sql,bookTypeID,bookName,author,price,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		boolean bo = false;
		String sql = "insert into book(bookName,author,price,bookTypeID) values (?,?,?,?)";
		try {
			bo = DBUtil.executeUpdate(sql,book.getBookName(),book.getAuthor(),book.getPrice(),book.getBookType().getTypeid());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bo;
	}
		
	}

