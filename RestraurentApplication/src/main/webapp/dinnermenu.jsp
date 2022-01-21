<%@ page import="java.sql.*"%>
<html>
<body>
	<h2>
		<font color='Red'>Dinner Menu Details</font>
	</h2>
	<form action="calculation.jsp" method="get">
		<table border="1" width="30%" height="30%">
			<tr>
				<th><font color='Red'>Id</font></th>
				<th><font color='Red'>Name</font></th>
				<th><font color='Red'>Price</font></th>
				<th><font color='Red'>Select</font></th>
			</tr>
			<%
			/** for loading Driver classes **/  
			Class.forName("com.mysql.jdbc.Driver");
			/** To Make The Connection **/
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema?user=root&password=0282");
			/** Create The Statement object **/  
			Statement stmt = con.createStatement();
			/** To Fetch The Data From DB **/ 
			ResultSet rs = stmt.executeQuery("select *  from dinnermenu  ");
			while (rs.next()) {
				String Id = rs.getString("id");
				String Name = rs.getString("name");
				int Price = rs.getInt("price");
			%>
			<tr>
				<td><b><font color='#663300'><%=Id%></font></b></td>
				<td><b><font color='#663300'><%=Name%></font></b></td>
				<td><b><font color='#663300'><%=Price%></font></b></td>
				<td><input type="checkbox" name="selected" value=<%=Id%>></td>
			</tr>
			<%
			}
			/** This method is used to save an object in session 
			by assigning a unique string to the object. **/  
			session.setAttribute("table", "employee_schema.customer_dinnermenu");
			%>
			<tr>
				<td colspan="3"><input type="submit" value="Submit"></input></td>
			   <td colspan="3"><input type="reset" value="Reset"></input></td>
				
			</tr>
		</table>
		<br> <br />
		<button class=\"btn\">
			<a href="home.html" />Home Page
		</button>
	</form>
</body>
</html>