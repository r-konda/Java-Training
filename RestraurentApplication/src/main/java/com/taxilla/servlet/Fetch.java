//package com.taxilla.servlet;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class Fetch extends HttpServlet 
//{
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException 
//	{
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
//		String id=request.getParameter("id");
//		String name=request.getParameter("name");
//		String mobile=request.getParameter("mobile");
//		
//		Connection con=null;
//		Statement statement=null;
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema?user=root&password=0282");
//			String selectQuery="SELECT * FROM employee_schema.castumor";
//			out.print("<table width=25% border=1>");
//			out.print("<h2 style=\"color:Tomato;\">Display the castumor details</h2>");
//			 statement= con.createStatement();
//			 ResultSet rs= statement.executeQuery(selectQuery);
//			ResultSetMetaData rsmd=rs.getMetaData();
//			out.print("<tr>");
//			out.print("<th style=\"color:Tomato;\">"+rsmd.getColumnName(1)+"</th>");
//			out.print("<th style=\"color:Tomato;\">"+rsmd.getColumnName(2)+"</th>");
//			out.print("<th style=\"color:Tomato;\">"+rsmd.getColumnName(3)+"</th>");
//			
//			
//
//			out.print("</tr>");
//			while(rs.next())
//			{
//				out.print("<tr>");
//				out.print("<td>"+rs.getString(1)+"</td>");
//				out.print("<td>"+rs.getString(2)+"</td>");
//				out.print("<td>"+rs.getString(3)+"</td></tr>");
//				
//			
//			}
//			
//			
//			out.print("<td colspan=1><button class=\"btn\"> <a href=\"castumor.html\" /> Back </button></td></tr>");
//			out.print("</table");
//			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally
//		{
//
//			out.close();
//			try {
//				statement.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//	}
//
//	
//
//}
