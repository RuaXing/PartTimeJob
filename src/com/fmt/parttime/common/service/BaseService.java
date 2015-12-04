package com.fmt.parttime.common.service;

import java.sql.Connection;

import com.fmt.parttime.common.database.DatabaseTransaction;
/**
 * 提供一个统一的带事务的服务类
 * @author Administrator
 *
 */
public abstract class BaseService {
	
	private DatabaseTransaction trans;
	
	protected BaseService(DatabaseTransaction trans) {
		this.trans = trans;
	}
	
	protected BaseService() { }
	//返回事务
	protected DatabaseTransaction getTransaction() {
		return trans;
	}
	//返回数据库连接
	protected Connection getConnection() {
		return trans.getConnection();
	}

}

