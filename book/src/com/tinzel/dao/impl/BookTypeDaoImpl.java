package com.tinzel.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tinzel.entity.BookType;
import com.tinzel.it.dao.BookTypeDao;
import com.tinzel.util.DBUtil;

public class BookTypeDaoImpl implements BookTypeDao {
	@Override
	public List query(){
		String sql  = "select * from bookType";
		List<BookType> list = new ArrayList<BookType>();
       		try {
			ResultSet rs = DBUtil.executeQuery(sql);
			while(rs.next()){
				 BookType bookType  = new BookType();
				 bookType.setTypeid(rs.getInt("typeid"));
				 bookType.setTypeName(rs.getString("typeName"));
				 list.add(bookType);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
}


