package com.ouyeelf.ftz.persist.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Service;

@Service("dbTimeDao")
public class DbTimeDao {

	/**
	 * 返回数据库时间 格式为yyyy-MM-dd
	 */
	@PersistenceUnit
	private EntityManagerFactory emf;
	public Date getSysdate() {
		String sql = "select sysdate from dual";
		EntityManager em = emf.createEntityManager();
		return (Date) em.createNativeQuery(sql).getSingleResult();
	}

	/**
	 * 返回数据库时间  格式为yyyy-MM-dd HH24:mi:ss
	 * @return
	 */
	public String getSysDateString() {
		String sql = "select to_char(sysdate,'yyyy-MM-dd HH24:mi:ss') from dual";
		EntityManager em = emf.createEntityManager();
		return (String)em.createNativeQuery(sql).getSingleResult();
	}

}
