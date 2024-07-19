package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import Generic_Utilities.BaseClass;

public class InsertDataIntoDatabase_SQL extends BaseClass {
	@Test
	public void insertDataToDatabase() throws Throwable {
		// TODO Auto-generated method stub

		//S1: register/load the mysql database
		
				
				//S2: get connection to database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root","jemi");
				
				//S3: create sql statement
				Statement stt = conn.createStatement();
				String query="insert into student(first_name,last_name,address)values('Tryphosa','Ana','Chennai')";
				int result = stt.executeUpdate(query); //this return + or - integer
				
				if(result==1) //for single data to update , use ==1, for inserting multiple data use !=1
				{
					System.out.println("data is updated in database");
				}
				else
				{
					System.out.println("data is not updated");
				}
		
		//after updates, go to sql command, and type mysql> select * from student; and give enter
			
	}

}
