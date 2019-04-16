package util;

import java.sql.*;
import java.util.Properties;

public class JdbcUtil {
	
	
	private static Properties p =new Properties();
	static{
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("./resources/db.properties"));
			Class.forName(p.getProperty("driverClassName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getCon(){
		
		try {
			return DriverManager.getConnection(p.getProperty("url"),
					p.getProperty("user"), 
					p.getProperty("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	// 关闭 资源try-catch alt+shift+z
	public static void close(Connection con, Statement stm, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stm != null) {
					stm.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void close(Connection con, Statement stm) {

		try {
			if (stm != null) {
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
