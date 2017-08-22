package com.alacriti.ucp.resteasy.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.ucp.biz.delegate.RepresentativeDelegate;
import com.alacriti.ucp.model.vo.RepresentativeVO;

@Path("/user/homepage")
public class RepresentativeResource {
	@POST
	@Path("/addRepresentative")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addNewService(RepresentativeVO rvo,
			@Context HttpServletRequest request) throws SQLException {
		RepresentativeDelegate rdelegate = new RepresentativeDelegate();
		rdelegate.representativeAddDelegate(rvo);
	}

	@GET
	@Path("/allRepresentatives/{service_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<RepresentativeVO> displayAllRepresentativesForAService(
			@PathParam("service_name") String Service_name,
			@Context HttpServletRequest request) throws SQLException {
		ArrayList<RepresentativeVO> representatives = null;
		RepresentativeDelegate rdelegate = new RepresentativeDelegate();
		representatives = rdelegate.representativeShowDelegate(Service_name);

		return representatives;
	}
}
