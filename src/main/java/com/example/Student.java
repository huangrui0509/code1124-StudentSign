package com.example;

public class Student {

	private int id;
	private String name;
	//签到
	private boolean sign;
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
	public boolean isSign() {
		return sign;
	}
	public void setSign(boolean sign) {
		this.sign = sign;
	}
	public Student(int id, String name, boolean sign) {
		super();
		this.id = id;
		this.name = name;
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sign=" + sign + "]";
	}
	
	
	
	
}
