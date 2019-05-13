package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.bookVo;

public class bookDao extends bookmallConnection {
	public boolean insert(bookVo vo) {

		Boolean result = false;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {

			con = getConnection();
			String sql = "insert into book values(null,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getPrice());
			pstmt.setLong(3, vo.getCategory_no());
			
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
	
	public List<bookVo> getList(){
		List<bookVo> list = new ArrayList <bookVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select b.no,b.name,b.price,b.category_no,c.name" + 
					" from book b, category c" + 
					 " where b.category_no = c.no;";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				int price = rs.getInt(3);
				Long categoryNo = rs.getLong(4);
				String categoryName = rs.getString(5);
				
				bookVo vo= new bookVo();
				
				vo.setNo(no);
				vo.setName(name);
				vo.setPrice(price);
				vo.setCategory_no(categoryNo);
				vo.setCategoryName(categoryName);
				
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
