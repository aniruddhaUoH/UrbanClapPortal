package com.alacriti.ucp.resteasy.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.ucp.model.vo.DisplayRequestVO;
import com.alacriti.ucp.model.vo.RequestHandleVO;
import com.alacriti.ucp.model.vo.ServiceRequestVO;
import com.alacriti.ucp.model.vo.UserLoginVO;
import com.alacriti.ucp.biz.delegate.UserDelegate;
import com.alacriti.ucp.model.vo.UserRegisterVO;
import com.alacriti.ucp.util.SessionUtility;

@Path("/user")
public class UserResource {
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addNewUser(UserRegisterVO uservo) throws SQLException {
		UserDelegate userdelegate = new UserDelegate();
		userdelegate.userAddDelegate(uservo);
	}

	@POST
	@Path("/login")
	@Produces(MediaType.TEXT_PLAIN)
	public String checkUser(UserLoginVO ulvo,
			@Context HttpServletRequest request) {
		String usertype = "";
		String type1 = "Admin";
		String type2 = "User";
		UserDelegate userDelegate = new UserDelegate();
		SessionUtility su = new SessionUtility();
		usertype = userDelegate.checkUserLogin(ulvo);
		if (usertype.equalsIgnoreCase(type1)
				|| usertype.equalsIgnoreCase(type2)) {
			su.createSession(request, ulvo);
		} else {
			System.out.println("session is not created");
		}
		return usertype;
	}

	@POST
	@Path("/requestService")
	@Produces(MediaType.APPLICATION_JSON)
	public void addNewRequest(ServiceRequestVO srvo,
			@Context HttpServletRequest request) throws SQLException {
		UserDelegate userdelegate = new UserDelegate();
		SessionUtility su = new SessionUtility();
		HttpSession session = su.getSession(request);
		String username = "";
		username = (String) session.getAttribute("username");
		userdelegate.userRequestService(srvo, username);
	}

	@GET
	@Path("/allRequests")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<DisplayRequestVO> displayAllRequests(
			@Context HttpServletRequest request) throws SQLException {
		ArrayList<DisplayRequestVO> requests = null;
		UserDelegate userdelegate = new UserDelegate();
		requests = userdelegate.requestShowDelegate();

		return requests;
	}

	@GET
	@Path("/userRequests")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<DisplayRequestVO> displayUserRequests(
			@Context HttpServletRequest request) throws SQLException {
		ArrayList<DisplayRequestVO> requests = null;
		SessionUtility su = new SessionUtility();
		HttpSession session = su.getSession(request);
		String username = "";
		username = (String) session.getAttribute("username");
		UserDelegate userdelegate = new UserDelegate();
		requests = userdelegate.userRequestShowDelegate(username);

		return requests;
	}

	@POST
	@Path("/handleRequest")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void handleRequest(RequestHandleVO rhvo,
			@Context HttpServletRequest request) throws SQLException {
		UserDelegate userdelegate = new UserDelegate();
		SessionUtility su = new SessionUtility();
		HttpSession session = su.getSession(request);
		String username = "";
		username = (String) session.getAttribute("username");
		userdelegate.handleRequestDelegate(rhvo, username);
	}

	@GET
	@Path("/checkSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSession(@Context HttpServletRequest request) {
		SessionUtility su = new SessionUtility();
		HttpSession session = su.getSession(request);
		if (session != null) {
			return true;
		} else {
			return false;
		}
	}

	@GET
	@Path("/destroySession")
	@Produces(MediaType.APPLICATION_JSON)
	public String destroySession(@Context HttpServletRequest request) {
		SessionUtility sessionUtility = new SessionUtility();
		boolean session = sessionUtility.destroySession(request);
		if (session) {
			return "Session Clear";
		} else
			return "Session Not Clear";
	}
}