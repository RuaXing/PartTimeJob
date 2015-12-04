package com.fmt.parttime.action; 
 
import java.util.ArrayList; 
import java.util.List;  

import com.fmt.parttime.common.database.DatabaseTransaction;
import com.fmt.parttime.model.Jobapply;
import com.fmt.parttime.service.JobapplyService;
 
public class JobapplyAction { 
	public int add(Jobapply jobapply) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobapplyService(trans).add(jobapply); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Jobapply jobapply) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobapplyService(trans).edit(jobapply); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int applyID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobapplyService(trans).delete(applyID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Jobapply> findAll() { 
		List<Jobapply> lists = new ArrayList<Jobapply>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobapplyService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	
	public List<Jobapply> findAll(int userId,int applyStatus) { 
		List<Jobapply> lists = new ArrayList<Jobapply>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobapplyService(trans).findAll(userId,applyStatus); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Jobapply> findWhere(String where) { 
		List<Jobapply> lists = new ArrayList<Jobapply>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobapplyService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Jobapply findById(int applyID) { 
		Jobapply jobapply = new Jobapply(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			jobapply = new JobapplyService(trans).findById(applyID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return jobapply; 
	} 
	 
	public List<Jobapply> findByRange(int start, int size) { 
		List<Jobapply> lists = new ArrayList<Jobapply>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new JobapplyService(trans).findByRange(start, size); 
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
			id = new JobapplyService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	
	public Integer getCount(int jobId) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobapplyService(trans).getCount(jobId); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	
	public Integer getCount(int jobId,int ApplyStatus) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new JobapplyService(trans).getCount(jobId,ApplyStatus); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	
} 
