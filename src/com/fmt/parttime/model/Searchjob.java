package com.fmt.parttime.model; 
 
import com.fmt.parttime.common.database.DataModel; 
 
public class Searchjob extends DataModel{ 
	public int searchID; 
	public String searchName; 
 
	public Searchjob(int searchID) { 
		super(); 
		this.searchID = searchID; 
	} 
 
	public Searchjob() { 
		super(); 
	} 
 
	public int getSearchID() { 
		return searchID; 
	} 
 
	public void setSearchID(int searchID) { 
		this.searchID = searchID; 
	} 
 
	public String getSearchName() { 
		return searchName; 
	} 
 
	public void setSearchName(String searchName) { 
		this.searchName = searchName; 
	} 
 
 
} 
