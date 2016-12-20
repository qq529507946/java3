package com.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer empno;
	private String ename;
	private Date hiredate;
	private Double sal;
	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	
	
}
