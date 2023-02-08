package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class crud
{

	private static final String url="jdbc:mysql://localhost:3306/palle";
	private static String username="root";
	private static String password="admin";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	public static ArrayList<student> getalltabledata()
	{
		ArrayList<student>all= new ArrayList<student>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			s=con.createStatement();
        rs = s.executeQuery("select * from student");
        while (rs.next())
        {
        	int sid=rs.getInt("sno");
        	String sname=rs.getString("sname");
        	String subject=rs.getString("sub");
        String semail=rs.getString("email"); 
        student s=new student ( sid,sname,subject,semail );
        all.add(s); 
        }
        rs.close();
        s.close();
        con.close();
		}
		catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return all;
	}
	
	public static void creating ()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(url,username,password);
		s=con.createStatement();
		String qey =("create table student(sno int primary key auto_increment,sname varchar(50)"
				      + " not null,sub varchar(50),email varchar(50) unique)");
		s.executeUpdate(qey);
		} catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		finally {
			
			try {
				if(s!=null)
				{
				s.close();
				}
				if(con!=null)
				{
					con.close();	
				}
			} catch (SQLException e)
			{
				
				e.printStackTrace();
			}
		}
		
	}
	public static void inserting(String sname,String sub,String email) throws ClassNotFoundException, SQLException
	 {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			ps=con.prepareStatement("insert into student(sname,sub,email) values(?,?,?)");
			
			ps.setString(1,sname);
			ps.setString(2,sub);
			ps.setString(3,email);
			
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
		
	 }
	 public static void updating( int sno,String sname,String sub,String mail) throws ClassNotFoundException, SQLException
	 {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			ps=con.prepareStatement("update student set sname=?,sub=?,email=? where sno=?");
			
			ps.setString(1,sname);
			ps.setString(2,sub);
			ps.setString(3,mail);
			ps.setInt(4,sno);
			
			
			ps.executeUpdate();
			
			ps.close();
			con.close();

	 }
	 public static void deleting( int sno) throws ClassNotFoundException, SQLException
	 {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(url,username,password);
			
			ps=con.prepareStatement("delete from student where sno=?");
			
			
			ps.setInt(1,sno);
			
			
			ps.executeUpdate();
			
			ps.close();
			con.close();
	 }
 
}
