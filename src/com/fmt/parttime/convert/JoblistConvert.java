package com.fmt.parttime.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 

import com.fmt.parttime.common.database.convert.ResultConverter;
import com.fmt.parttime.model.Joblist;
 
 
public class JoblistConvert implements ResultConverter<Joblist>{ 
 
	@Override 
	public Joblist convert(ResultSet rs) throws SQLException { 
		Joblist joblist = new Joblist(rs.getInt(1)); 
		joblist.jobTitle = rs.getString(2); 
		joblist.jobLat = rs.getString(3); 
		joblist.jobLon = rs.getString(4); 
		joblist.jobPostAddress = rs.getString(5); 
		joblist.jobPayFee = rs.getString(6); 
		joblist.jobPostDate = rs.getString(7); 
		joblist.jobPostCompany = rs.getString(8); 
		joblist.jobJSRQ = rs.getString(9); 
		joblist.jobZPRS = rs.getInt(10); 
		joblist.jobGZRQ = rs.getString(11); 
		joblist.jobGZDZ = rs.getString(12); 
		joblist.jobMSSJ = rs.getString(13); 
		joblist.jobMSDZ = rs.getString(14); 
		joblist.jobZWMS = rs.getString(15); 
		joblist.jobPhone = rs.getString(16); 
		joblist.jobContactUser = rs.getString(17); 
		joblist.jobCity = rs.getString(18); 
		 
		return joblist; 
	} 
 
} 
