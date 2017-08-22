package com.alacriti.ucp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.ucp.model.vo.ServiceVO;

public class ServiceDAO extends BaseDAO {

	public ServiceDAO(Connection conn) {
		super(conn);
	}

	public ServiceDAO() {

	}

	public void createNewService(ServiceVO servicevo) throws DAOException {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql command";

			stmt = getPreparedStatementCreateNewUser(getConnection(), sqlCmd);
			System.out.println(servicevo.getService_name());

			stmt.setString(1, servicevo.getService_name());
			int count = stmt.executeUpdate();
			if (count > 0) {
				System.out.println("New Service created...!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementCreateNewUser(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("insert into aniruddhab_urbanclapportal_service_details_tbl(Service_name) values(?)");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		}
	}

	public ArrayList<ServiceVO> displayAllServices() throws DAOException {
		ArrayList<ServiceVO> services = new ArrayList<ServiceVO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlCmd = "sql cmd";
		try {
			stmt = getPreparedStatementDisplayServices(getConnection(), sqlCmd);
			rs = stmt.executeQuery();
			while (rs.next()) {
				services.add(new ServiceVO(rs.getString(1)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
		return services;
	}

	public PreparedStatement getPreparedStatementDisplayServices(
			Connection connection, String sqlCmd) throws SQLException {
		try {

			return connection
					.prepareStatement("select Service_name from aniruddhab_urbanclapportal_service_details_tbl");
		} catch (SQLException e) {
			System.out.println("Exception in getPreparedStatementGetProducts "
					+ e.getMessage());
			throw e;
		}
	}

	public boolean deleteService(String Service_name) throws DAOException {
		PreparedStatement stmt = null;
		String sqlCmd = "sql cmd";
		int count = 0;
		boolean flag = false;
		try {
			stmt = getPreparedStatementDeleteService(getConnection(), sqlCmd);
			stmt.setString(1, Service_name);
			count = stmt.executeUpdate();

			if (count > 0) {

				System.out.println("Service is Deleted successfully");

				flag = true;
			} else {
				System.out.println("Unable to delete the Service");
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		return flag;
	}

	private PreparedStatement getPreparedStatementDeleteService(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("delete from aniruddhab_urbanclapportal_service_details_tbl"
							+ " WHERE Service_name = ?");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<ServiceVO> searchByServiceName(String Service_name)
			throws DAOException {
		ArrayList<ServiceVO> services = new ArrayList<ServiceVO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlCmd = "sql cmd";
		String s_name = Service_name;
		try {
			stmt = getPreparedStatementSearchService(getConnection(), sqlCmd,
					s_name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				services.add(new ServiceVO(rs.getString(1)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
		return services;
	}

	public PreparedStatement getPreparedStatementSearchService(
			Connection connection, String sqlCmd, String s_name)
			throws SQLException {
		try {

			return connection
					.prepareStatement("select Service_name from aniruddhab_urbanclapportal_service_details_tbl"
							+ " where Service_name = '" + s_name + "'");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}