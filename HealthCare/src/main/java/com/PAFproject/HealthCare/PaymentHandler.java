package com.PAFproject.HealthCare;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class PaymentHandler 
{
	public ArrayList<Payment> getAllPayment() throws SQLException
	{
		ArrayList<Payment> list = new ArrayList();
		String qry = "SELECT * FROM payment";
		connection c = new connection();
		ResultSet rs = c.getRs(qry);
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 	
			
			while(rs.next())
			{
				Payment p = new Payment();
				p.setPtid(rs.getInt(1));
				p.setUid(rs.getInt(2));
				p.setAppid(rs.getInt(3));
				p.setPrice(rs.getDouble(4));
				Date date = rs.getDate(5);
				p.setDte(dateFormat.format(date));
				
				list.add(p);
			}
			c.con.close();
			return list;
			
	}

	public Payment getPaymentDetails(int id) throws SQLException
	{
		String qry = "SELECT * FROM `payment` WHERE id = "+id+"";
		connection c = new connection();
		ResultSet rs = c.getRs(qry);
		DateFormat dateFormat = new SimpleDateFormat("dd-M-yyyy hh:mm:ss"); 
		Payment p = new Payment();
		
		while(rs.next())
		{
			
			p.setPtid(rs.getInt(1));
			p.setUid(rs.getInt(2));
			p.setAppid(rs.getInt(3));
			p.setPrice(rs.getDouble(4));
			Date date = rs.getDate(5);
			p.setDte(dateFormat.format(date));
		}
		c.con.close();
		
		return p;
	}
	
	public String insertPaymentDetails(Payment p) throws SQLException
	{
		connection c = new connection();
		String sql = "INSERT INTO `payment` (`userid`, `appointmentid`, `price`) VALUES (?,?,?)";
		PreparedStatement ps = c.getPs(sql);
		
		ps.setInt(1, p.getUid());
		ps.setInt(2,p.getAppid());
		ps.setDouble(3, p.getPrice());
		
		if(!ps.execute())
		{
			c.con.close();
			return "successfully inserted";
		}
		else
		{
			c.con.close();
			return "insertion unsuccessful";
		}
		
		
	}

	public void deletePaymentDetails(int id) throws SQLException
	{
		connection c = new connection();
		String qry = "DELETE FROM `payment` WHERE id = ?";
		PreparedStatement ps = c.getPs(qry);
		
		ps.setInt(1,id);
		
		if(!ps.execute())
		{
			System.out.println("successfully inserted");
		}
		else
		{
			System.out.println("insertion unsuccessful");
		}
	}
	
	public void updatePaymentDeails(Payment p)throws SQLException
	{
		connection c = new connection();
		String sql = "update users set uid = ? , appointmentid = ?, price ? where id = ?";
	    PreparedStatement ps = c.getPs(sql);
	    ps.setInt(1, p.getUid());
	    ps.setInt(2, p.getAppid());
	    ps.setDouble(3, p.getPrice());
	    ps.setInt(4,p.getPtid());
	    
	    if(!ps.execute())
	    {
	    	System.out.println("successfully inserted");
	    }
	    else
	    {
	    	System.out.println("insertion unsuccessful");
	    }
	}
}
