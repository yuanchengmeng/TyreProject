package com.kexun.wm.store.service;

import java.util.List;

import com.kexun.wm.store.bean.HUser;

public interface HUserService {
	public int saveHUser(HUser user1) throws Exception;

	public int deleteHUser(int id) throws Exception;

	public int updateHUser(HUser user1) throws Exception;

	public List<HUser> queryHUser(HUser user1, int pageNo,
			int pageSize) throws Exception;

	public HUser findHUserById(int id) throws Exception;

	public int queryAllRows(HUser user1) throws Exception;

	public HUser getHUserByName(String name) throws Exception;

}
