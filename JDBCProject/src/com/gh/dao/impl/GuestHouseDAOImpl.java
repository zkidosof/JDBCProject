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
import com.gh.vo.GuestHouse;

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

	
	public void closeAll(PreparedStatement ps, Connection conn) throws DMLException {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();			
		} catch (SQLException e) {
			throw new DMLException("DB 연결해제에 실패했습니다.");
		}
	}


	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws DMLException {
		try {
			if(rs != null) rs.close();
			closeAll(ps, conn);
		} catch (SQLException e) {
			throw new DMLException("DB 연결해제에 실패했습니다.");
		}
	}

	@Override
	public Map<String, Integer> getTotalSalesPerGuestHouse() throws RecordNotFoundException, DMLException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * gus_num INT PRIMARY KEY, -- 게스트하우스 번호 
	 * service_name VARCHAR(10), -- 서비스이름 (FK)
	 * gus_name VARCHAR(10), -- 이름 
	 * gus_address VARCHAR(30), -- 주소 
	 * gus_price INT, -- 가격
	 * gus_capacity INT, -- 수용인원
	 */
	
	@Override
	public void registerGuestHouse(GuestHouse guestHouse) throws DuplicateException, DMLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query = "INSERT INTO guestHouse(name, address, price, capacity) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, guestHouse.getName());
			ps.setString(2, guestHouse.getAddress());
			ps.setInt(3, guestHouse.getPrice());
			ps.setInt(4, guestHouse.getCapacity());
			System.out.println(ps.executeUpdate() +"명 등록성공");
			
			
		}catch(SQLException e) {
			throw new DMLException("등록중 오류"+e.getMessage());
		}finally {
			closeAll(ps, conn);
		}
		
	}

	@Override
	public void updateGuestHouse(GuestHouse guestHouse) throws RecordNotFoundException, DMLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query = "UPDATE guestHouse SET name=?, address=?, price=?, capacity=? WHERE num =?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, guestHouse.getName());
			ps.setString(2, guestHouse.getAddress());
			ps.setInt(3, guestHouse.getPrice());
			ps.setInt(4, guestHouse.getCapacity());
			ps.setInt(5, guestHouse.getNum());
			System.out.println(ps.executeUpdate() +"명 수정함");
			
			
		}catch(SQLException e) {
			throw new DMLException("수정중 오류");
		}catch(Exception e){
			throw new RecordNotFoundException("해당 게하없음");
			
		}finally {
			closeAll(ps, conn);
		}
		
	}


	@Override
	public void deleteGuestHouse(int guestHouseId) throws RecordNotFoundException, DMLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query = "DELETE FROM guestHouse WHERE num =?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, guestHouseId);	
			
			System.out.println(ps.executeUpdate() +"명 삭제함");
			
			
		}catch(SQLException e) {
			throw new DMLException("게하 삭제중 오류");
			
		}finally {
			closeAll(ps, conn);
		}
		
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
