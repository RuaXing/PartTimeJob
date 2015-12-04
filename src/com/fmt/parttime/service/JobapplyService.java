package com.fmt.parttime.service; 
 
import java.util.List; 

import com.fmt.parttime.common.database.DatabaseTransaction;
import com.fmt.parttime.common.service.BaseService;
import com.fmt.parttime.dao.JobapplyDao;
import com.fmt.parttime.model.Jobapply;

 
 
public class JobapplyService extends BaseService { 
	public JobapplyService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public JobapplyService() { 
		super(); 
	} 
 
	public int add(Jobapply jobapply) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.add(jobapply); 
	} 
 
	public int edit(Jobapply jobapply) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.edit(jobapply); 
	} 
 
	public int delete(int applyID) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.delete(applyID); 
	} 
 
	public List<Jobapply> findAll() { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.findAll(); 
	} 
	
	public List<Jobapply> findAll(int userId,int applyStatus) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.findAll(userId,applyStatus); 
	}
 
	public List<Jobapply> findWhere(String where) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Jobapply findById(int applyID) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.findById(applyID); 
	} 
 
	public List<Jobapply> findByRange(int start, int size) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.getCount(); 
	} 
	
	public Integer getCount(int JobID) {
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.getCount(JobID); 
	}
	
	public Integer getCount(int jobId,int ApplyStatus) { 
		JobapplyDao dao = new JobapplyDao(getConnection()); 
		return dao.getCount(jobId, ApplyStatus); 
	}
} 
