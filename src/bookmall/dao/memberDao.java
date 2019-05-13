package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.memberVo;

public class memberDao extends bookmallConnection{
	public boolean insert(memberVo vo) {

		Boolean result = false;
		PreparedStatement pstmt = null;
		Connection con = null;

		try {

			con = getConnection();
			String sql = "insert into member values(null,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,vo.getName());
			pstmt.setString(2, vo.getPhone());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPassword());
			
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
	
	public List<memberVo> getList(){
		List<memberVo> list = new ArrayList <memberVo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next() == true) {
				//수정필요
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String password = rs.getString(5);
				
				memberVo vo= new memberVo();
				
				vo.setNo(no);
				vo.setName(name);
				vo.setPhone(phone);
				vo.setEmail(email);
				vo.setPassword(password);
				
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
