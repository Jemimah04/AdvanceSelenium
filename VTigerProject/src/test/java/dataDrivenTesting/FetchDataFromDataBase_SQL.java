package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generic_Utilities.BaseClass;

public class FetchDataFromDataBase_SQL extends BaseClass {

	@Test
	public void dataFromSQLDatabase() throws Throwable {
		// TODO Auto-generated method stub
		//S1: register/load the mysql database
		
		
		//S2: get connection to database
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root","jemi");
		
		//S3: create sql statement
		Statement stt = conn.createStatement();
		String query="select * from student";
		
		//S4: execute statement/query
		ResultSet result = stt.executeQuery(query);
		
		while(result.next()) //next() is a boolean check whether the database has data in it. if yes it will print the data
		{
			System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
		}
		//S5: close connection
		//conn.close();
	}

}
