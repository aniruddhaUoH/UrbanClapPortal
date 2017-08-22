package com.alacriti.ucp.bo.impl;

import com.alacriti.ucp.dao.impl.DAOException;
import com.alacriti.ucp.dao.impl.UserDAO;
import com.alacriti.ucp.model.vo.DisplayRequestVO;
import com.alacriti.ucp.model.vo.RequestHandleVO;
import com.alacriti.ucp.model.vo.ServiceRequestVO;
import com.alacriti.ucp.model.vo.UserLoginVO;
import com.alacriti.ucp.model.vo.UserRegisterVO;

import java.sql.Connection;
import java.util.ArrayList;

public class UserBO extends BaseBO {

	public UserBO(Connection connection) {
		super(connection);
	}

	public void newUser(UserRegisterVO uservo) throws DAOException, BOException {
		try {
			UserDAO userdao = new UserDAO(getConnection());
			userdao.createNewUser(uservo);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
	}

	public String checkUserLogin(UserLoginVO userloginvo) throws DAOException,
			BOException {
		String usertype = "";
		try {
			UserDAO userdao = new UserDAO(getConnection());
			usertype = userdao.checkUserLogin(userloginvo);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
		return usertype;
	}

	public void newRequestService(ServiceRequestVO srvo, String uname)
			throws DAOException, BOException {
		String username = uname;
		try {
			UserDAO userdao = new UserDAO(getConnection());
			userdao.createServiceRequest(srvo, username);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
	}

	public ArrayList<DisplayRequestVO> displayRequests() throws DAOException,
			BOException {
		ArrayList<DisplayRequestVO> requests = null;
		try {

			UserDAO userdao = new UserDAO(getConnection());
			requests = userdao.displayAllRequests();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
		return requests;
	}

	public ArrayList<DisplayRequestVO> displayUserRequests(String uname)
			throws DAOException, BOException {
		ArrayList<DisplayRequestVO> requests = null;
		String username = uname;
		try {

			UserDAO userdao = new UserDAO(getConnection());
			requests = userdao.displayUserRequests(username);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
		return requests;
	}

	public void handleRequest(RequestHandleVO rhvo, String uname)
			throws DAOException, BOException {
		String username = uname;
		try {
			UserDAO userdao = new UserDAO(getConnection());
			userdao.handleServiceRequest(rhvo, username);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
	}
}
