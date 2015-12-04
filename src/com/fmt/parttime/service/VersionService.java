package com.fmt.parttime.service; 
 
import java.util.List; 
 
import com.fmt.parttime.common.database.DatabaseTransaction; 
import com.fmt.parttime.common.service.BaseService; 
import com.fmt.parttime.dao.VersionDao; 
import com.fmt.parttime.model.Version; 
 
public class VersionService extends BaseService { 
	public VersionService(DatabaseTransaction trans) { 
		super(trans); 
	} 
 
	public VersionService() { 
		super(); 
	} 
 
	public int add(Version version) { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.add(version); 
	} 
 
	public int edit(Version version) { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.edit(version); 
	} 
 
	public int delete(int versionID) { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.delete(versionID); 
	} 
 
	public List<Version> findAll() { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.findAll(); 
	} 
 
	public List<Version> findWhere(String where) { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.findWhere(where); 
	} 
 
	public Version findById(int versionID) { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.findById(versionID); 
	} 
 
	public List<Version> findByRange(int start, int size) { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.findByRange(start,size); 
	} 
 
	/** 
	 * 查询总记录数 
	 *  
	 * @return 
	 */ 
	public Integer getCount() { 
		VersionDao dao = new VersionDao(getConnection()); 
		return dao.getCount(); 
	} 
} 
