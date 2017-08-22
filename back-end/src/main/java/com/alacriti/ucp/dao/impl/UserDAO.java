package com.alacriti.ucp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.alacriti.ucp.model.vo.DisplayRequestVO;
import com.alacriti.ucp.model.vo.RequestHandleVO;
import com.alacriti.ucp.model.vo.ServiceRequestVO;
import com.alacriti.ucp.model.vo.UserRegisterVO;
import com.alacriti.ucp.model.vo.UserLoginVO;

public class UserDAO extends BaseDAO {

	public UserDAO(Connection conn) {
		super(conn);
	}

	public UserDAO() {

	}

	public void createNewUser(UserRegisterVO uservo) throws DAOException {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql command";

			stmt = getPreparedStatementCreateNewUser(getConnection(), sqlCmd);
			stmt.setString(1, uservo.getUsername());
			stmt.setString(2, uservo.getEmail());
			stmt.setString(3, uservo.getUser_password());
			stmt.setString(4, uservo.getUserType());
			int count = stmt.executeUpdate();
			if (count > 0) {
				System.out.println("New User/Admin created...!");
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
					.prepareStatement("insert into aniruddhab_urbanclapportal_user_details_tbl(Username,Email,User_password,User_type) "
							+ "values(?,?,?,?)");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		}
	}

	public String checkUserLogin(UserLoginVO userloginVO) throws DAOException {
		Statement stmt = null;
		ResultSet rs = null;
		String usertype = "";

		try {
			String username = userloginVO.getUserName();
			String password = userloginVO.getPassword();
			String sqlCmd = ("select User_password, User_type from aniruddhab_urbanclapportal_user_details_tbl where Username='"
					+ username + "'");

			stmt = getStatementCheckUserLogin(getConnection(), sqlCmd);
			rs = stmt.executeQuery(sqlCmd);
			if (rs.next()) {
				if (password.equals(rs.getString("User_password"))) {
					System.out.println("Successfully Logged in***" + username);
					usertype = rs.getString("User_type");
				} else {
					System.out.println("Invalid Password");
				}

			}

		} catch (SQLException e) {
			System.out.println("SQLException in checkUser " + e.getMessage());
		} finally {
			close(stmt);
		}
		return usertype;
	}

