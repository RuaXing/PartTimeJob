package com.fmt.parttime.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.fmt.parttime.common.database.access.DataAccess; 
import com.fmt.parttime.common.database.convert.IntegerConverter; 
import com.fmt.parttime.convert.SearchjobConvert; 
import com.fmt.parttime.model.Searchjob; 
 
public class SearchjobDao extends DataAccess { 
 
	public SearchjobDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Searchjob searchjob) { 
		String sql = "INSERT INTO searchjob (SearchName,SearchDate) VALUES (?,?)"; 
		return super.insert(sql, new IntegerConverter(), searchjob.searchName				); 
	} 
 
	public int edit(Searchjob searchjob) { 
		String sql = "UPDATE searchjob SET SearchName=?,SearchDate=? WHERE SearchID=?"; 
		return super.update(sql,
searchjob.searchName,				 searchjob.searchID); 
	} 
 
	public int delete(int searchID) { 
		String sql = "DELETE FROM searchjob WHERE SearchID=?"; 
		return super.update(sql, searchID); 
	} 
 
	public List<Searchjob> findAll() { 
		String sql = "SELECT * FROM searchjob"; 
		return super.queryForList(sql, new SearchjobConvert()); 
	} 
 
	public List<Searchjob> findWhere(String where) { 
		String sql = "SELECT * FROM searchjob WHERE 1=1 " + where; 
		return super.queryForList(sql, new SearchjobConvert()); 
	} 
 
	public Searchjob findById(int searchID) { 
		String sql = "SELECT * FROM searchjob WHERE  SearchID=?"; 
		return super.queryForObject(sql, new SearchjobConvert(), searchID); 
	} 
 
	public List<Searchjob> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM searchjob limit ?,?", 
				new SearchjobConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM searchjob", 
				new IntegerConverter()); 
	} 
 
} 
