package com.fmt.parttime.dao; 
 
import java.sql.Connection; 
import java.util.List; 

import com.fmt.parttime.common.database.access.DataAccess;
import com.fmt.parttime.common.database.convert.IntegerConverter;
import com.fmt.parttime.convert.UsersConvert;
import com.fmt.parttime.model.Users;
 
 
public class UsersDao extends DataAccess { 
 
	public UsersDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Users users) { 
		String sql = "INSERT INTO users (UsersName,UsersPwd,UsersInvalitCode,UsersIsForgot,UsersRegDate) VALUES (?,?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), users.usersName,users.usersPwd,users.usersInvalitCode,users.usersIsForgot,users.usersRegDate				); 
	} 
 
	public int edit(Users users) { 
		String sql = "UPDATE users SET UsersName=?,UsersPwd=?,UsersInvalitCode=?,UsersIsForgot=?,UsersRegDate=? WHERE UsersID=?"; 
		return super.update(sql,
users.usersName,users.usersPwd,users.usersInvalitCode,users.usersIsForgot,users.usersRegDate,				 users.usersID); 
	} 
 
	public int delete(int usersID) { 
		String sql = "DELETE FROM users WHERE UsersID=?"; 
		return super.update(sql, usersID); 
	} 
 
	public List<Users> findAll() { 
		String sql = "SELECT * FROM users"; 
		return super.queryForList(sql, new UsersConvert()); 
	} 
 
	public List<Users> findWhere(String where) { 
		String sql = "SELECT * FROM users WHERE 1=1 " + where; 
		return super.queryForList(sql, new UsersConvert()); 
	} 
 
	public Users findById(int usersID) { 
		String sql = "SELECT * FROM users WHERE  UsersID=?"; 
		return super.queryForObject(sql, new UsersConvert(), usersID); 
	} 
 
	public List<Users> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM users limit ?,?", 
				new UsersConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM users", 
				new IntegerConverter()); 
	} 
 
} 
