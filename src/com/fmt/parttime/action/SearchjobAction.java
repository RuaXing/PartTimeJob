package com.fmt.parttime.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.fmt.parttime.common.database.DatabaseTransaction; 
import com.fmt.parttime.model.Searchjob; 
import com.fmt.parttime.service.SearchjobService; 
 
public class SearchjobAction { 
	public int add(Searchjob searchjob) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new SearchjobService(trans).add(searchjob); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Searchjob searchjob) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new SearchjobService(trans).edit(searchjob); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int searchID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new SearchjobService(trans).delete(searchID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Searchjob> findAll() { 
		List<Searchjob> lists = new ArrayList<Searchjob>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new SearchjobService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Searchjob> findWhere(String where) { 
		List<Searchjob> lists = new ArrayList<Searchjob>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new SearchjobService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Searchjob findById(int searchID) { 
		Searchjob searchjob = new Searchjob(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			searchjob = new SearchjobService(trans).findById(searchID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return searchjob; 
	} 
	 
	public List<Searchjob> findByRange(int start, int size) { 
		List<Searchjob> lists = new ArrayList<Searchjob>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new SearchjobService(trans).findByRange(start, size); 
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
			id = new SearchjobService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
