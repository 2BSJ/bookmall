package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.bookVo;
import bookmall.vo.cartVo;

public class cartDao extends bookmallConnection{

	public boolean insert(cartVo vo) {

		Boolean result = false;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {

			con = getConnection();
			String sql = "insert into cart values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getBook_no());
			pstmt.setLong(2, vo.getMember_no());
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
	
	public List<cartVo> getList(){
		List<cartVo> list = new ArrayList <cartVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select a.book_no,a.member_no,a.amount , b.name , b.price  " + 
						 "from cart a,book b,member c " + 
						 "where a.book_no = b.no " + 
						 "  and a.member_no = c.no;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				//수정필요
				Long book_no = rs.getLong(1);
				Long member_no= rs.getLong(2);
				int amount = rs.getInt(3);
				String bookname = rs.getString(4);
				int bookprice = rs.getInt(5);
				
				cartVo vo= new cartVo();
				
				vo.setBook_no(book_no);
				vo.setMember_no(member_no);
				vo.setAmount(amount);
				vo.setBookname(bookname);
				vo.setBookprice(bookprice);
				
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
