package com.alacriti.ucp.bo.impl;

import java.sql.Connection;

public class BaseBO {

	private Connection connection = null;

	public BaseBO() {
	}

	public BaseBO(Connection connection) {

		this.connection = connection;
	}

	public Connection getConnection() {

		return connection;
	}

	public void setConnection(Connection connection) {

		this.connection = connection;
	}
}
