package com.fmt.parttime.action; 
 
import java.util.ArrayList; 
import java.util.List; 

import com.fmt.parttime.common.database.DatabaseTransaction;
import com.fmt.parttime.dao.JobcollectDao;
import com.fmt.parttime.model.Jobcollect;
import com.fmt.parttime.model.Joblist;
import com.fmt.parttime.service.JobcollectService;
 
 
public class JobcollectAction { 
	public int add(Jobcollect jobcollect) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).add(jobcollect); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Jobcollect jobcollect) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).edit(jobcollect); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int jobCollectID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).delete(jobCollectID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Jobcollect> findAll() { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	
	public List<Jobcollect> findAll(int userId) { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findAll(userId); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Jobcollect> findWhere(String where) { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Jobcollect findById(int jobCollectID) { 
		Jobcollect jobcollect = new Jobcollect(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			jobcollect = new JobcollectService(trans).findById(jobCollectID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return jobcollect; 
	} 
	 
	public List<Jobcollect> findByRange(int start, int size) { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findByRange(start, size); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	
	public List<Jobcollect> findByRange(int start, int size,int userId) { 
		List<Jobcollect> lists = new ArrayList<Jobcollect>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobcollectService(trans).findByRange(start, size,userId); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	}
	 
	public Integer getCount() { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobcollectService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
