package reusableComponents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DataBaseOperations {
	
	HashMap<String,String> hmData;
	Connection con;
	Statement s;
	
	public synchronized void dbConnection() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/actitime","root","");
		System.out.println("DB Connection successful");
		s = con.createStatement();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized HashMap<String, String> getSingleUserDataInMap(String sql) {
		try {
			dbConnection();
			ResultSet result=s.executeQuery(sql);
			ResultSetMetaData md=result.getMetaData();
			System.out.println(result);
			
			hmData=new HashMap<>();
			while(result.next()) 
				for(int i=1;i<=md.getColumnCount();i++) 
					hmData.put(md.getColumnName(i), result.getString(i));
			System.out.println(hmData);
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return hmData;
	}
	
	public synchronized void createUpdateDeleteData(String sql) {
			try {
				dbConnection();
				s.executeQuery(sql);
				//System.out.println(sql+" --> query Executed successfully");
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}