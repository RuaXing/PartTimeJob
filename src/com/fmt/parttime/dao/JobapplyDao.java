package com.fmt.parttime.dao; 
 
import java.sql.Connection; 
import java.util.List; 

import com.fmt.parttime.common.database.access.DataAccess;
import com.fmt.parttime.common.database.convert.IntegerConverter;
import com.fmt.parttime.convert.JobapplyConvert;
import com.fmt.parttime.model.Jobapply;

 
public class JobapplyDao extends DataAccess { 
 
	public JobapplyDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Jobapply jobapply) { 
		String sql = "INSERT INTO jobapply (ApplyDate,UsersID,JobID,ApplyStatus) VALUES (?,?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), jobapply.applyDate,jobapply.usersID,jobapply.jobID,jobapply.applyStatus				); 
	} 
 
	public int edit(Jobapply jobapply) { 
		String sql = "UPDATE jobapply SET ApplyDate=?,UsersID=?,JobID=?,ApplyStatus=? WHERE ApplyID=?"; 
		return super.update(sql,
jobapply.applyDate,jobapply.usersID,jobapply.jobID,jobapply.applyStatus,				 jobapply.applyID); 
	} 
 
	public int delete(int applyID) { 
		String sql = "DELETE FROM jobapply WHERE ApplyID=?"; 
		return super.update(sql, applyID); 
	} 
 
	public List<Jobapply> findAll() { 
		String sql = "SELECT * FROM jobapply"; 
		return super.queryForList(sql, new JobapplyConvert()); 
	} 
	
	public List<Jobapply> findAll(int userId,int applyStatus) { 
		String sql = "SELECT * FROM jobapply where UsersID=? and ApplyStatus=?"; 
		return super.queryForList(sql, new JobapplyConvert(),userId,applyStatus); 
	} 
 
	public List<Jobapply> findWhere(String where) { 
		String sql = "SELECT * FROM jobapply WHERE 1=1 " + where; 
		return super.queryForList(sql, new JobapplyConvert()); 
	} 
 
	public Jobapply findById(int applyID) { 
		String sql = "SELECT * FROM jobapply WHERE  ApplyID=?"; 
		return super.queryForObject(sql, new JobapplyConvert(), applyID); 
	} 
 
	public List<Jobapply> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM jobapply limit ?,?", 
				new JobapplyConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM jobapply", 
				new IntegerConverter()); 
	} 
	
	public Integer getCount(int JobID) { 
		return super.queryForObject("SELECT COUNT(*) FROM jobapply where JobID =?", 
				new IntegerConverter(),JobID); 
	} 
	
	public Integer getCount(int JobID,int ApplyStatus) { 
		return super.queryForObject("SELECT COUNT(*) FROM jobapply where JobID =? and ApplyStatus=?", 
				new IntegerConverter(),JobID,ApplyStatus); 
	} 
 
} 
