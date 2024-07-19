package practice;

import Generic_Utilities.Java_Utility;

public class SystemDateAndTimeEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Java_Utility jlib = new Java_Utility();
		String dateFormat = jlib.getSystemDateAndTime();
		System.out.println("System Date :-"+dateFormat);

	}

}
