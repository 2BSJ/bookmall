package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.book_orderVo;
import bookmall.vo.ordersVo;

public class ordersDao extends bookmallConnection{
	Long no = 0L;
	public boolean insert(ordersVo vo) {

		Boolean result = false;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		
		try {

			con = getConnection();
			String sql = "insert into orders values(null,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, vo.getOrdernum());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setString(3, vo.getDestination());
			pstmt.setLong(4, vo.getMember_no());
			
			int count = pstmt.executeUpdate();
			
			sql = "select last_insert_id()";
			pstmt = con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				no = rs.getLong(1);
			}
			
			
			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( con != null ) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		

		return result;
	}
	
	
	
	
	//--------------------------------
	
	public boolean insert(book_orderVo vo) {

		Boolean result = false;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		Connection con = null;
		ResultSet rs = null;
		try {

			con = getConnection();
			String sql = "insert into book_order values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBook_no());
			pstmt.setLong(2, 1L);
			pstmt.setInt(3, vo.getAmount());
			
			int count = pstmt.executeUpdate();
			
			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( con != null ) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		

		return result;
	}
	
	// -----------------------
	
	public List<ordersVo> getList(){
		List<ordersVo> list = new ArrayList <ordersVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "SELECT a.no,a.ordernum,a.price,a.destination,b.no,b.name,b.phone " + 
						 "from bookmall.orders a, bookmall.member b " + 
						 "where a.member_no = b.no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				Long no = rs.getLong(1);
				String ordernum = rs.getString(2);
				int price = rs.getInt(3);
				String destination = rs.getString(4);
				Long member_no = rs.getLong(5);
				String membername = rs.getString(6);
				String memberphone = rs.getString(7);
				
				ordersVo vo= new ordersVo();
				
				vo.setNo(no);
				vo.setOrdernum(ordernum);
				vo.setPrice(price);
				vo.setDestination(destination);
				vo.setMember_no(member_no);
				vo.setMembername(membername);
				vo.setMemberphone(memberphone);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( con != null ) {
					con.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return list;
	}
	
	public List<book_orderVo> getBookOrderList(Long orderNo){
		
		List<book_orderVo> list = new ArrayList <book_orderVo>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select b.name,b.price,a.amount from book_order a, book b where a.book_no = b.no";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				String name = rs.getString(1);
				int price = rs.getInt(2);
				int amount = rs.getInt(3);
				
				book_orderVo vo= new book_orderVo();
				
				vo.setBookname(name);
				vo.setBookprice(price);
				vo.setAmount(amount);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( con != null ) {
					con.close();
				}
 			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return list;
	}
	}

