/**
 * 
 */
package com.kexun.wm.sale.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.sale.bean.Brand;
import com.kexun.wm.sale.dao.BrandDao;
import com.kexun.wm.untils.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class BrandDaoImpl implements BrandDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public int saveBrand(Brand brand) throws Exception {
		Session session = null;
		try {
			session = sf.openSession();
			session.save(brand);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public Brand getBrandById(int id) throws Exception {
		// TODO Auto-generated method stub
		Brand brand = null;
		Session session = null;
		try {
			session = sf.openSession();
			brand = (Brand) session.get(Brand.class, id);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return brand;
	}

	public Brand getBrandByElse(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		List<Brand> brandList = null;
 		Session session = null;
 		Brand b=null;
		try {
			session = sf.openSession();
			String hql = "from Brand where id<>"+brand.getId()+"and (1<>1 ";
			if (brand != null) {
				if ((!("").equals(brand.getName()))&& (brand.getName() != null)) {
					hql = hql + " or name = '" + brand.getName() + "'";
				}
				if ((!("").equals(brand.getCode()))&& (brand.getCode() != null)) {
					hql = hql + " or code = '" + brand.getCode() + "'";
				}
			}
			hql = hql +")";
			Query query = session.createQuery(hql);
			brandList = query.list();
			if (brandList.size() > 0) {
				b = brandList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}
	public int deleteBrand(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Brand brand = null;
		try {
			session = sf.openSession();
			brand = getBrandById(id);
			session.delete(brand);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}
	public int updateBrand(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(brand);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}
	public List<Brand> queryBrand(Brand brand, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<Brand> brandList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from Brand where 1=1";
			if (brand != null) {
				if ((!("").equals(brand.getName()))
						&& (brand.getName() != null)) {
					hql = hql + " and name like '%" + brand.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			brandList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return brandList;
	}
	public List<Brand> queryBrandSize(Brand brand) throws Exception {
		// TODO Auto-generated method stub
		List<Brand> brandList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from Brand where 1=1";
			if (brand != null) {
				if ((!("").equals(brand.getName()))
						&& (brand.getName() != null)) {
					hql = hql + " and name like '%" + brand.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			brandList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return brandList;
	}
}
