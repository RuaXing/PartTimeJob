package com.fmt.parttime.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 

import com.fmt.parttime.common.database.convert.ResultConverter;
import com.fmt.parttime.model.Jobapply;
 
public class JobapplyConvert implements ResultConverter<Jobapply>{ 
 
	@Override 
	public Jobapply convert(ResultSet rs) throws SQLException { 
		Jobapply jobapply = new Jobapply(rs.getInt(1)); 
		jobapply.applyDate = rs.getString(2); 
		jobapply.usersID = rs.getInt(3); 
		jobapply.jobID = rs.getInt(4); 
		jobapply.applyStatus = rs.getInt(5); 
		 
		return jobapply; 
	} 
 
} 