	public Statement getStatementCheckUserLogin(Connection connection,
			String sqlCmd) throws SQLException {
		try {

			return connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Exception in getStatementCheckUserLogin"
					+ e.getMessage());
			throw e;
		}
	}

	public void createServiceRequest(ServiceRequestVO srvo, String uname)
			throws DAOException {

		PreparedStatement stmt = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		String username = uname;
		try {
			String sqlCmd = "sql command";

			String defaultStatus = "In Progess";
			stmt = getPreparedStatementCreateNewServiceRequest(getConnection(),
					sqlCmd);

			stmt.setString(1, username);
			stmt.setString(2, srvo.getService_name());
			stmt.setString(3, srvo.getR_name());
			stmt.setString(4, defaultStatus);

			String sqlCmd1 = ("select count(R_id) from aniruddhab_urbanclapportal_representative_details_tbl "
					+ " where Service_id = (select Service_id from aniruddhab_urbanclapportal_service_details_tbl where Service_name = '"
					+ srvo.getService_name() + "')");

			stmt2 = getStatementCheckRepresentativeExists(getConnection(),
					sqlCmd1);

			rs = stmt2.executeQuery(sqlCmd1);
			rs.next();
			int count2 = rs.getInt(1);
			if (count2 > 0) {
				int count = stmt.executeUpdate();
				if (count > 0) {
					System.out.println("New Service Request created...!");
				}
			} else {
				System.out.println("No representative available..!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementCreateNewServiceRequest(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("insert into aniruddhab_urbanclapportal_service_request_tbl(User_id, Service_id, Representative_id, Service_status) "
							+ "values((select User_id from aniruddhab_urbanclapportal_user_details_tbl where Username = ?), "
							+ "(select Service_id from aniruddhab_urbanclapportal_service_details_tbl where Service_name = ?),"
							+ "(select R_id from aniruddhab_urbanclapportal_representative_details_tbl where R_name = ?),?)");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		}
	}

	public Statement getStatementCheckRepresentativeExists(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Exception in getStatementCheckUser "
					+ e.getMessage());
			throw e;
		}
	}

	public ArrayList<DisplayRequestVO> displayAllRequests() throws DAOException {
		ArrayList<DisplayRequestVO> requests = new ArrayList<DisplayRequestVO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sqlCmd = "sql cmd";
		try {
			stmt = getPreparedStatementDisplayRequests(getConnection(), sqlCmd);
			rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new DisplayRequestVO(rs.getString("Username"), rs
						.getString("Service_name"), rs.getString("R_name"), rs
						.getString("Service_status")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
		return requests;
	}

	public PreparedStatement getPreparedStatementDisplayRequests(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("select u.Username, s.Service_name, "
							+ " r.R_name, sr.Service_status"
							+ " from aniruddhab_urbanclapportal_service_request_tbl sr"
							+ " INNER JOIN aniruddhab_urbanclapportal_user_details_tbl as u "
							+ " ON sr.User_id = u.User_id"
							+ " INNER JOIN aniruddhab_urbanclapportal_service_details_tbl as s "
							+ " ON sr.Service_id = s.Service_id"
							+ " INNER JOIN aniruddhab_urbanclapportal_representative_details_tbl as r "
							+ " ON sr.Representative_id = r.R_id");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public ArrayList<DisplayRequestVO> displayUserRequests(String username)
			throws DAOException {
		ArrayList<DisplayRequestVO> requests = new ArrayList<DisplayRequestVO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String uname = username;
		String sqlCmd = "sql cmd";
		try {
			stmt = getPreparedStatementDisplayUserRequests(getConnection(),
					sqlCmd, uname);
			rs = stmt.executeQuery();
			while (rs.next()) {
				requests.add(new DisplayRequestVO(rs.getString("Service_name"),
						rs.getString("R_name"), rs.getString("Service_status")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
		return requests;
	}

	public PreparedStatement getPreparedStatementDisplayUserRequests(
			Connection connection, String sqlCmd, String uname)
			throws SQLException {
		String username = uname;
		System.out.println("Username: " + username);
		try {
			return connection
					.prepareStatement("select r.R_name,  s.Service_name, sr.Service_status from aniruddhab_urbanclapportal_service_request_tbl sr "
							+ "INNER JOIN aniruddhab_urbanclapportal_service_details_tbl as s ON sr.Service_id = s.Service_id "
							+ "INNER JOIN aniruddhab_urbanclapportal_representative_details_tbl as r ON sr.Representative_id = r.R_id "
							+ "where User_id = (select User_id from aniruddhab_urbanclapportal_user_details_tbl where Username = '"
							+ username + "');");
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void handleServiceRequest(RequestHandleVO rhvo, String uname)
			throws DAOException {
		String username = uname;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sqlCmd = "sql command";

			stmt = getPreparedStatementUpdateStatus(getConnection(), sqlCmd);
			stmt.setString(1, username);
			stmt.setString(2, rhvo.getService_status());
			stmt.setString(3, rhvo.getUsername());
			stmt.setString(4, rhvo.getService_name());

			int count = stmt.executeUpdate();
			if (count > 0) {
				System.out.println("Service Request approved...!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt, rs);
		}
	}

	public PreparedStatement getPreparedStatementUpdateStatus(
			Connection connection, String sqlCmd) throws SQLException {
		try {
			return connection
					.prepareStatement("update aniruddhab_urbanclapportal_service_request_tbl "
							+ "set Approved_admin_id = (select User_id from aniruddhab_urbanclapportal_user_details_tbl where Username = ?) "
							+ ", Service_status = ? where User_id = (select User_id from aniruddhab_urbanclapportal_user_details_tbl where Username = ?) and"
							+ " Service_id = (select Service_id from aniruddhab_urbanclapportal_service_details_tbl where Service_name = ?)");

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;

		}
	}

}