package com.fmt.parttime.dao; 
 
import java.sql.Connection; 
import java.util.List; 
 
import com.fmt.parttime.common.database.access.DataAccess; 
import com.fmt.parttime.common.database.convert.IntegerConverter; 
import com.fmt.parttime.convert.VersionConvert; 
import com.fmt.parttime.model.Version; 
 
public class VersionDao extends DataAccess { 
 
	public VersionDao(Connection conn) { 
		super(conn); 
	} 
 
	public int add(Version version) { 
		String sql = "INSERT INTO version (ApkName,ApkUrl) VALUES (?,?)"; 
		return super.insert(sql, new IntegerConverter(), version.apkName,version.apkUrl				); 
	} 
 
	public int edit(Version version) { 
		String sql = "UPDATE version SET ApkName=?,ApkUrl=? WHERE VersionID=?"; 
		return super.update(sql,
version.apkName,version.apkUrl,				 version.versionID); 
	} 
 
	public int delete(int versionID) { 
		String sql = "DELETE FROM version WHERE VersionID=?"; 
		return super.update(sql, versionID); 
	} 
 
	public List<Version> findAll() { 
		String sql = "SELECT * FROM version"; 
		return super.queryForList(sql, new VersionConvert()); 
	} 
 
	public List<Version> findWhere(String where) { 
		String sql = "SELECT * FROM version WHERE 1=1 " + where; 
		return super.queryForList(sql, new VersionConvert()); 
	} 
 
	public Version findById(int versionID) { 
		String sql = "SELECT * FROM version WHERE  VersionID=?"; 
		return super.queryForObject(sql, new VersionConvert(), versionID); 
	} 
 
	public List<Version> findByRange(int start, int size) { 
		return super.queryForList("SELECT * FROM version limit ?,?", 
				new VersionConvert(), start, size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		return super.queryForObject("SELECT COUNT(*) FROM version", 
				new IntegerConverter()); 
	} 
 
} 
