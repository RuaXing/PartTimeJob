package com.fmt.parttime.action; 
 
import java.util.ArrayList; 
import java.util.List; 
 
import com.fmt.parttime.common.database.DatabaseTransaction; 
import com.fmt.parttime.model.Version; 
import com.fmt.parttime.service.VersionService; 
 
public class VersionAction { 
	public int add(Version version) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new VersionService(trans).add(version); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int edit(Version version) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new VersionService(trans).edit(version); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public int delete(int versionID) { 
		int id = 0; 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			id = new VersionService(trans).delete(versionID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
	 
	public List<Version> findAll() { 
		List<Version> lists = new ArrayList<Version>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new VersionService(trans).findAll(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public List<Version> findWhere(String where) { 
		List<Version> lists = new ArrayList<Version>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new VersionService(trans).findWhere(where); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return lists; 
	} 
	 
	public Version findById(int versionID) { 
		Version version = new Version(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			version = new VersionService(trans).findById(versionID); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return version; 
	} 
	 
	public List<Version> findByRange(int start, int size) { 
		List<Version> lists = new ArrayList<Version>(); 
		DatabaseTransaction trans = new DatabaseTransaction(true); 
		try { 
			lists = new VersionService(trans).findByRange(start, size); 
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
			id = new VersionService(trans).getCount(); 
			trans.commit(); 
		} catch (Exception e) { 
			trans.rollback(); 
		} finally { 
			trans.close(); 
		} 
		return id; 
	} 
} 
