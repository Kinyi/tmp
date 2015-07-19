package kinyi.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBC {

	public static Connection getConnection(){
		Connection Conn = null;
		try {
			Class.forName("org.apache.hive.jdbc.HiveDriver");
			Conn = DriverManager.getConnection("jdbc:hive2://192.168.80.100", "", "");
			System.out.println("hive连接成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("hive连接失败！");
		}
		return Conn;
	}
	
	public static void main(String[] args){
		
		Connection conn = getConnection();
		Statement statem = null;
		try {
			if (conn!=null) {
				statem = conn.createStatement();
				String sql = "show tables";
				ResultSet rs = statem.executeQuery(sql);
				ResultSetMetaData metaData = rs.getMetaData();
				while (rs.next()) {
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						System.out.println(rs.getString(metaData.getColumnName(i)));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}