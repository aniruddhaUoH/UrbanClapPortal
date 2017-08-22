package com.alacriti.ucp.biz.delegate;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.ucp.datasource.MySqlDataSource;

public class BaseDelegate {

	private Connection connection;

	public void setConnection(Connection _connection) {
		this.connection = _connection;
	}

	public Connection getConnection() {
		return connection;
	}

	protected void endDBTransaction(Connection connection) {

		try {
			connection.commit();

		} catch (SQLException e) {
			System.out.println("SQLException in endDBTransaction "
					+ e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException e1) {
				System.out.println("SQLException in endDBTransaction"
						+ e1.getMessage());
			}
		} catch (Exception e) {
			System.out
					.println("Exception in endDBTransaction" + e.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.out.println("SQLException in endDBTransaction"
						+ e.getMessage());
			}
		}

	}

	protected void endDBTransaction(Connection connection, boolean isRollback) {

		if (isRollback) {
			try {
				connection.rollback();
				System.out.println("Rolled Back on some exception....!!!");
			} catch (SQLException e) {
				System.out.println("SQLException in endDBTransaction "
						+ e.getMessage());
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					System.out.println("SQLException in endDBTransaction "
							+ e.getMessage());
				}
			}
		} else {
			endDBTransaction(connection);
		}

	}

	protected Connection startDBTransaction() {
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				conn = MySqlDataSource.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("SQLException in startDBTransaction "
					+ e.getMessage());
		}
		return conn;

	}
}