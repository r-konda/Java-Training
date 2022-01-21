//package com.taxilla.servlet;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//public class DinnerMenuBean
//{
//	 List<Object> allData=new ArrayList<Object>();
//     
//	    public String id,name,price;
//	    Object obj=new Object();
//	 
//	    public void setObj(Object obj) {
//	        this.obj = obj;
//	    }
//	    
//	    public List getDb_Data()
//	    {
//	        int i=0;
//	        try
//	        {
//	                String qry;
//	                Class.forName("com.mysql.jdbc.Driver");
//	                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_schema?user=root&password=0282");
//	                Statement s = con.createStatement();                
//	                qry="Select id,name,price from employee_schema.dinnermenu";
//	                ResultSet r=s.executeQuery(qry);
//	                while(r.next())
//	                {
//	                    DataFields d=new DataFields(r.getString(1), r.getString(2), r.getString(3));                    
//	                    allData.add(i,d);
//	                    i++;
//	                }
//	                 
//	        }
//	        catch(Exception ex)
//	        {
//	                
//	                System.out.println("Your query is not working" + ex);
//	        }
//	       return allData;
//	    }
//	    public String getId()
//	    {
//	        this.id=((DataFields)obj).id;
//	        return this.id;
//	    }
//	    public String getName()
//	    {
//	        this.name=((DataFields)obj).name;
//	        return this.name;
//	    }
//	    public String getPrice() {
//	        this.price=((DataFields)obj).price;
//	        return this.price;
//	    }
//	    public void setAllData(List<Object> allData) {
//			this.allData = allData;
//		}
//
//		public void setId(String id)
//		{
//			this.id = id;
//		}
//
//		public void setName(String name) 
//		{
//			this.name = name;
//		}
//
//		public void setPrice(String price)
//		{
//			this.price = price;
//		}
//	 
//	 
//	    public class DataFields
//	    {
//	        public String id,name,price;
//	 
//	        public DataFields(String  id,String  name,String  price)
//	        {
//	        	this.id=id;
//	            this.name=name;
//	            this.price=price;
//	        }
//	    }
//
//
//}
