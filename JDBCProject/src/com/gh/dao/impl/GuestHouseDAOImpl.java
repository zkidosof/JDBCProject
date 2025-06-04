package com.gh.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.gh.dao.GuestHouseDAO;
import com.gh.exception.DMLException;
import com.gh.exception.DuplicateException;
import com.gh.exception.RecordNotFoundException;
import com.gh.vo.Customer;

import config.ServerInfo;

public class GuestHouseDAOImpl implements GuestHouseDAO {
	// 싱글톤
	private static GuestHouseDAOImpl dao = new GuestHouseDAOImpl();
	
	public GuestHouseDAOImpl() {
		System.out.println("Singletone Creating...");
	}
	
	public static GuestHouseDAOImpl getInstance() {
		return dao;
	}

	

	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASS);
		System.out.println("------데이타베이스 뚜뚜뚜-----");
		return conn;
	}

	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}


	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs != null) rs.close();
		closeAll(ps, conn);
	}

	@Override
	public Map<String, Integer> getTotalSalesPerGuestHouse() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerGuestHouse(GuestHouseDAO guestHouse) throws DuplicateException, DMLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGuestHouse(GuestHouseDAO guestHouse) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGuestHouse(int guestHouseId) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Integer> getUsageStatsByDate() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getSalesStatsByDate() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuestHouseDAO> getTop5GHByRevenue() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> assignCustomerGrades() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getAllGHReservations() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> getRegionGHReservation() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
