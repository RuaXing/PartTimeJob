package com.fmt.parttime.common.database.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fmt.parttime.common.database.convert.ResultConverter;

/**
 * 数据存取类(定义了一系列的标准操作)
 */
public abstract class DataAccess {
	
	/**
	 * 日志工具
	 */
	private static final Logger LOG = LoggerFactory.getLogger(DataAccess.class);
	/**
	 * 数据库连接
	 */
	private Connection conn;
	/**
	 * @param conn 数据库连接
	 */
	protected DataAccess(Connection conn) {
		this.conn = conn;
	}
	
	/**
	 * 插入数据
	 * @param sql
	 * @param generatedKeysConverter 主键映射
	 * @param params
	 * @return 主键
	 * @throws DataAccessException
	 */
	protected <T> T insert(String sql, ResultConverter<T> generatedKeysConverter, Object... params) throws DataAccessException {
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(pstmt, params);
			executeUpdate(pstmt);
			ResultSet rs = pstmt.getGeneratedKeys();
			nextResult(rs);
			return convertResult(rs, generatedKeysConverter);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * 更新数据
	 * @param sql
	 * @param params
	 * @return 影响行数
	 * @throws DataAccessException
	 */
	protected int update(String sql, Object... params) throws DataAccessException {
		return executeUpdate(getPreparedStatement(sql, params));
	}
	
	/**
	 * 查询单个结果
	 * @param <T>
	 * @param sql
	 * @param converter
	 * @param params
	 * @return
	 */
	protected <T> T queryForObject(String sql, ResultConverter<T> converter, Object... params) {
		ResultSet rs = executeQuery(sql, params);
		if (nextResult(rs)) {
			return convertResult(rs, converter);
		} else {
			return null;
		}
	}
	
	/**
	 * 查询结果列表
	 * @param <T>
	 * @param sql
	 * @param converter
	 * @param params
	 * @return
	 */
	protected <T> List<T> queryForList(String sql, ResultConverter<T> converter, Object... params) {
		ResultSet rs = executeQuery(sql, params);
		List<T> list = new ArrayList<T>();
		while (nextResult(rs)) {
			list.add(convertResult(rs, converter));
		}
		return list;
	}
	
	/**
	 * @param sql SQL语句
	 * @return 预编译声明
	 */
	private PreparedStatement getPreparedStatement(String sql, Object... params) throws DataAccessException {
		PreparedStatement pstmt = getPreparedStatement(sql);
		setParameters(pstmt, params);
		return pstmt;
	}
	
	/**
	 * @param sql SQL语句
	 * @return 预编译声明
	 */
	private PreparedStatement getPreparedStatement(String sql) throws DataAccessException {
		try {
			return conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * 为预编译声明传入参数
	 * @param pstmt 预编译声明
	 * @param params 参数
	 * @throws DataAccessException
	 */
	private void setParameters(PreparedStatement pstmt, Object... params) throws DataAccessException {
		try {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * 执行更新操作
	 * @param pstmt
	 * @return 影响行数
	 * @throws DataAccessException
	 */
	private int executeUpdate(PreparedStatement pstmt) throws DataAccessException {
		try {
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * 执行查询操作
	 * @param pstmt 预编译声明
	 * @return 结果集
	 * @throws DataAccessException
	 */
	private ResultSet executeQuery(PreparedStatement pstmt) throws DataAccessException {
		try {
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * 执行查询操作
	 * @param sql SQL语句
	 * @param params 参数
	 * @return 结果集
	 * @throws DataAccessException
	 */
	private ResultSet executeQuery(String sql, Object... params) throws DataAccessException {
		return executeQuery(getPreparedStatement(sql, params));
	}
	
	/**
	 * 移动到下一行记录
	 * @param rs 结果集
	 * @return 是否有下一行记录
	 * @throws DataAccessException
	 */
	private boolean nextResult(ResultSet rs) throws DataAccessException {
		try {
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * 映射
	 * @param rs 结果集
	 * @return 映射结果
	 * @throws DataAccessException
	 */
	private <T> T convertResult(ResultSet rs, ResultConverter<T> converter) throws DataAccessException {
		try {
			return converter.convert(rs);
		} catch (SQLException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new DataAccessException(e);
		}
	}

}
