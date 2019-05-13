package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bookmall.vo.categoryVo;

public class categoryDao extends bookmallConnection{
	public boolean insert(categoryVo vo) {

		Boolean result = false;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {

			con = getConnection();
			String sql = "insert into category values(null,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());

			
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
	
	public List<categoryVo> getList(){
		List<categoryVo> list = new ArrayList <categoryVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from category";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
			
				categoryVo vo= new categoryVo();
				
				vo.setNo(no);
				vo.setName(name);
				
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
