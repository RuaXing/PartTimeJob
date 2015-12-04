package com.fmt.parttime.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 

import com.fmt.parttime.common.database.convert.ResultConverter;
import com.fmt.parttime.model.Jobcollect;
 
 
public class JobcollectConvert implements ResultConverter<Jobcollect>{ 
 
	@Override 
	public Jobcollect convert(ResultSet rs) throws SQLException { 
		Jobcollect jobcollect = new Jobcollect(rs.getInt(1)); 
		jobcollect.jobCollectDate = rs.getString(2); 
		jobcollect.usersID = rs.getInt(3); 
		jobcollect.jobID = rs.getInt(4); 
		 
		return jobcollect; 
	} 
 
} 
