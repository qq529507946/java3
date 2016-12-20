package com.mybatis.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.mybatis.pojo.Emp;

public interface EmpMapper {
	
	List<Emp> findPager(
			@Param("pageno")Integer pageno,
			@Param("pagesize")Integer pagesize,
			@Param("sort")String sort,
			@Param("order")String order,
			@Param("ename")String ename,
			@Param("beginDate")Date beginDate,
			@Param("endDate")Date endDate);
	
	int findTotal(
			@Param("ename")String ename,
			@Param("beginDate")Date beginDate,
			@Param("endDate")Date endDate);
	
	@Select("select EMPNO,ENAME,HIREDATE,SAL from EMP where EMPNO=#{empno}")
	Emp findById(Integer empno);
	
	@Select("select EMPNO,ENAME,HIREDATE,SAL from EMP")
	List<Emp> find();
	
	@Insert("insert into EMP( EMPNO,ENAME,HIREDATE,SAL) "
		+" values(#{empno},#{ename,jdbcType=VARCHAR},"
		+" #{hiredate,jdbcType=DATE},#{sal,jdbcType=DOUBLE})")
	@SelectKey(statement="select SEQ_EMP.NEXTVAL from DUAL",
	keyProperty="empno",resultType=int.class,before=true)
	int add(Emp emp);
	
	@Update("update EMP set ENAME=#{ename,jdbcType=VARCHAR},"
			+" HIREDATE=#{hiredate,jdbcType=VARCHAR},"
			+" SAL=#{sal,jdbcType=DOUBLE}where EMPNO=#{empno}")
	int modify(Emp emp);
	
	@Delete("delete from EMP where EMPNO=#{empno}")
	int remove(Integer empno);
}
