package com.fmt.parttime.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.fmt.parttime.common.database.convert.ResultConverter; 
import com.fmt.parttime.model.Searchjob; 
 
public class SearchjobConvert implements ResultConverter<Searchjob>{ 
 
	@Override 
	public Searchjob convert(ResultSet rs) throws SQLException { 
		Searchjob searchjob = new Searchjob(rs.getInt(1)); 
		searchjob.searchName = rs.getString(2); 
		 
		 
		return searchjob; 
	} 
 
} 
