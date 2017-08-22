package com.alacriti.ucp.datasource;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public final class MySqlDataSource {

	private static MySqlDataSource ms_this = null;
	private static DataSource dbSource = null;

	private MySqlDataSource() {
		init();
	}

	protected void init() {
		initialize();
	}

	public static MySqlDataSource getInstance() {
		synchronized (MySqlDataSource.class) {
			if (ms_this == null) {
				synchronized (MySqlDataSource.class) {
					ms_this = new MySqlDataSource();
				}
			}
		}

		return ms_this;
	}

	protected void initialize() {

		try {
			if (dbSource == null) {
				System.out.println("DataSource  looking up URL "
						+ "java:jboss/datasources/TRAINEEE");
				InitialContext aInitialContext = new InitialContext();
				dbSource = (DataSource) aInitialContext
						.lookup("java:jboss/datasources/TRAINEEE");
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		try {
			Connection dbCon = dbSource.getConnection();
			dbCon.setAutoCommit(false);
			return dbCon;
		} catch (Exception e) {
			System.out.println("Exception in getConnection " + e.getMessage());
		}
		return null;
	}
}
