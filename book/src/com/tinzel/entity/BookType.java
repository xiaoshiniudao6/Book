package com.tinzel.entity;

public class BookType {
	private int typeid;
	private String typeName;
	public BookType(int typeid, String typeName) {
		super();
		this.typeid = typeid;
		this.typeName = typeName;
	}
	public BookType() {
		super();
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
