package com.alacriti.ucp.biz.delegate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.ucp.bo.impl.RepresentativeBO;
import com.alacriti.ucp.model.vo.RepresentativeVO;

public class RepresentativeDelegate extends BaseDelegate {

	public void representativeAddDelegate(RepresentativeVO rvo)
			throws SQLException {

		boolean flag = false;
		Connection connection = null;
		try {
			connection = startDBTransaction();
			setConnection(connection);
			RepresentativeBO rbo = new RepresentativeBO(getConnection());
			rbo.newRepresentative(rvo);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}

	}

	public ArrayList<RepresentativeVO> representativeShowDelegate(
			String Service_name) throws SQLException {
		ArrayList<RepresentativeVO> representatives = null;
		boolean flag = false;
		Connection connection = null;
		try {

			connection = startDBTransaction();
			setConnection(connection);
			RepresentativeBO rbo = new RepresentativeBO(getConnection());
			representatives = rbo.displayRepresentatives(Service_name);

		} catch (Exception e) {
			e.printStackTrace();
			flag = true;
		} finally {
			endDBTransaction(connection, flag);
		}
		return representatives;
	}
}
