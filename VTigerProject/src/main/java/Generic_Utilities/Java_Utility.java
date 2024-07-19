package Generic_Utilities;

import java.util.Date;
import java.util.Random;

public class Java_Utility {
	
	
	/**
	 * uthis method is used to avoid Duplicates
	 * @return
	 * @author Jemimah
	 */
	public int getRandomNumber()
	{
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	return ranNum;
	//1st pull
	}
	
	/**
	 * this method is used to get Date and Time in IST 
	 *@return
	 *@author Jemimah
	 */
	
public String getSystemDateAndTime()
{
	Date date = new Date();
	String dateAndTime = date.toString();
	System.out.println(dateAndTime);
	
	String YYYY = dateAndTime.split(" ")[5];
	String DD = dateAndTime.split(" ")[2];
	//int MM = date.getMonth()+1;
	String MM = dateAndTime.split(" ")[1];
	
	String finalFormat = YYYY+"-"+MM+"-"+DD;
	//System.out.println(finalFormat);
	return finalFormat;
	
	
}

}
