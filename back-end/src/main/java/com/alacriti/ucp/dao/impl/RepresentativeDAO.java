package com.alacriti.ucp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.ucp.model.vo.RepresentativeVO;

public class RepresentativeDAO extends BaseDAO {

	// private Connection conn;
	public RepresentativeDAO(Connection conn) {
		super(conn);
	}

	public RepresentativeDAO() {

	}

	public void addNewRepresentative(RepresentativeVO rvo) throws DAOException {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sqlCmd = "sql command";

			stmt = getPreparedStatementCreateNewUser(getConnection(), sqlCmd);
			stmt.setString(1, rvo.getR_name());
			stmt.setString(2, rvo.getR_phone());
			stmt.setString(3, rvo.getService_name());
			stmt.setInt(4, rvo.getService_cost());
			int count = stmt.executeUpdate();
			if (count > 0) {
				System.out.println("New Representative added...!");
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
					.prepareStatement("insert into aniruddhab_urbanclapportal_representative_details_tbl(R_name, R_phone, Service_id, Service_cost) "
							+ "values(?,?,(Select Service_id from aniruddhab_urbanclapportal_service_details_tbl where Service_name = ?),?)");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		}
	}

	public ArrayList<RepresentativeVO> displayAllRepresentatives(
			String Service_name) throws DAOException {
		ArrayList<RepresentativeVO> representatives = new ArrayList<RepresentativeVO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlCmd = "sql cmd";
		String s_name = Service_name;
		try {
			stmt = getPreparedStatementDisplayRepresentatives(getConnection(),
					sqlCmd, s_name);
			rs = stmt.executeQuery();
			while (rs.next()) {
				representatives.add(new RepresentativeVO(rs.getString(1), rs
						.getString(2), rs.getInt(3)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
		return representatives;
	}

	public PreparedStatement getPreparedStatementDisplayRepresentatives(
			Connection connection, String sqlCmd, String s_name)
			throws SQLException {
		// log.debugPrintCurrentMethodName();
		try {
			return connection
					.prepareStatement("select R_name, R_phone, Service_cost from aniruddhab_urbanclapportal_representative_details_tbl "
							+ "where Service_id = (Select Service_id from aniruddhab_urbanclapportal_service_details_tbl "
							+ "where Service_name = '"
							+ s_name
							+ "') group by Service_cost asc");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
