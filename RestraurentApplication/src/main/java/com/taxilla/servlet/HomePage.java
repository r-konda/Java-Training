//package com.taxilla.servlet;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class HomePage extends HttpServlet {
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException 
//	{
//		try {
//			DataBaseConnection conn = new DataBaseConnection();
//			String res = request.getParameter("agree");
//			PrintWriter out=response.getWriter();
//			switch (res) {
//			case "morning":
//				conn.morningMenu(response, out);
//				break;
//			case "lunch":
//				conn.lunchMenu(response, out);
//				break;
//			case "dinner":
//				conn.dinnerMenu(response, out);
//				break;
//			 default:
//				 System.out.println("please choose correct option ");
//				 break;
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//	}
//
//}
