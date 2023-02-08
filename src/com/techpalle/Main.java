package com.techpalle;

import java.sql.SQLException;

public class Main {

	
		public static void main(String args[])
		{
			//crud.creating();
			/*ArrayList<student>all= crud.getalltabledata();
			for(student i : all)
			{
				System.out.println(i.getSid());
				System.out.println(i.getSname());
				System.out.println(i.getSubject());
				System.out.println(i.getSemail());
			}*/
			
			try {
				crud.inserting("vijjay", "lxktb","lmmmail.com");
				//crud.updating(2, "shain", "mno","gmail.com");
				//crud.deleting(1);
			}	
			catch (ClassNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}

	
