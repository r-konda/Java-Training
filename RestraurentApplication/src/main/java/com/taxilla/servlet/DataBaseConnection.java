//package com.taxilla.servlet;
//
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//
//import javax.servlet.http.HttpServletResponse;
//
//public class DataBaseConnection 
//{
//	public Connection getConnection()
//	{
//		Connection con=null;
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema?user=root&password=0282");
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		return con;
//	}
//	public String insertData(CostumerDetails costumerDetails)
//	{
//
//		Connection con=getConnection();
//		String qurey="insert into castumor (name, mobile) values(?,?)";
//		try
//		{
//		PreparedStatement ps=con.prepareStatement(qurey);  
////				ps.setString(1,costumerDetails.getId());  
//				ps.setString(1,costumerDetails.getName());  
//				ps.setString(2,costumerDetails.getMobile());  
//				int result1=ps.executeUpdate();
//				if(result1>0)
//				{
//					return "customer registration successfully done";
//				}
//				else
//				{
//					return "something went wrong";
//				}
//		}
//		catch (Exception e2) 
//		{
//			System.out.println(e2);
//			return "Already given ID existed";
//		}		
//	}
//	
//	public void morningMenu(HttpServletResponse response, PrintWriter out) throws SQLException
//	{
//		commonMenu(response, out, "morning");
//	}
//	public void lunchMenu(HttpServletResponse response, PrintWriter out) throws SQLException
//	{
//		commonMenu(response, out, "lunch");	
//	}
//	
//	public void dinnerMenu(HttpServletResponse response, PrintWriter out) throws SQLException
//	{
//		commonMenu(response, out, "dinner");
//	}
//	
//	public void commonMenu(HttpServletResponse response, PrintWriter out, String time) throws SQLException {
//		
//		Connection con=null;
//		PreparedStatement ps=null;
//		DataBaseConnection dataBaseConnection=new DataBaseConnection();
//		try
//		{
//			con=dataBaseConnection.getConnection();
//			ps=con.prepareStatement("select * from employee_schema."+time+"menu");
//			out.print("<table width=25% border=1>");
//			out.print("<h2 style=\"color:Tomato;\">"+ time.substring(0, 1).toUpperCase()+time.substring(1).toLowerCase() + " Details: </h2>");
//			ResultSet rs = ps.executeQuery();
//			ResultSetMetaData rsmd=rs.getMetaData();
//			out.print("<tr>");
//			out.print("<th style=\"color:Tomato;\">"+rsmd.getColumnName(1)+"</th>");
//			out.print("<th style=\"color:Tomato;\">"+rsmd.getColumnName(2)+"</th>");
//			out.print("<th style=\"color:Tomato;\">"+rsmd.getColumnName(3)+"</th>");
//			out.print("<th style=\"color:Tomato;\">"+rsmd.getColumnName(4)+"</th>");
//			while(rs.next()) 
//			{
//				out.print("<tr><td>"+rs.getString(1)+"</td>");
//				out.print("<td>"+rs.getString(2)+"</td>");
//				out.print("<td>"+rs.getString(3)+"</td>");
//				out.print("<td><input type=\"checkbox\"></td>");
//				
//			}
//			out.print("<tr><td colspan=2><button class=\"btn\"> <a href=\"home.html\" /> Back </button></td>");
//			out.print("<td colspan=3><button class=\"btn\"> Submit </button></td></tr>");
//			out.print("</table");
//		}
//		catch(Exception e)
//		
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//			con.close();
//			ps.close();
//			
//		}
//		
//		
//	}
//
//
//
//}
