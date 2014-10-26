package tyokin;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager{
	public static Connection getConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:8889/kr1","root","root");
			
			return con;
		}catch(Exception e){
			throw new IllegalStateException(e);
		}
	}
	public static void main(String[] args) throws Exception{
		Connection con = getConnection();
		System.out.println("con="+con);
		con.close();
	}
}