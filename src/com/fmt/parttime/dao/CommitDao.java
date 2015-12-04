package com.fmt.parttime.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.fmt.parttime.common.database.access.DataAccess; 
import com.fmt.parttime.common.database.convert.IntegerConverter; 
import com.fmt.parttime.convert.CommitConvert; 
import com.fmt.parttime.model.Commit; 
 
public class CommitDao extends DataAccess { 
 
	public CommitDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Commit commit) { 
		String sql = "INSERT INTO commit (CommitDesc,UsersID) VALUES (?,?)"; 
		return super.insert(sql, new IntegerConverter(), commit.commitDesc,commit.usersID				); 
	} 
 
	public int edit(Commit commit) { 
		String sql = "UPDATE commit SET CommitDesc=?,UsersID=? WHERE CommitID=?"; 
		return super.update(sql,
commit.commitDesc,commit.usersID,				 commit.commitID); 
	} 
 
	public int delete(int commitID) { 
		String sql = "DELETE FROM commit WHERE CommitID=?"; 
		return super.update(sql, commitID); 
	} 
 
	public List<Commit> findAll() { 
		String sql = "SELECT * FROM commit"; 
		return super.queryForList(sql, new CommitConvert()); 
	} 
 
	public List<Commit> findWhere(String where) { 
		String sql = "SELECT * FROM commit WHERE 1=1 " + where; 
		return super.queryForList(sql, new CommitConvert()); 
	} 
 
	public Commit findById(int commitID) { 
		String sql = "SELECT * FROM commit WHERE  CommitID=?"; 
		return super.queryForObject(sql, new CommitConvert(), commitID); 
	} 
 
	public List<Commit> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM commit limit ?,?", 
				new CommitConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM commit", 
				new IntegerConverter()); 
	} 
 
} 
