package com.struts2.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.struts2.pojo.Emp;

public class EmpDao extends HibernateDao<Emp> {

  // 扩展自己的方法

  /**
   * 多条件查询
   * 
   * @param ename
   * @param beginDate
   * @param endDate
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Emp> find(String ename, Date beginDate, Date endDate) {
    Session session = HibernateSessionFactory.getSession();
    String hql = "from Emp where 1=1 ";
    if (ename != null && !"".equals(ename)) {
      hql += " and ename like :ename ";
    }

    if (beginDate != null && endDate != null) {
      hql += " and hiredate between :beginDate and :endDate ";
    }

    Query query = session.createQuery(hql);
    if (ename != null && !"".equals(ename)) {
      query.setString("ename", "%" + ename.toUpperCase() + "%");
    }

    if (beginDate != null && endDate != null) {
      query.setDate("beginDate", beginDate);
      query.setDate("endDate", endDate);
    }

    List<Emp> emps = query.list();
    HibernateSessionFactory.closeSession();
    return emps;
  }
}
