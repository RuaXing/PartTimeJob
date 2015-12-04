package com.fmt.parttime.model; 

import com.fmt.parttime.common.database.DataModel;
 

public class Jobapply extends DataModel{ 
	public int applyID; 
	public String applyDate; 
	public int usersID; 
	public int jobID; 
	public int applyStatus; 
 
	public Jobapply(int applyID) { 
		super(); 
		this.applyID = applyID; 
	} 
 
	public Jobapply() { 
		super(); 
	} 
 
	public int getApplyID() { 
		return applyID; 
	} 
 
	public void setApplyID(int applyID) { 
		this.applyID = applyID; 
	} 
 
	public String getApplyDate() { 
		return applyDate; 
	} 
 
	public void setApplyDate(String applyDate) { 
		this.applyDate = applyDate; 
	} 
 
	public int getUsersID() { 
		return usersID; 
	} 
 
	public void setUsersID(int usersID) { 
		this.usersID = usersID; 
	} 
 
	public int getJobID() { 
		return jobID; 
	} 
 
	public void setJobID(int jobID) { 
		this.jobID = jobID; 
	} 
 
	public int getApplyStatus() { 
		return applyStatus; 
	} 
 
	public void setApplyStatus(int applyStatus) { 
		this.applyStatus = applyStatus; 
	}

	@Override
	public String toString() {
		return "Jobapply [applyID=" + applyID + ", applyDate=" + applyDate
				+ ", usersID=" + usersID + ", jobID=" + jobID
				+ ", applyStatus=" + applyStatus + "]";
	} 
 
	
} 
