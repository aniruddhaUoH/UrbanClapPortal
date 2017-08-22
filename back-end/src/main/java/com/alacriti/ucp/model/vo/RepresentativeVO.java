package com.alacriti.ucp.model.vo;

public class RepresentativeVO {
	private String R_name;
	private String R_phone;
	private int Service_cost;
	private String Service_name;

	public RepresentativeVO() {
		super();
	}

	public RepresentativeVO(String R_name, String R_phone, int Service_cost,
			String Service_name) {
		super();
		this.R_name = R_name;
		this.R_phone = R_phone;
		this.Service_cost = Service_cost;
		this.Service_name = Service_name;
	}

	public RepresentativeVO(String R_name, String R_phone, int Service_cost) {
		super();
		this.R_name = R_name;
		this.R_phone = R_phone;
		this.Service_cost = Service_cost;
	}

	public String getR_name() {
		return R_name;
	}

	public void setR_name(String r_name) {
		R_name = r_name;
	}

	public String getR_phone() {
		return R_phone;
	}

	public void setR_phone(String r_phone) {
		R_phone = r_phone;
	}

	public int getService_cost() {
		return Service_cost;
	}

	public void setService_cost(int service_cost) {
		Service_cost = service_cost;
	}

	public String getService_name() {
		return Service_name;
	}

	public void setService_name(String service_name) {
		Service_name = service_name;
	}

}
