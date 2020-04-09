package com.PAFproject.HealthCare;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType; 

@Path("onlinepayment")
public class PaymentResource 
{
	@GET
	@Path("/paymentdetails")
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public ArrayList<Payment> getAllPayment() throws Exception
	{
		PaymentHandler handler = new PaymentHandler();
		return handler.getAllPayment();
	}
	
	@GET
	@Path("user/{id}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_JSON})
	public Payment getFromId(@PathParam("id") int id) throws SQLException
	{
		PaymentHandler handler = new PaymentHandler();
		return handler.getPaymentDetails(id);
	}

	@POST
	@Path("/savepayment")
	public String inerstPayment(Payment p) throws SQLException
	{
		PaymentHandler handler = new PaymentHandler();
		String s = handler.insertPaymentDetails(p);
		
		return s;
	}

	@DELETE
	@Path("/deletePayment/{id}")
	public void deletePayment(@PathParam("id") int id) throws SQLException
	{
		PaymentHandler handler = new PaymentHandler();
		handler.deletePaymentDetails(id);
	}
	
	@PUT
	@Path("/update")
	public void updatePayment(Payment p) throws SQLException
	{
		PaymentHandler handler = new PaymentHandler();
		handler.insertPaymentDetails(p);
	}

}
