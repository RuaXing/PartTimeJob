package com.fmt.parttime.common.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 * 数据库连接池(BoneCP:速度最快)
 */
public final class DatabaseConnectionPool {

	
	 private static final Logger LOG = LoggerFactory
	  .getLogger(DatabaseConnectionPool.class);
	 
	
	 private static final ResourceBundle BUNDLE = ResourceBundle
	 .getBundle("connection");
	 
	private static final String DRIVER = "DRIVER";
	private static final String URL = "URL";
	private static final String USERNAME = "USERNAME";
	private static final String PASSWORD = "PASSWORD";
	private static final String MAX_CONNECTION = "MAX_CONNECTION";
	private static BoneCP pool;

	/**
	 * 开启连接池(在缓存池中获取,效率高)
	 * 核心对象:BoneCP,数据库连接池对象;
	 *       BoneCPConfig,数据库配置信息对象
	 */
	public static Connection startup() {
		Connection connection;
		try {
			
			Class.forName(BUNDLE.getString(DRIVER));
			//创建BoneCPConfig对象,即数据库配置信息对象
			BoneCPConfig config = new BoneCPConfig();
			//为BoneCPConfig设置相应的数据库连接配置信息
			config.setJdbcUrl(BUNDLE.getString(URL));
			config.setUsername(BUNDLE.getString(USERNAME));
			config.setPassword(BUNDLE.getString(PASSWORD));
			config.setMaxConnectionsPerPartition(Integer.parseInt(BUNDLE.getString(MAX_CONNECTION)));
			//获得连接池对象,即BoneCP对象
			pool = new BoneCP(config);
			 connection=pool.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
			 LOG.error(e.getMessage(), e);
			throw new DatabaseException(e);
		}
		return connection;
	}

	/**
	 * 关闭连接池
	 */
	public static void shutdown() {
		pool.shutdown();
	}

	/**
	 * @return 数据库连接(从缓冲池中获取)
	 */
	public static Connection getConnection() {
		Connection connection;
		try {
			if(pool == null){
				connection =startup();
			 }
			else {
				connection = pool.getConnection();
			}
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			 LOG.error(e.getMessage(), e);
			throw new DatabaseException(e);
		}
	}

}
