package com.fmt.parttime.service; 
 
import java.util.List; 

import com.fmt.parttime.common.database.DatabaseTransaction;
import com.fmt.parttime.common.service.BaseService;
import com.fmt.parttime.convert.JoblistConvert;
import com.fmt.parttime.dao.JobcollectDao;
import com.fmt.parttime.model.Jobcollect;
import com.fmt.parttime.model.Joblist;
 
 
public class JobcollectService extends BaseService { 
	public JobcollectService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public JobcollectService() { 
		super(); 
	} 
 
	public int add(Jobcollect jobcollect) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.add(jobcollect); 
	} 
 
	public int edit(Jobcollect jobcollect) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.edit(jobcollect); 
	} 
 
	public int delete(int jobCollectID) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.delete(jobCollectID); 
	} 
 
	public List<Jobcollect> findAll() { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findAll(); 
	} 
	
	public List<Jobcollect> findAll(int userId) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findAll(userId); 
	}
 
	public List<Jobcollect> findWhere(String where) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Jobcollect findById(int jobCollectID) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findById(jobCollectID); 
	} 
 
	public List<Jobcollect> findByRange(int start, int size) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
	public List<Jobcollect> findByRange(int start, int size,int userId) { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.findByRange(start, size, userId);
	}
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		JobcollectDao dao = new JobcollectDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
