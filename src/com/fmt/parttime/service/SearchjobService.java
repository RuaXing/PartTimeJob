package com.fmt.parttime.service; 
 
import java.util.List; 
 
import com.fmt.parttime.common.database.DatabaseTransaction; 
import com.fmt.parttime.common.service.BaseService; 
import com.fmt.parttime.dao.SearchjobDao; 
import com.fmt.parttime.model.Searchjob; 
 
public class SearchjobService extends BaseService { 
	public SearchjobService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public SearchjobService() { 
		super(); 
	} 
 
	public int add(Searchjob searchjob) { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.add(searchjob); 
	} 
 
	public int edit(Searchjob searchjob) { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.edit(searchjob); 
	} 
 
	public int delete(int searchID) { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.delete(searchID); 
	} 
 
	public List<Searchjob> findAll() { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Searchjob> findWhere(String where) { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Searchjob findById(int searchID) { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.findById(searchID); 
	} 
 
	public List<Searchjob> findByRange(int start, int size) { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		SearchjobDao dao = new SearchjobDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
