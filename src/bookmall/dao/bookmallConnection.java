package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class bookmallConnection {

	public Connection getConnection() throws SQLException{

		Connection con = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			//String url = "jdbc:mariadb://192.168.1.46:3307/bookmall";
		    String url = "jdbc:mariadb://192.168.1.31:3307/bookmall";
			con = DriverManager.getConnection(url,"bookmall","bookmall"); // url , id , pwd
			//con = DriverManager.getConnection(url,"bookmall2",""); // url , id , pwd
		} catch (ClassNotFoundException e) {
			System.out.println("연결실패");
			e.printStackTrace();
		} //사용자가 강제로 로딩

		return con;


	}
}
