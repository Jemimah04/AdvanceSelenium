package practice;

import org.testng.annotations.Test;

public class TestNGTest {

	
	@Test
	public void createContactTest() {
		System.out.println("Contact created");
	}
	
//	@Test(dependsOnMethods="createContactTest")
//	public void modifyContactsTest() {
//		System.out.println("Contacts modified");
//	}
//	
	@Test(invocationCount=3)
	public void modifyContactsTest() {
		System.out.println("Contacts modified");
	}

//	@Test(dependsOnMethods="createContactTest")
//	public void deleteContactTest() {
//		System.out.println("Contact deleted");
//	}
	
	@Test(enabled=false)
	public void deleteContactTest() {
		System.out.println("Contact deleted");
	}

}
