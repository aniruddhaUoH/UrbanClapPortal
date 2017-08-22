package com.alacriti.ucp.resteasy.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.ucp.biz.delegate.ServiceDelegate;
import com.alacriti.ucp.model.vo.ServiceVO;

@Path("/user")
public class ServiceResource {
	@POST
	@Path("/addService")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public void addNewService(ServiceVO servicevo,
			@Context HttpServletRequest request) throws SQLException {
		ServiceDelegate servicedelegate = new ServiceDelegate();
		servicedelegate.serviceAddDelegate(servicevo);
	}

	@GET
	@Path("/allServices")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ServiceVO> displayAllServices(
			@Context HttpServletRequest request) throws SQLException {

		ArrayList<ServiceVO> services = null;
		ServiceDelegate servicedelegate = new ServiceDelegate();
		services = servicedelegate.serviceShowDelegate();

		return services;
	}

	@DELETE
	@Path("/allServices/{service_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteService(@PathParam("service_name") String Service_name,
			@Context HttpServletRequest request) throws SQLException {
		ServiceDelegate sdelegate = new ServiceDelegate();
		sdelegate.deleteService(Service_name);
	}

	@GET
	@Path("/searchService/{service_name}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ServiceVO> searchByServiceName(
			@PathParam("service_name") String Service_name,
			@Context HttpServletRequest request) throws SQLException {
		ArrayList<ServiceVO> services = null;
		ServiceDelegate servicedelegate = new ServiceDelegate();
		services = servicedelegate.serviceSearchDelegate(Service_name);

		return services;
	}

}
