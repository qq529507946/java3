package com.mybatis.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.pojo.Emp;
import com.mybatis.util.Pager;

public class EmpDao {
private static SqlSessionFactory factory;
	
	static{
		
		try {
			String re="mybatis-config.xml";
			InputStream in=Resources.getResourceAsStream(re);
			factory=new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Pager<Emp> findPager(Integer pageno,Integer pagesize,String sort,String order,String ename,Date beginDate,Date endDate){
		SqlSession session=factory.openSession();
		Pager<Emp> pager=new Pager<Emp>();
		try{
		EmpMapper mapper=session.getMapper(EmpMapper.class);
		pager.setRows(mapper.findPager(pageno, pagesize, sort, order, ename, beginDate, endDate));
		pager.setTotal(mapper.findTotal(ename, beginDate, endDate));
		}finally{
			session.close();
		}
		return pager;
	}
	
	public int add(Emp emp){
		SqlSession session=factory.openSession();
		int count=0;
		try{
			EmpMapper mapper=session.getMapper(EmpMapper.class);
			count=mapper.add(emp);
			
			session.commit();
		}catch(Exception e){
			session.rollback();
		}finally{
			session.close();
		}
		return count;
	}
	
	public int modify(Emp emp){
		SqlSession session=factory.openSession();
		int count=0;
		try{
			EmpMapper mapper=session.getMapper(EmpMapper.class);
			count=mapper.modify(emp);
			
			session.commit();
		}finally{
			session.close();
		}
		return count;
	}
	
	public int remove(Integer empno){
		SqlSession session=factory.openSession();
		int count=0;
		try{
			EmpMapper mapper=session.getMapper(EmpMapper.class);
			count=mapper.remove(empno);
			
			session.commit();
		}finally{
			session.close();
		}
		return count;
	}
	
	public List<Emp> find(){
		SqlSession session=factory.openSession();
		List<Emp> emps=null;
		try {
			//emps=session.selectList("findAll");
			EmpMapper mapper=session.getMapper(EmpMapper.class);
			emps=mapper.find();
		} finally {
			session.close();
		}
		return emps;
	}
	
	public Emp findById(Integer empno){
		SqlSession session=factory.openSession();
		Emp emp=null;
		try {
			//emp=session.selectOne("findById", empno);
			EmpMapper mapper=session.getMapper(EmpMapper.class);
			emp=mapper.findById(empno);
		} finally {
			session.close();
		}
		return emp;
	}
}
