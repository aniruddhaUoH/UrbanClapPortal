package com.alacriti.ucp.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import com.alacriti.ucp.model.vo.UserLoginVO;

public class SessionUtility {
	public SessionUtility() {

	}

	public void createSession(HttpServletRequest request,
			UserLoginVO userloginvo) {
		try {
			HttpSession session = request.getSession(true);
			session.setAttribute("username", userloginvo.getUserName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HttpSession getSession(@Context HttpServletRequest request) {
		HttpSession session = null;
		try {
			session = request.getSession(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return session;
	}

	public boolean destroySession(HttpServletRequest request) {
		HttpSession existingSession = request.getSession(false);
		try {
			existingSession.invalidate();
			System.out.println("Logged out successfully...");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
