<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
/** Initially Declared  Double Variable **/  
double total = 0.0;
try {
	/** for loading Driver classes **/  
	Class.forName("com.mysql.jdbc.Driver");
	/** To Make The Connection **/  	
	Connection conn = DriverManager
	.getConnection("jdbc:mysql://localhost:3306/employee_schema?user=root&password=0282");
	/** Create The Statement object **/ 
	Statement st = conn.createStatement();
	/** Initially Declared String Variable With Value **/
	String colName = "morningMenuId";
	String tableName = session.getAttribute("table").toString();
	/** To Check The Conditions With Respective Values **/
	if (tableName.contains("lunch")) {
		colName = "lunchMenuId";
	} else if (tableName.contains("dinner")) {
		colName = "dinnerMenuId";
	}
	String select[] = request.getParameterValues("selected");
	if (select != null && select.length != 0) 
	{
		for (String selectedOne : select) 
		{
			/** To Insert The Data In DB **/  
	     int it = st.executeUpdate("insert into " + tableName + " (customerId," + colName + ")values('"
			+ Integer.valueOf(session.getAttribute("custId").toString()) + "','" + Integer.valueOf(selectedOne)
			+ "')");
	if (it > 0) {
		//out.println("Data is successfully inserted in DB");
	} else {
		String redirectURL = "http://localhost:8085/RestraurentApplication/castumor.html";
		/**To redirect response to another resource **/
		response.sendRedirect(redirectURL);
	}
		}
	}
	/** To Fetch The Data From DB **/
	String sql = "select * from " + tableName + " where customerId= ?";
	/** To Create PreparedStatement Object**/
	PreparedStatement upd = conn.prepareStatement(sql);
	/** To Set The Values**/
	upd.setInt(1, Integer.valueOf(session.getAttribute("custId").toString()));
	/** To Execute the Query **/
	ResultSet rs = upd.executeQuery();
	out.println("Your Selected Items Are: ");
%>
<br />
<br />
<%
while (rs.next()) {
	int itemId = rs.getInt(colName);
	/** To Declared String Value **/  
	String table = "employee_schema.morningmenu";
	/** To Check The Conditions **/  
	if (colName.contains("dinner"))
		table = "employee_schema.dinnermenu";
	else if (colName.contains("lunch"))
		table = "employee_schema.lunchmenu";
	/** To Fetch The Id From DB **/  
	String query = "select * from " + table + " where id= ?";
	/** To Create PreparedStatement Object **/  
	PreparedStatement stmt = conn.prepareStatement(query);
	stmt.setInt(1, itemId);
	/** To Execute The Query **/ 
	ResultSet prices = stmt.executeQuery();
	/** To Iterate The While Loop for Fetch The Data **/ 
	while (prices.next()) 
	{
		/** To Print Item Namer and Prices **/ 
		out.println(prices.getString("name") + " <====> " + prices.getDouble("price"));
%>
<br />
<%
/** To Get Prices Of Items From DB **/
total += prices.getDouble("price");

}

}
} 
catch (Exception e)
{
 System.out.print(e);
 e.printStackTrace();
}
%>
<br />
<%
out.print("<h3><font color='Red'>WELCOME TO TAXILLA RESTRAURENT 10% DISCOUNT OFFER</font></h3><br/>");
/** To Print Total Bill **/
out.print("Total Bill Before Discount: " + total);
%>
<br />
<%
if (total >= 1000) 
{
	total -= (total * 0.1);
	/** To Print Total Bill After Applying Discount **/
	out.print("Total Bill After Applying 10% Discount: " + total);
}
%>
<!-- <br></br>
<tr>
	<td colspan=2><button class=\"btn\">
			<a href="home.html" />Back
		</button></td> -->