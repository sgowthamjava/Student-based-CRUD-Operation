	package com.techpalle;

	public class student 
	{
	 private int  sid;
	 private String sname;
	 private String subject;
	 private String semail;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public student(int sid, String sname, String subject, String semail) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.subject = subject;
		this.semail = semail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	 
	}

