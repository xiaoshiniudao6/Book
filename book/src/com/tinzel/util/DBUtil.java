package com.tinzel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private final static String DRIVE = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/book";
	private final static String USER = "root";
	private final static String PWD = "1234";
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	/**
	 * 登录验证
	 * @param name
	 * @param pwd
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public  static boolean executeExecute(String sql,String name,String pwd)
			throws Exception {
		boolean bo = false;
		ps = createPreparedStatement(sql,name,pwd);
		rs = ps.executeQuery();
		bo = rs.next();
		close(con, ps, rs);
		return bo;
	}
	/**
	 * 增删改方法
	 * @param sql
	 * @param objects
	 * @return 返回是否增删改成功的bollean值
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean executeUpdate(String sql ,Object...objects) throws ClassNotFoundException, SQLException {
		boolean bo;
		ps = createPreparedStatement(sql,objects);
		bo = ps.executeUpdate()!=0?true:false;
		close(con, ps, null);
		return bo;
	}
	/**
	 * 查询方法
	 * @param sql
	 * @param objects
	 * @return rs
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ResultSet executeQuery(String sql ,Object...objects) throws ClassNotFoundException, SQLException{
		ps = createPreparedStatement(sql, objects);
		rs = ps.executeQuery();
		return rs;
	}
	/**
	 * 返回一个数据库对象方法
	 * @param sql
	 * @param objects
	 * @return ps
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static PreparedStatement createPreparedStatement(String sql ,Object...objects ) throws ClassNotFoundException, SQLException {
		Class.forName(DRIVE);
		con = DriverManager.getConnection(URL,USER,PWD);
		ps = con.prepareStatement(sql);
		for(int i = 0;i<objects.length;i++){
			ps.setObject(i+1, objects[i]);
		}
		return ps;
	}
	
	
	/**
	 * 用与增删改完成后关闭con ,ps,rs并重新置为空
	 * @param con
	 * @param ps
	 * @param rs
	 * @throws SQLException
	 */
	public static void close(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(con!=null){
			con.close();
			con = null;
		}
		if(ps!=null){
			ps.close();
			ps = null;
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
	}
	/**
	 * 用于查询完后关闭con,ps,rs并重新置为空
	 * @throws SQLException
	 */
	public static void close() throws SQLException {
		if(con!=null){
			con.close();
			con = null;
		}
		if(ps!=null){
			ps.close();
			ps = null;
		}
		if(rs!=null){
			rs.close();
			rs = null;
		}
	}
}
