package com.alacriti.ucp.model.vo;

public class ServiceVO {
	private String Service_name;

	public ServiceVO() {
		super();
	}

	public ServiceVO(String Service_name) {
		super();
		this.Service_name = Service_name;
	}

	public String getService_name() {
		return Service_name;
	}

	public void setService_name(String service_name) {
		Service_name = service_name;
	}

}
