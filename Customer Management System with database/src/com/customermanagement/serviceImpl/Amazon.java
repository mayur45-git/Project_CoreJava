package com.customermanagement.serviceImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.customermanagement.connection.JdbcConnection;
import com.customermanagement.model.Customer;
import com.customermanagement.service.Online;

public class Amazon implements Online {
	
	Scanner sc=new Scanner(System.in);
	{
		System.out.println("Enter Number of Customers You want to Add-");
	}
	
	 

	int k=sc.nextInt();
	Customer cr[]=new Customer[k];
	int count=0;
	
	public void adddata() 
	{
		
		try {
			
			JdbcConnection jd= new JdbcConnection();
			Connection con=jd.getConnection();
			
			Customer c=new Customer();
			
			
			System.out.println("Is Person still a have Active Customer_Account at Amazon ?(true/false) -");
			Boolean status=sc.nextBoolean();
			c.setStatus(status);
			
			 System.out.println("Name of Customer to print Details with name-");
			 String name=sc.next();
			 PrintWriter pw=new PrintWriter(new FileWriter(name,true));
			
			 pw.println("********-CUSTOMER_DETAILS-**********");
			 pw.println();
			 
			 if(status==true)
			 {
				 
				 System.out.println("Add Customer Details");
				 
				 System.out.println("Enter Customer's Id Number-");
					int cid=sc.nextInt();
					c.setCid(cid);
					pw.println("Customer Id-"+cid);
					
					System.out.println("Enter Customer Name here-");            
					String cname=sc.next();
					c.setCname(cname);
					pw.println("Name of the Customer -"+cname);
					
					System.out.println("Enter Customer Age here-");              
					int cage=sc.nextInt();
					c.setCage(cage);
					pw.println("Age of the Customer -"+cage);
					
					System.out.println("Enter Customer Mobile Number here-");              
				    long cmobno=sc.nextLong();
					c.setCmobno(cmobno);
					pw.println("Mobile Number of the Customer -"+cmobno);
					
					
					pw.println();
					pw.flush();
					pw.close();
					
					String sql="insert into Customer values("+cid+",'"+cname+"',"+cage+","+cmobno+")";
					Statement smt=con.createStatement();
					smt.execute(sql);
					con.close();
				}	
				else
				{
				   System.out.println("Customer should have active membership of Amazon to add Details.");
				}
					cr[count]=c;
					count++;
			
			} catch (Exception e) 
		       {
				System.out.println("Exception at adding "+e);
		       }
		
			}
				
  		
				
	public void viewdata() 
	{
		try {
			JdbcConnection jd= new JdbcConnection();
			Connection con=jd.getConnection();

			String sql="Select * from customer";
			Statement smt=con.createStatement();
			ResultSet rs=smt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getInt(3));
				System.out.println(rs.getLong(4));
				
			}
				} catch (Exception e) {
					
			
		}
		
		
		
		
	}
	
	
	
	public void updatedata() throws IOException, ClassNotFoundException, SQLException 
	{
		JdbcConnection jd= new JdbcConnection();
		Connection con=jd.getConnection();
		
		System.out.println("Enter Customer name to be updated.");
		String name=sc.next();
		
		System.out.println("Enter Customer age to be updated.");
		int age=sc.nextInt();
		
		System.out.println("Enter Customer mobile number to be updated.");
		long mob=sc.nextLong();
		
		System.out.println("Enter Customer id update data.");
		String id=sc.next();
		
		String sql="update customer set cname='"+name+"',cage="+age+",cmob="+mob+" where cid="+id+"";
		Statement smt=con.createStatement();
		smt.execute(sql);
		con.close();
		
	}

}
