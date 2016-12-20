package com.struts2.pojo;

import java.util.Date;

/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp implements java.io.Serializable {
  private static final long serialVersionUID = 1L;
  private Integer empno;
  private String ename;
  private String job;
  private Integer mgr;
  private Date hiredate;
  private Double sal;
  private Double comm;
  private Integer deptno;

  public Emp() {
  }

  public Integer getEmpno() {
    return this.empno;
  }

  public void setEmpno(Integer empno) {
    this.empno = empno;
  }

  public String getEname() {
    return this.ename;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public String getJob() {
    return this.job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public Integer getMgr() {
    return this.mgr;
  }

  public void setMgr(Integer mgr) {
    this.mgr = mgr;
  }

  public Date getHiredate() {
    return this.hiredate;
  }

  public void setHiredate(Date hiredate) {
    this.hiredate = hiredate;
  }

  public Double getSal() {
    return this.sal;
  }

  public void setSal(Double sal) {
    this.sal = sal;
  }

  public Double getComm() {
    return this.comm;
  }

  public void setComm(Double comm) {
    this.comm = comm;
  }

  public Integer getDeptno() {
    return this.deptno;
  }

  public void setDeptno(Integer deptno) {
    this.deptno = deptno;
  }

}