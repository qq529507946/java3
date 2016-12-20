package com.struts2.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.struts2.dao.EmpDao;
import com.struts2.pojo.Emp;

public class EmpAction extends ActionSupport {
  private static final long serialVersionUID = 1L;
  private Emp emp;
  private String ename;
  private String sbeginDate;
  private String sendDate;
  private List<Emp> emps;

  public String list() {
    Date beginDate = null;
    Date endDate = null;

    if (sbeginDate != null && sendDate != null) {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      try {
        beginDate = sdf.parse(sbeginDate);
        endDate = sdf.parse(sendDate);
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }

    emps = new EmpDao().find(ename, beginDate, endDate);
    return "list";
  }

  /**
   * 跳转形式删除
   * 
   * @return
   */
  public String remove() {
    if (emp != null) {
      // emp对象有主键id
      new EmpDao().remove(emp);
    }
    return "remove";
  }

  /**
   * Ajax 形式删除 (一个方法就是一个Servlet,不需要返回 result)
   */
  public void removeAjax() {
    HttpServletRequest request = ServletActionContext.getRequest();
    HttpServletResponse response = ServletActionContext.getResponse();
    try {
      PrintWriter out = response.getWriter();
      // NumberUtils.createInteger() 把字符串对象转换为Integer对象
      Integer empno = NumberUtils.createInteger(request.getParameter("empno"));
      emp = new Emp();
      emp.setEmpno(empno);
      new EmpDao().remove(emp);

      String json = "{\"flag\":1}"; // 删除成功的标记
      out.println(json); // 向客户端回写数据
      out.flush();
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public String add() {
    if (emp != null) {
      // emp对象有主键id
      new EmpDao().add(emp);
    }
    return "add";
  }

  public String modify() {
    if (emp != null) {
      // emp对象有主键id
      new EmpDao().modify(emp);
    }
    return "modify";
  }

  public String findById() {
    if (emp != null) {
      // 第一个 emp 是根据id查询数据库后的数据
      // 第二个 Emp 是方法的泛型参数
      // 第三个 emp 是页面传入Action的对象
      emp = new EmpDao().find(Emp.class, emp.getEmpno());
    }
    return "findById";
  }

  public Emp getEmp() {
    return emp;
  }

  public void setEmp(Emp emp) {
    this.emp = emp;
  }

  public List<Emp> getEmps() {
    return emps;
  }

  public void setEname(String ename) {
    this.ename = ename;
  }

  public void setSbeginDate(String sbeginDate) {
    this.sbeginDate = sbeginDate;
  }

  public void setSendDate(String sendDate) {
    this.sendDate = sendDate;
  }

}
