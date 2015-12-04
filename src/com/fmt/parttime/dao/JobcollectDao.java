package com.fmt.parttime.dao; 
 
import java.sql.Connection; 
import java.util.List; 

import com.fmt.parttime.common.database.access.DataAccess;
import com.fmt.parttime.common.database.convert.IntegerConverter;
import com.fmt.parttime.convert.JobcollectConvert;
import com.fmt.parttime.convert.JoblistConvert;
import com.fmt.parttime.model.Jobcollect;
import com.fmt.parttime.model.Joblist;
 
 
public class JobcollectDao extends DataAccess { 
 
	public JobcollectDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Jobcollect jobcollect) { 
		String sql = "INSERT INTO jobcollect (JobCollectDate,UsersID,JobID) VALUES (?,?,?)"; 
		return super.insert(sql, new IntegerConverter(), jobcollect.jobCollectDate,jobcollect.usersID,jobcollect.jobID				); 
	} 
 
	public int edit(Jobcollect jobcollect) { 
		String sql = "UPDATE jobcollect SET JobCollectDate=?,UsersID=?,JobID=? WHERE JobCollectID=?"; 
		return super.update(sql,
jobcollect.jobCollectDate,jobcollect.usersID,jobcollect.jobID,				 jobcollect.jobCollectID); 
	} 
 
	public int delete(int jobCollectID) { 
		String sql = "DELETE FROM jobcollect WHERE JobCollectID=?"; 
		return super.update(sql, jobCollectID); 
	} 
 
	public List<Jobcollect> findAll() { 
		String sql = "SELECT * FROM jobcollect"; 
		return super.queryForList(sql, new JobcollectConvert()); 
	} 
	
	public List<Jobcollect> findAll(int userId) { 
		String sql = "SELECT * FROM jobcollect where UsersID =?"; 
		return super.queryForList(sql, new JobcollectConvert(),userId); 
	} 
 
	public List<Jobcollect> findWhere(String where) { 
		String sql = "SELECT * FROM jobcollect WHERE 1=1 " + where; 
		return super.queryForList(sql, new JobcollectConvert()); 
	} 
 
	public Jobcollect findById(int jobCollectID) { 
		String sql = "SELECT * FROM jobcollect WHERE  JobCollectID=?"; 
		return super.queryForObject(sql, new JobcollectConvert(), jobCollectID); 
	} 
 
	public List<Jobcollect> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM jobcollect limit ?,?", 
				new JobcollectConvert(), start, size); 
	} 
	public List<Jobcollect> findByRange(int start, int size,int userId) { 
		return super.queryForList("SELECT * FROM jobcollect where UsersID =? limit ?,?", 
				new JobcollectConvert(),userId, start, size); 
	}
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM jobcollect", 
				new IntegerConverter()); 
	} 
 
} 
