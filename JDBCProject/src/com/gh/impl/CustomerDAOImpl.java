package com.gh.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.gh.dao.CustomerDAO;
import com.gh.exception.DMLException;
import com.gh.exception.DuplicateSSNException;
import com.gh.exception.RecordNotFoundException;
import com.gh.vo.Customer;
import com.gh.vo.GuestHouse;
import com.gh.vo.Reservation;

import config.ServerInfo;

public class CustomerDAOImpl implements CustomerDAO{
	// 싱글톤
	private static CustomerDAOImpl dao = new CustomerDAOImpl();
	
	public CustomerDAOImpl() {
		System.out.println("Singletone Creating...");
	}
	
	public static CustomerDAOImpl getInstance() {
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
	public void registerCustomer(Customer customer) throws DuplicateSSNException, DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomer(Customer customer) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(int customerId) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addReservation(Reservation reservation) throws DuplicateSSNException, DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateReservation(Reservation reservation) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelReservation(int reservationId) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Reservation> getAllReservation(int customerId) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GuestHouse> getGuestHousesByRegion(String Region) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCustomerGrade(int customerId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GuestHouse> getAllGuestHouses() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRemainingCapacity(String guestHouseName) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GuestHouse> getGuestHouses(String service) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculatePriceByDay(String guestHouseName, Date date) throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
