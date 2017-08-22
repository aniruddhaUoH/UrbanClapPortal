package com.alacriti.ucp.bo.impl;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.ucp.dao.impl.DAOException;
import com.alacriti.ucp.dao.impl.ServiceDAO;
import com.alacriti.ucp.model.vo.ServiceVO;

public class ServiceBO extends BaseBO {

	public ServiceBO(Connection connection) {
		super(connection);
	}

	public void newService(ServiceVO servicevo) throws DAOException,
			BOException {
		try {
			ServiceDAO servicedao = new ServiceDAO(getConnection());
			servicedao.createNewService(servicevo);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
	}

	public boolean deleteService(String Service_name) throws DAOException,
			BOException {
		try {
			ServiceDAO servicedao = new ServiceDAO(getConnection());

			return servicedao.deleteService(Service_name);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();
		}
	}

	public ArrayList<ServiceVO> displayService() throws DAOException,
			BOException {
		ArrayList<ServiceVO> services = null;
		try {

			ServiceDAO servicedao = new ServiceDAO(getConnection());
			services = servicedao.displayAllServices();

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
		return services;
	}

	public ArrayList<ServiceVO> searchByServiceName(String Service_name)
			throws DAOException, BOException {
		ArrayList<ServiceVO> services = null;
		try {

			ServiceDAO servicedao = new ServiceDAO(getConnection());
			services = servicedao.searchByServiceName(Service_name);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
		return services;
	}
}