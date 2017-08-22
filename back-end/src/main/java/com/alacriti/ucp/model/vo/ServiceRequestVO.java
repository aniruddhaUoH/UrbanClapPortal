package com.alacriti.ucp.model.vo;

public class ServiceRequestVO {
	private String Username;
	private String Service_name;
	private String R_name;

	public ServiceRequestVO() {
		super();
	}

	public ServiceRequestVO(String Service_name) {
		super();
		this.Service_name = Service_name;
	}

	public ServiceRequestVO(String Username, String Service_name, String R_name) {
		super();
		this.Username = Username;
		this.Service_name = Service_name;
		this.R_name = R_name;
	}

	public String getR_name() {
		return R_name;
	}

	public void setR_name(String r_name) {
		R_name = r_name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getService_name() {
		return Service_name;
	}

	public void setService_name(String service_name) {
		Service_name = service_name;
	}

}
