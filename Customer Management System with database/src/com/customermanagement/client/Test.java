package com.customermanagement.client;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.customermanagement.service.Online;
import com.customermanagement.serviceImpl.Amazon;



public class Test {

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException
	{
       Scanner sc=new Scanner(System.in);
		
		Online b=new Amazon();
		
		
		while(true)
		{
			System.out.println(" ");
			System.out.println("Enter 1 to Add_Customer_Data- ");
			System.out.println("Enter 2 to View the Customer_Datas- ");
			System.out.println("Enter 3 to Update Customer_Data-");
			System.out.println("Enter 4 for exit");
			System.out.println("\n");
			
			System.out.println("Enter Input Here-");
			int n=sc.nextInt();
			
			switch(n)
			{
			case 1: b.adddata();
			break;
			
			case 2: b.viewdata();
			break;
			
			case 3: b.updatedata();
			break;
			
			case 4: System.exit(n);
			
			
			}
		
		
	}
	

	}

}
