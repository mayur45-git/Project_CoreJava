package com.customermanagement.serviceImpl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


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
	
	public void adddata() throws IOException
	{
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
			}	
			else
			{
			   System.out.println("Customer should have active membership of Amazon to add Details.");
			}
				cr[count]=c;
				count++;
			}
				
  		
				
	public void viewdata() throws IOException
	{

		if(count>0)
		{
			System.out.println("Enter Customer Id of Customer you want to view Details-");
			int g=sc.nextInt();
			
			
			
			for(int i=0;i<count;i++)
			{
				if(cr[i].getCid()==g)
				{
					 System.out.println("Name of Customer you want to view  Details-");
					 String name=sc.next();
					 BufferedReader br=new BufferedReader(new FileReader(name));
					
					String s=br.readLine();
					while(s!=null)
					{
						System.out.println(s);
						s=br.readLine();
					}
					System.out.println("Displaying All details about Customer");
					
					System.out.println("Customer Id- "+cr[i].getCid());
					System.out.println("Customer Name- "+cr[i].getCname());
					System.out.println("Customer Age- "+cr[i].getCage());
					System.out.println("Customer Mobile Number- "+cr[i].getCmobno());
				}
				
			}
			
	     }
		
	}
	
	
	
	public void updatedata() throws IOException 
	{
		if(count>0)
		{
			System.out.println("Enter Cutomer Id of Customer to update the Details- ");
			 int cust_id=sc.nextInt();
			 
			 System.out.println("Enter Customer Name to see the Updated Customer_Account Details-");
			 
			 String name=sc.next();
			 BufferedWriter bw=new  BufferedWriter(new FileWriter(name,true));
			 bw.newLine();
			 bw.write("-*****Updated Customer Details*****-");
			 bw.newLine();
			 
			 for(int i=0;i<count;i++)
			 { 
			 if(cust_id==cr[i].getCid())
			 {
				boolean object=true;
				while(object) 
				{ 
					System.out.println("Enter 1 to edit Customer's Age-");
					System.out.println("Enter 2 to edit Customer's Mobile Number-");
					System.out.println("Enter 3 for Done Editing-");
					
					int u=sc.nextInt();
					switch(u)
					{
					case 1: System.out.println("Customer's Age(Before)- " +cr[i].getCage());
					        System.out.println("Enter Customer's Age now-");
					        int l=sc.nextInt();
					        cr[i].setCmobno(l);
					        bw.write("Customer's Age(Before)- " +cr[i].getCage());
					        bw.newLine();
					        bw.write("Customer's Age Now-"+l);
					        bw.newLine();
					        System.out.println("Customer's Age Updated Successfully.");
					 break;
					 
					 case 2: System.out.println("Old Mobile Number of Customer- " +cr[i].getCmobno());
			                System.out.println("Enter new Mobile Number-");
			                long j=sc.nextLong();
			                cr[i].setCmobno(j);
			                bw.write("Old Mobile Number of Customer- "+cr[i].getCmobno());
			                bw.newLine();
			                bw.write("Updated Customer's Mobile Number-"+j);
					        bw.newLine();
					        bw.flush();
					        bw.close();
			                System.out.println("Customer's Mobile Number Updated Successfully.");
			         break;
			         
					 case 3: System.out.println("All Details Updated succesfuly");
						    
						    object=false;
						    while(object)
						    {
						    	
						    }
						    	
						    
					         
					      break;					         
					  }
				}
			 }
			 else
			 {
				 System.out.println("Invalid Customer Id");
			 }
		     }
		}
		
		
	}

}
