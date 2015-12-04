package com.fmt.parttime.service; 
 
import java.util.List; 
 
import com.fmt.parttime.common.database.DatabaseTransaction; 
import com.fmt.parttime.common.service.BaseService; 
import com.fmt.parttime.dao.CommitDao; 
import com.fmt.parttime.model.Commit; 
 
public class CommitService extends BaseService { 
	public CommitService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public CommitService() { 
		super(); 
	} 
 
	public int add(Commit commit) { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.add(commit); 
	} 
 
	public int edit(Commit commit) { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.edit(commit); 
	} 
 
	public int delete(int commitID) { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.delete(commitID); 
	} 
 
	public List<Commit> findAll() { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Commit> findWhere(String where) { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Commit findById(int commitID) { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.findById(commitID); 
	} 
 
	public List<Commit> findByRange(int start, int size) { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		CommitDao dao = new CommitDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
