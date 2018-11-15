package com.tinzel.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.tinzel.dao.impl.BookDaoImpl;
import com.tinzel.dao.impl.BookTypeDaoImpl;
import com.tinzel.entity.Book;
import com.tinzel.entity.BookType;
import com.tinzel.it.dao.BookDao;
import com.tinzel.it.dao.BookTypeDao;



/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	BookDao bookDao = new BookDaoImpl();
	BookTypeDao bookTypeDao = new BookTypeDaoImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8"); // 设置格式编码
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		if ("update".equals(action)) {
			// 执行查询操作
			update(request, response);
	    }else if("get".equals(action)){
	    	get(request, response);
	    }else if("query".equals(action)){
	    	query(request, response);
	    }else if("add".equals(action)){
	    	add(request, response);
	    }else if("SetListType".equals(action)){
	    	SetListType(request, response);
	    }
       
}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、接收参数
		String bookName = request.getParameter("bookName");
		//类型
		//String typeName = request.getParameter("typeName");
		String bookTypeID1 = request.getParameter("bookTypeID");
		int bookTypeID = Integer.parseInt(bookTypeID1.trim());
		String author = request.getParameter("author");
		String price1 = request.getParameter("price");
		double price = Double.parseDouble(price1);
		String ID = request.getParameter("id");
		int id	= Integer.parseInt(ID.trim());
		// 2、调用DAO方法
	
		boolean bo = bookDao.updateBook(id, bookName, author, price, bookTypeID);
		if (bo == false) {
			request.setAttribute("error", "修改失败");
		}
		// 3、回到列表页面
		query(request, response);
	}
	
	protected void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookTypeID = request.getParameter("typeid");
		
		List list = bookDao.queryBook(bookTypeID);
		request.setAttribute("list", list);
		request.getRequestDispatcher("main.jsp").forward(request,response);
	}
	
	//取出一个商品
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		// 调用dao查询出商品对象
		Book book = new Book();
		  book = bookDao.getBook(Integer.parseInt(id));
		// 放入作用域
		request.setAttribute("book", book);
		
		
		request.getRequestDispatcher("updateBook.jsp").forward(request,
				response);
	}
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bookName = request.getParameter("bookName");
		//类型
		String typeid1 = request.getParameter("typeid");
	
		int typeid = Integer.parseInt(typeid1);
		String author = request.getParameter("author");
		String price1 = request.getParameter("price");
		double price = Double.parseDouble(price1);
	    Book book = new Book(bookName, author, price,new BookType(typeid,null));
	    boolean bo = bookDao.addBook(book);
	    if(bo){
	    	System.out.println("添加成功");
	    }
		// 3、回到列表页面
		query(request, response);
	}
	
	protected void SetListType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		List listType = bookTypeDao.query();
		session.setAttribute("listType",listType );
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
