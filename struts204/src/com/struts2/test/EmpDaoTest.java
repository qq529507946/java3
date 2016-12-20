package com.struts2.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.struts2.dao.EmpDao;
import com.struts2.pojo.Emp;

public class EmpDaoTest {
  private EmpDao empDao;

  @Test
  public void find() {
    // 条件参数
    String ename = null;
    Date beginDate = null;
    Date endDate = null;

    ename = "s";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      beginDate = sdf.parse("1981-03-01");
      endDate = sdf.parse("1981-12-31");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    List<Emp> emps = empDao.find(ename, beginDate, endDate);
    for (Emp emp : emps) {
      System.out.println(emp.getEname() + " " + emp.getSal() + " " + emp.getHiredate());
    }
  }

  @Test
  public void add() {
    Emp emp = new Emp();
    emp.setEmpno(9995);
    emp.setEname("阿紫");
    emp.setSal(9999d);
    emp.setHiredate(new Date());

    empDao.add(emp);
  }

  @Before
  public void init() {
    empDao = new EmpDao();
  }
}
