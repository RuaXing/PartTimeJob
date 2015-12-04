package com.fmt.parttime.convert; 
 
import java.sql.ResultSet; 
import java.sql.SQLException; 
 
import com.fmt.parttime.common.database.convert.ResultConverter; 
import com.fmt.parttime.model.Version; 
 
public class VersionConvert implements ResultConverter<Version>{ 
 
	@Override 
	public Version convert(ResultSet rs) throws SQLException { 
		Version version = new Version(rs.getInt(1)); 
		version.apkName = rs.getString(2); 
		version.apkUrl = rs.getString(3); 
		 
		return version; 
	} 
 
} 
