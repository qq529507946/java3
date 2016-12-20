package com.mybatis.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mybatis.dao.EmpDao;
import com.mybatis.pojo.Emp;
import com.mybatis.util.Pager;

public class EmpDaoTest {
	private EmpDao dao;
	
	@Test
	public void findPager(){
		Integer page=1;
		Integer rows=3;
		String sort="ename";
		String order="asc";
		
		String ename=null;
		Date beginDate=null;
		Date endDate=null;
		
		ename="%S%";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			beginDate=sdf.parse("1981-04-01");
			endDate=sdf.parse("1981-12-31");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Integer pageno=(page-1)*rows;
		Integer pagesize=page*rows;
		
		Pager<Emp> pager=dao.findPager(pageno, pagesize, sort, order, ename, beginDate, endDate);
		System.out.println("记录总数:"+pager.getTotal());
		for (Emp emp: pager.getRows()) {
			System.out.println(emp.getEmpno()+" "+emp.getEname()+" "+emp.getHiredate()+" "+emp.getSal());
		}
		
	}

	@Test
	public void add() {
		Emp emp=new Emp();
		//emp.setEmpno(9991);
		emp.setEname("尼古拉斯");
		emp.setHiredate(new Date());
		emp.setSal(10000.00);
		dao.add(emp);
	}
	
	@Test
	public void modify(){
		Emp emp=new Emp();
		emp.setEmpno(9991);
		emp.setEname("尼古拉斯");
		emp.setHiredate(new Date());
		emp.setSal(100.00);
		dao.modify(emp);
		
	}
	
	@Test
	public void remove(){
		dao.remove(9991);
	}
	
	@Test
	public void findById() {
		Emp emp=dao.findById(7788);
		System.out.println(emp.getEmpno()+" "+emp.getEname()+" "+emp.getHiredate()+" "+emp.getSal());
	}
	
	@Test
	public void find(){
		for (Emp emp : dao.find()) {
			System.out.println(emp.getEmpno()+" "+emp.getEname()+" "+emp.getHiredate()+" "+emp.getSal());
		}
	}
	@Before
	public void init(){
		dao=new EmpDao();
	}
}
