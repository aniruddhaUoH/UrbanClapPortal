package com.alacriti.ucp.biz.delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.ucp.bo.impl.ServiceBO;
import com.alacriti.ucp.model.vo.ServiceVO;

public class ServiceDelegate extends BaseDelegate {

	public void serviceAddDelegate(ServiceVO servicevo) throws SQLException {

		boolean flag = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			ServiceBO servicebo = new ServiceBO(getConnection());
			servicebo.newService(servicevo);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
	}

	public boolean deleteService(String Service_name) {
		boolean rollBack = false;
		Connection connection = null;

		try {
			connection = startDBTransaction();
			setConnection(connection);
			ServiceBO servicebo = new ServiceBO(getConnection());
			return servicebo.deleteService(Service_name);
		} catch (Exception e) {
			e.printStackTrace();
			rollBack = true;
		} finally {
			endDBTransaction(connection, rollBack);
		}
		return false;
	}

	public ArrayList<ServiceVO> serviceShowDelegate() throws SQLException {
		ArrayList<ServiceVO> services = null;
		boolean flag = false;
		Connection connection = null;
		try {

			connection = startDBTransaction();
			setConnection(connection);
			ServiceBO servicebo = new ServiceBO(getConnection());
			services = servicebo.displayService();

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
		return services;
	}

	public ArrayList<ServiceVO> serviceSearchDelegate(String Service_name)
			throws SQLException {
		ArrayList<ServiceVO> services = null;
		boolean flag = false;
		Connection connection = null;
		try {

			connection = startDBTransaction();
			setConnection(connection);
			ServiceBO servicebo = new ServiceBO(getConnection());
			services = servicebo.searchByServiceName(Service_name);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
		return services;
	}
}