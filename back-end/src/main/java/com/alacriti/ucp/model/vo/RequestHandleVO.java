package com.alacriti.ucp.model.vo;

public class RequestHandleVO {
	private String Username;
	private String Service_name;
	private String Service_status;

	public RequestHandleVO() {
		super();
	}

	public RequestHandleVO(String Username, String Service_name,
			String Service_status) {
		super();
		this.Username = Username;
		this.Service_name = Service_name;
		this.Service_status = Service_status;
	}

	public String getService_status() {
		return Service_status;
	}

	public void setService_status(String service_status) {
		Service_status = service_status;
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
