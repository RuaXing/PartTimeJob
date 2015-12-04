package com.fmt.parttime.model; 
 
import com.fmt.parttime.common.database.DataModel; 
 
public class Commit extends DataModel{ 
	public int commitID; 
	public String commitDesc; 
	public int usersID; 
 
	public Commit(int commitID) { 
		super(); 
		this.commitID = commitID; 
	} 
 
	public Commit() { 
		super(); 
	} 
 
	public int getCommitID() { 
		return commitID; 
	} 
 
	public void setCommitID(int commitID) { 
		this.commitID = commitID; 
	} 
 
	public String getCommitDesc() { 
		return commitDesc; 
	} 
 
	public void setCommitDesc(String commitDesc) { 
		this.commitDesc = commitDesc; 
	} 
 
	public int getUsersID() { 
		return usersID; 
	} 
 
	public void setUsersID(int usersID) { 
		this.usersID = usersID; 
	} 
 
 
} 
