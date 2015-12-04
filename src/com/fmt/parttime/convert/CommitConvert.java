package com.fmt.parttime.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.fmt.parttime.common.database.convert.ResultConverter; 
import com.fmt.parttime.model.Commit; 
 
public class CommitConvert implements ResultConverter<Commit>{ 
 
	@Override 
	public Commit convert(ResultSet rs) throws SQLException { 
		Commit commit = new Commit(rs.getInt(1)); 
		commit.commitDesc = rs.getString(2); 
		commit.usersID = rs.getInt(3); 
		 
		return commit; 
	} 
 
} 
