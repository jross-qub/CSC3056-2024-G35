package tests;

import java.util.Date;
import java.text.SimpleDateFormat;

import model.Account;
import utils.TestUtils;

public class AccountTest {
	
	public static void testConstructor() {
		// 1-Setup
		String test_account_number = "12345678";
		String test_username_of_account_holder = "peterparker@gmail.com";
		String test_account_type = "Standard";
		Date test_account_opening_date = new Date(1639576800);
		
		boolean passed = true;
		
		//2-Exercise, run the object under test (constructor)
		Account testAccount = new Account(test_account_number, 
				test_username_of_account_holder, test_account_type, test_account_opening_date);
		
		//3-Verify (Assert)
		if (testAccount.getAccount_number() == test_account_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getAccount_number-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getAccount_number-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
		}
		
		if (testAccount.getUsername_of_account_holder() == test_username_of_account_holder)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getUsername_of_account_holder-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-getUsername_of_account_holder-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
		}
		
		if (testAccount.getAccount_type() == test_account_type) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-getAccount_type-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-getAccount_type-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
		}
		
		if (testAccount.getAccount_opening_date() == test_account_opening_date) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-getAccount_opening_date-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-getAccount_opening_date-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
		}
		
		if (passed) {
			System.out.println("Test Cases Complete, all passed!");
		} else {
			System.out.println("Test Cases Complete, there are failures!");
		}
		
		//4-Assertions
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		
		System.out.println("Assertions Complete, all passed!");

	}
	
	public static void testSetters() {
		
		//1-Setup
		String old_account_number = "12344321";
		String old_username_of_account_holder = "brucewayne@gmail.com";
		String old_account_type = "Standard";
		Date old_account_opening_date = new Date(1646402400);
		
		String new_account_number = "87654321";
		String new_username_of_account_holder = "batman@gmail.com";
		String new_account_type = "Savings";
		Date new_account_opening_date = new Date();
				
		Account testAccount = new Account(old_account_number,
				old_username_of_account_holder, old_account_type, old_account_opening_date);
		
		boolean passed = true;
		
		//2-Exercise, run the object under test (setters)
		testAccount.setAccount_number(new_account_number);
		testAccount.setUsername_of_account_holder(new_username_of_account_holder);
		testAccount.setAccount_type(new_account_type);
		testAccount.setAccount_opening_date(new_account_opening_date);
		
		//3-Verify (Assert)
		if (testAccount.getAccount_number() == new_account_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-setAccount_number-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED+ "TC1-setAccount_number-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
			
		}
		
		if (testAccount.getUsername_of_account_holder() == new_username_of_account_holder)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-setUsername_of_account_holder-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC2-setUsername_of_account_holder-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
		}
		
		if (testAccount.getAccount_type() == new_account_type) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC3-setAccount_type-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC3-setAccount_type-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
		}
		
		if (testAccount.getAccount_opening_date() == new_account_opening_date)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC4-setAccount_opening_date-Passed"+ TestUtils.TEXT_COLOR_RESET);
		else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC4-setAccount_opening_date-FAILED"+ TestUtils.TEXT_COLOR_RESET);
			passed = false;
		}
		
		if (passed) {
			System.out.println("Test Cases Complete, all passed!");
		} else {
			System.out.println("Test Cases Complete, there are failures!");
		}
		
		//4-Assertions
		assert testAccount.getAccount_number() == new_account_number;
		assert testAccount.getUsername_of_account_holder() == new_account_number;
		assert testAccount.getAccount_type() == new_account_type;
		assert testAccount.getAccount_opening_date() == new_account_opening_date;
		
		System.out.println("Assertions Complete, all passed!");
	}

	public static void main(String[] args) {
		testConstructor();
		testSetters();
	}

}
