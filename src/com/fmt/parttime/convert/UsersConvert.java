package com.fmt.parttime.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 

import com.fmt.parttime.common.database.convert.ResultConverter;
import com.fmt.parttime.model.Users;
 
 
public class UsersConvert implements ResultConverter<Users>{ 
 
	@Override 
	public Users convert(ResultSet rs) throws SQLException { 
		Users users = new Users(rs.getInt(1)); 
		users.usersName = rs.getString(2); 
		users.usersPwd = rs.getString(3); 
		users.usersInvalitCode = rs.getString(4); 
		users.usersIsForgot = rs.getInt(5); 
		users.usersRegDate = rs.getString(6); 
		 
		return users; 
	} 
 
} 
