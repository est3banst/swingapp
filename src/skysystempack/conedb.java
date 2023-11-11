package skysystempack;
import java.sql.*;
public class conedb {

	Connection con;
	Statement stm;
	conedb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/skysys", "root", "");
			stm = con.createStatement();
			
			String query = "CREATE TABLE IF NOT EXISTS cuentas (passport varchar(30), name varchar(30), lname varchar(30), email VARCHAR(30), username varchar(20), password varchar(20), security varchar(100), answer varchar(100),"
					+ "PRIMARY KEY(passport))";
			
			stm.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new conedb();
	}
}
