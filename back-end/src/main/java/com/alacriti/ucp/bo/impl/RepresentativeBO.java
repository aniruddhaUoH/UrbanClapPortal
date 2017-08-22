package com.alacriti.ucp.bo.impl;

import java.sql.Connection;
import java.util.ArrayList;

import com.alacriti.ucp.dao.impl.DAOException;
import com.alacriti.ucp.dao.impl.RepresentativeDAO;
import com.alacriti.ucp.model.vo.RepresentativeVO;

public class RepresentativeBO extends BaseBO {

	public RepresentativeBO(Connection connection) {
		super(connection);
	}

	public void newRepresentative(RepresentativeVO rvo) throws DAOException,
			BOException {
		try {
			RepresentativeDAO rdao = new RepresentativeDAO(getConnection());
			rdao.addNewRepresentative(rvo);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
	}

	public ArrayList<RepresentativeVO> displayRepresentatives(
			String Service_name) throws DAOException, BOException {
		ArrayList<RepresentativeVO> representatives = null;
		try {

			RepresentativeDAO rdao = new RepresentativeDAO(getConnection());
			representatives = rdao.displayAllRepresentatives(Service_name);

		} catch (Exception e) {
			e.printStackTrace();
			throw new BOException();

		}
		return representatives;
	}
}
