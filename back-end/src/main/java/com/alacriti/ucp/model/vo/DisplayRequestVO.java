package com.alacriti.ucp.model.vo;

public class DisplayRequestVO {
	private String Service_name;
	private String Username;
	private String R_name;
	private String Service_status;

	public DisplayRequestVO() {
		super();
	}

	public DisplayRequestVO(String Service_name, String Username,
			String R_name, String Service_status) {
		super();
		this.Service_name = Service_name;
		this.Username = Username;
		this.R_name = R_name;
		this.Service_status = Service_status;
	}

	public DisplayRequestVO(String Service_name, String R_name,
			String Service_status) {
		super();
		this.Service_name = Service_name;
		this.R_name = R_name;
		this.Service_status = Service_status;
	}

	public String getService_name() {
		return Service_name;
	}

	public void setService_name(String service_name) {
		Service_name = service_name;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getR_name() {
		return R_name;
	}

	public void setR_name(String r_name) {
		R_name = r_name;
	}

	public String getService_status() {
		return Service_status;
	}

	public void setService_status(String service_status) {
		Service_status = service_status;
	}

}
