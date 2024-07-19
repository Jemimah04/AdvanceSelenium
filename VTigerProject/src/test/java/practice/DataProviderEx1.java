package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	
	
	@Test(dataProvider="getData")
	public void bookTickets(String src, String destn, int pplNum)
	{
		System.out.println("Book tickets from "+src+ "to "+destn+" with people count of "+pplNum);
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[2][3];//2 rep no of times the execution takes place, 3 reps the 3 datas.
		
		objArr[0][0]="Bangalore";
		objArr[0][1]="Chennai";
		objArr[0][2]=5;
		
		objArr[1][0]="Chennai";
		objArr[1][1]="Pondicery";
		objArr[1][2]=11;
		
//		objArr[2][0]="Chennai";
//		objArr[2][1]="Goa";
//		objArr[2][2]=10;

		
		return objArr;
		
	}
	
	

}
