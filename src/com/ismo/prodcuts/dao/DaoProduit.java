package com.ismo.prodcuts.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.utils.HibernateUtils;
import com.ismo.prodcuts.model.Produit;

public class DaoProduit implements IDao<Produit> {

	@Override
	public List<Produit> getAll() {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		List<Produit> prds = s.createQuery("from Produit").list();
		t.commit();
		s.close();
		return prds;
	}

	@Override
	public Produit getOne(int id) {
		Session s = HibernateUtils.getSessionFactory().getCurrentSession();
		Transaction t = s.beginTransaction();
		Produit p = s.get(Produit.class, id);
		t.commit();
		s.close();
		return p;
	}

	@Override
	public boolean save(Produit obj) {
		try {
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			s.save(obj);
			t.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Produit obj) {
		try {
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			s.update(obj);
			t.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean delete(Produit obj) {
		try {
			Session s = HibernateUtils.getSessionFactory().getCurrentSession();
			Transaction t = s.beginTransaction();
			s.delete(obj);
			t.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
