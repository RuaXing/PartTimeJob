package com.fmt.parttime.model; 
 
import com.fmt.parttime.common.database.DataModel; 
 
public class Version extends DataModel{ 
	public int versionID; 
	public String apkName; 
	public String apkUrl; 
 
	public Version(int versionID) { 
		super(); 
		this.versionID = versionID; 
	} 
 
	public Version() { 
		super(); 
	} 
 
	public int getVersionID() {
		return versionID;
	}

	public void setVersionID(int versionID) {
		this.versionID = versionID;
	}

	public String getApkName() { 
		return apkName; 
	} 
 
	public void setApkName(String apkName) { 
		this.apkName = apkName; 
	} 
 
	public String getApkUrl() { 
		return apkUrl; 
	} 
 
	public void setApkUrl(String apkUrl) { 
		this.apkUrl = apkUrl; 
	} 
 
 
} 
