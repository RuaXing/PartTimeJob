package com.fmt.parttime.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.fmt.parttime.common.database.DatabaseTransaction; 
import com.fmt.parttime.model.Commit; 
import com.fmt.parttime.service.CommitService; 
 
public class CommitAction { 
	public int add(Commit commit) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new CommitService(trans).add(commit); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Commit commit) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new CommitService(trans).edit(commit); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int commitID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new CommitService(trans).delete(commitID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Commit> findAll() { 
		List<Commit> lists = new ArrayList<Commit>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new CommitService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Commit> findWhere(String where) { 
		List<Commit> lists = new ArrayList<Commit>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new CommitService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Commit findById(int commitID) { 
		Commit commit = new Commit(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			commit = new CommitService(trans).findById(commitID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return commit; 
	} 
	 
	public List<Commit> findByRange(int start, int size) { 
		List<Commit> lists = new ArrayList<Commit>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new CommitService(trans).findByRange(start, size); 
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
			id = new CommitService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
