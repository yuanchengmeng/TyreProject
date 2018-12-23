package com.kexun.wm.store.service.impl;

import java.util.List;

import com.kexun.wm.store.bean.HUser;
import com.kexun.wm.store.dao.HUserDao;
import com.kexun.wm.store.dao.impl.HUserDaoImpl;
import com.kexun.wm.store.service.HUserService;

public class HUserServiceImpl  implements HUserService{
    private HUserDao userDao=new HUserDaoImpl();
	public int saveHUser(HUser user1) throws Exception {
		// TODO Auto-generated method stub
		return userDao.saveHUser(user1);
	}

	public int deleteHUser(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.deleteHUser(id);
	}

	public int updateHUser(HUser user1) throws Exception {
		// TODO Auto-generated method stub
		return userDao.updateHUser(user1);
	}

	public List<HUser> queryHUser(HUser user1, int pageNo,
			int pageSize) throws Exception {
		// TODO Auto-generated method stub
		return userDao.queryHUser(user1, pageNo, pageSize);
	}

	public HUser findHUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return userDao.findHUserById(id);
	}

	public int queryAllRows(HUser user1) throws Exception {
		// TODO Auto-generated method stub
		return userDao.queryAllRows(user1);
	}

	public HUser getHUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return userDao.getHUserByName(name);
	}
}
