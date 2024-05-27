package com.wipro.Task1;

import java.sql.*;
import java.util.Scanner;

public class DMLoperation {

	  public static void addProduct(Connection conn)throws  SQLException {
		
		   
		   
		   Scanner sc=new Scanner(System.in);
		   try {
		   PreparedStatement pst=  conn.prepareStatement("insert into ProductList values(?,?,?)");
		   System.out.println("enter product Info.");
		   System.out.print("Enter product id: ");
			 int id=sc.nextInt();	sc.nextLine();
			 System.out.print("Enter product name: ");
			String name=sc.nextLine();  
			System.out.print("Enter product product price: ");
			 int price=sc.nextInt();
			
			//set data
			 pst.setInt(1, id);
			 pst.setString(2,name);
			 pst.setInt(3,price);
			 pst.execute();
			 System.out.println("Product inserted successfully");
		   }
		   catch(Exception e) {
			   System.out.println("Something went wrong..!!");
		   }
		  
	  }
	  
	  public static void deleteProduct(Connection conn) throws SQLException{
		  
		  Scanner sc= new Scanner(System.in);
		  try {
		  PreparedStatement pst=  conn.prepareStatement("delete from ProductList where id= ?");
		  System.out.print("Enter product id: ");
			 int id=sc.nextInt();
			 pst.setInt(1, id);
			 pst.execute();
			 System.out.println("delete the product successfully..!");
		  }
		  catch(Exception e) {
			  System.out.println("Something went wrong");
		  }
			 }
	  
	  public static void updateProduct(Connection conn) {
		  Scanner sc=new Scanner(System.in);
		  
		  try {
			 
			  PreparedStatement pst=  conn.prepareStatement("update ProductList set name=?, price=?  where id= ?");
			  System.out.println("enter product detail");
			  
			   
			  System.out.print("Enter product id: ");
				 int id=sc.nextInt();	sc.nextLine();//clear buffer
				 System.out.print("Enter product name: ");
				String name=sc.nextLine();  
				System.out.print("Enter product product price: ");
				 int price=sc.nextInt();
				 
				 pst.setString(1, name);
				 pst.setInt(2, price);
				 pst.setInt(3, id);
				 pst.execute();
				 
				 System.out.println("record updated sucessfully");
				 }
		  catch(Exception e) {
			  System.out.println("Something went wrong..!");
		  }
		  
	  }
	  
	
	  public static void listProducts(Connection con) throws SQLException {
		  Statement st=con.createStatement();
		  ResultSet rs=st.executeQuery("select * from ProductList");
		  while(rs.next()) {
			  System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		  }
	  }
	  
	public static void main(String[] args) throws SQLException, ClassNotFoundException   {
      Class.forName("oracle.jdbc.OracleDriver");
        
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:9501/XE","system","rps@123");
        
        System.out.println("connected");
        
       //Statement st=con.createStatement();
		
        //st.executeUpdate("create table ProductList(id number primary key,name varchar(10),price number)");
	    
        
       addProduct(con);
       deleteProduct(con);
        
        updateProduct(con);
        
        listProducts(con);
        
        

	}

}
