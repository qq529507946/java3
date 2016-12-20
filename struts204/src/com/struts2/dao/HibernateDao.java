package com.struts2.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 封装 Hibernate 对数据库的操作
 * 
 * @author SONG
 *
 */
public class HibernateDao<T> {
  /**
   * 根据实体类查询所有数据
   * 
   * @param clazz
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<T> find(Class<T> clazz) {
    Session session = HibernateSessionFactory.getSession();
    Criteria c = session.createCriteria(clazz);
    List<T> list = c.list();
    HibernateSessionFactory.closeSession();
    return list;
  }

  /**
   * 根据指定实体类的id查询一条数据
   * 
   * @param clazz
   * @param id
   * @return
   */
  public T find(Class<T> clazz, Serializable id) {
    Session session = HibernateSessionFactory.getSession();
    T t = session.get(clazz, id);
    HibernateSessionFactory.closeSession();
    return t;
  }

  public void add(T t) {
    Session session = HibernateSessionFactory.getSession();
    Transaction tx = session.beginTransaction();
    session.save(t);
    tx.commit();
    HibernateSessionFactory.closeSession();
  }

  public void modify(T t) {
    Session session = HibernateSessionFactory.getSession();
    Transaction tx = session.beginTransaction();
    session.update(t);
    tx.commit();
    HibernateSessionFactory.closeSession();
  }

  public void remove(T t) {
    Session session = HibernateSessionFactory.getSession();
    Transaction tx = session.beginTransaction();
    session.delete(t);
    tx.commit();
    HibernateSessionFactory.closeSession();
  }
}
