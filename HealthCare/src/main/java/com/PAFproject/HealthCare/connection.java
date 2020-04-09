package com.PAFproject.HealthCare;
import java.sql.*;

public class connection 
{
	protected Connection con;

	
	public connection() {
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/paf","root","");
			if(conn != null){
				System.out.println("Database Connection Successful");
				con = conn;
			}else
			{
				System.out.println("Database Connection Failed");
			}
			
		}
		catch (Exception e) {
			System.out.println("Database Connection Failed");

		}
	}

	public Connection getCon() {
		return con;
	}

	public ResultSet getRs(String qry) throws SQLException {
		Statement st = getSt();
		ResultSet rs = st.executeQuery(qry);
		return rs;
	}
	
	public PreparedStatement getPs(String sql) throws SQLException {
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}

	public Statement getSt() throws SQLException {
		Statement st = con.createStatement();
		return st;
	}

}
