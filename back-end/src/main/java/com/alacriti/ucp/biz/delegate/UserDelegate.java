package com.alacriti.ucp.biz.delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.ucp.model.vo.DisplayRequestVO;
import com.alacriti.ucp.model.vo.RequestHandleVO;
import com.alacriti.ucp.model.vo.ServiceRequestVO;
import com.alacriti.ucp.model.vo.UserLoginVO;
import com.alacriti.ucp.bo.impl.UserBO;
import com.alacriti.ucp.model.vo.UserRegisterVO;

public class UserDelegate extends BaseDelegate {

	public void userAddDelegate(UserRegisterVO uservo) throws SQLException {

		boolean flag = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserBO userbo = new UserBO(getConnection());
			userbo.newUser(uservo);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
	}

	public String checkUserLogin(UserLoginVO userloginvo) {
		boolean rollBack = false;
		Connection connection = null;
		String usertype = "";
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserBO userbo = new UserBO(getConnection());
			usertype = userbo.checkUserLogin(userloginvo);
		} catch (Exception e) {
			System.out.println("Exception in getMessage " + e.getMessage());
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return usertype;
	}

	public void userRequestService(ServiceRequestVO srvo, String uname)
			throws SQLException {

		boolean flag = false;
		Connection connection = null;
		String username = uname;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserBO userbo = new UserBO(getConnection());
			userbo.newRequestService(srvo, username);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
	}

	public ArrayList<DisplayRequestVO> requestShowDelegate()
			throws SQLException {
		ArrayList<DisplayRequestVO> requests = null;
		boolean flag = false;
		Connection connection = null;
		try {

			connection = startDBTransaction();
			setConnection(connection);
			UserBO userbo = new UserBO(getConnection());
			requests = userbo.displayRequests();

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
		return requests;
	}

	public ArrayList<DisplayRequestVO> userRequestShowDelegate(String username)
			throws SQLException {
		ArrayList<DisplayRequestVO> requests = null;
		boolean flag = false;
		Connection connection = null;
		String uname = username;
		try {

			connection = startDBTransaction();
			setConnection(connection);
			UserBO userbo = new UserBO(getConnection());
			requests = userbo.displayUserRequests(uname);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
		return requests;
	}

	public void handleRequestDelegate(RequestHandleVO rhvo, String uname)
			throws SQLException {
		String username = uname;
		boolean flag = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			UserBO userbo = new UserBO(getConnection());
			userbo.handleRequest(rhvo, username);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
	}
}