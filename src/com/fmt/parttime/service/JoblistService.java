package com.fmt.parttime.service; 
 
import java.util.List; 

import com.fmt.parttime.common.database.DatabaseTransaction;
import com.fmt.parttime.common.service.BaseService;
import com.fmt.parttime.dao.JoblistDao;
import com.fmt.parttime.model.Joblist;
 
 
public class JoblistService extends BaseService { 
	public JoblistService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public JoblistService() { 
		super(); 
	} 
 
	public int add(Joblist joblist) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.add(joblist); 
	} 
 
	public int edit(Joblist joblist) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.edit(joblist); 
	} 
 
	public int delete(int jobID) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.delete(jobID); 
	} 
 
	public List<Joblist> findAll() { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Joblist> findWhere(String where) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Joblist findById(int jobID) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findById(jobID); 
	} 
 
	public List<Joblist> findByRange(int start, int size) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
	
	public List<Joblist> findByRange(int start, int size,String jobcity) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findByRange(start,size,jobcity); 
	}
	public List<Joblist> findByRange(int start, int size,String jobcity,String jobInfo) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.findByRange(start,size,jobcity,jobInfo); 
	}
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.getCount(); 
	} 
	
	public Integer getCount(int jobId) { 
		JoblistDao dao = new JoblistDao(getConnection()); 
		return dao.getCount(jobId); 
	} 
} 
