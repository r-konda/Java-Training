<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
/** get the parameter values associated with request object of HTML form fields **/  
String Name = request.getParameter("Name");
String PhoneNo = request.getParameter("PhoneNo");

try {
	if(Name == null || Name.trim().isEmpty() || PhoneNo == null || PhoneNo.trim().isEmpty() || PhoneNo.trim().length() != 10) {
		String redirectURL = "castumor.html";
		response.sendRedirect(redirectURL);
		session.setAttribute("errorMessage", "Name or PhoneNumber is not valid");
		return;
	}	
	/** for loading Driver classes **/ 
	Class.forName("com.mysql.jdbc.Driver");
	/** To Make The Connection **/ 
	Connection conn = DriverManager
	.getConnection("jdbc:mysql://localhost:3306/employee_schema?user=root&password=0282");
	/** Create The Statement object **/ 
	Statement st = conn.createStatement();
	/** To Insert The Data In DB **/  
	int i = st
	.executeUpdate("insert into employee_schema.castumor(name,mobile)values('" + Name + "','" + PhoneNo + "')");
	if (i > 0)
	{
		out.println("Data is successfully inserted!");
		/** To Fetch Name and mobile from DB  **/  
		String sql = "select * from employee_schema.castumor where name= ? and mobile= ?";
		/** To Create PreparedStatement Object using prepareStatement Method **/  
		PreparedStatement upd = conn.prepareStatement(sql);
		upd.setString(1, Name);
		upd.setString(2, PhoneNo);
		/** To Execute Query using executeQuery Method **/  
		ResultSet rs = upd.executeQuery();
		/** Initially Declared String variable **/  
		String id = "";
		while (rs.next())
		{
	      id = rs.getString("id");
		}
		/** To Print Id **/
		out.println(id);
		request.getSession().setAttribute("custId", id);
		/**To redirect response to another resource **/
		response.sendRedirect("home.html");
	} else 
	{
		
		String redirectURL = "http://localhost:8085/RestraurentApplication/castumor.html";
		/**To redirect response to another resource **/
		response.sendRedirect(redirectURL);
	}

} catch (Exception e) {
	System.out.print(e);
	e.printStackTrace();
}
%>
