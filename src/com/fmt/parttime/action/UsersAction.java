package com.fmt.parttime.action; 
 
import java.util.ArrayList; 
import java.util.List; 

import com.fmt.parttime.common.database.DatabaseTransaction;
import com.fmt.parttime.model.Users;
import com.fmt.parttime.service.UsersService;
/**
 * 处理user对象的相关业务逻辑(带事务) 
 * @author Administrator
 *
 */
 
public class UsersAction { 
	public int add(Users users) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new UsersService(trans).add(users); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Users users) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new UsersService(trans).edit(users); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int usersID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new UsersService(trans).delete(usersID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Users> findAll() { 
		List<Users> lists = new ArrayList<Users>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new UsersService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Users> findWhere(String where) { 
		List<Users> lists = new ArrayList<Users>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new UsersService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Users findById(int usersID) { 
		Users users = new Users(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			users = new UsersService(trans).findById(usersID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return users; 
	} 
	 
	public List<Users> findByRange(int start, int size) { 
		List<Users> lists = new ArrayList<Users>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new UsersService(trans).findByRange(start, size); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Integer getCount() { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new UsersService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
