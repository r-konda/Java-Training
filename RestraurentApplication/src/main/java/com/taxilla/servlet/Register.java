//package com.taxilla.servlet;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
//import java.sql.Statement;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class Register extends HttpServlet 
//{
//    public void init(ServletConfig config)
//    {
//        System.out.println("Servlet is being initialized");
//    }
//    
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
//	{
//	
//		CostumerDetails studentMembers=new CostumerDetails(request.getParameter("Name"), 
//				request.getParameter("PhoneNo"));
//		DataBaseConnection registerDataBase=new DataBaseConnection();
//		 String result=registerDataBase.insertData(studentMembers);
//		 PrintWriter out = response.getWriter();
//		 response.setContentType("text/html"); 
//		 out.println(result);
//		 if(result.equalsIgnoreCase("customer registration successfully done"))
//		 {
//		   RequestDispatcher ds = request.getRequestDispatcher("/home.html");
//		   ds.include(request, response);
//		 }
//		 else
//		 {
//			 RequestDispatcher ds = request.getRequestDispatcher("/castumor.html");
//			 ds.include(request, response);
//		 }
//
//	}
//
//}
