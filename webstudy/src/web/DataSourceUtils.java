package web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSourceUtils {
	
	private static DataSource datasource = new ComboPooledDataSource();
	
	//��ȡdatasource
	public static DataSource getDataSource() {
		return datasource;
	}
	
	//��ȡconnection����
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = datasource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}