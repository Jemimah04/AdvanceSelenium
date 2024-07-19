package dataDrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertMultipleData_Database {

		public static void main(String[] args) throws Throwable {
			// TODO Auto-generated method stub

			//S1: register/load the mysql database
					Driver driverRef = new Driver();
					DriverManager.registerDriver(driverRef);
					
					//S2: get connection to database
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_details","root","jemi");
					
					//S3: create sql statement
					Statement stt = conn.createStatement();
					String query="insert into student(first_name,last_name,address)values('Tryphosa','Ana','Chennai'),('Osteen','Ethan','Chennai')";
					//to add multiple data, use comma after one set of value
					int result = stt.executeUpdate(query); //this return + or - integer
					
					if(result!=1) //for single data to update , use ==1, for inserting multiple data use !=1
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

