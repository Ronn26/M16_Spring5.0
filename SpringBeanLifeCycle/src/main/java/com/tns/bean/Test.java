package com.tns.bean;

import java.sql.SQLException;

public class Test
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	  StudentDao d=new 	StudentDao();
	  d.selectAllRows();
	}

}
