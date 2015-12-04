package com.fmt.parttime.service; 
 
import java.util.List; 

import com.fmt.parttime.common.database.DatabaseTransaction;
import com.fmt.parttime.common.service.BaseService;
import com.fmt.parttime.dao.UsersDao;
import com.fmt.parttime.model.Users;
/**
 * user服务层(带事务) 
 * @author Administrator
 *
 */
 
public class UsersService extends BaseService { 
	public UsersService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public UsersService() { 
		super(); 
	} 
 
	public int add(Users users) { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.add(users); 
	} 
 
	public int edit(Users users) { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.edit(users); 
	} 
 
	public int delete(int usersID) { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.delete(usersID); 
	} 
 
	public List<Users> findAll() { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Users> findWhere(String where) { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Users findById(int usersID) { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.findById(usersID); 
	} 
 
	public List<Users> findByRange(int start, int size) { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		UsersDao dao = new UsersDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
