package com.lti.appl.user;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lti.appl.beans.Employment;
import com.lti.appl.beans.UserRegistration;
import com.lti.appl.exception.RecordAlreadyExists;
import com.lti.appl.services.EmploymentService;
import com.lti.appl.services.UserRegistrationService;

public class UserApp {

	public static void main(String[] args) throws RecordAlreadyExists {

		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");

		Scanner sc = new Scanner(System.in);
		System.out.println("***************** Welcome to User App *********************");
		System.out.println("Enter a choice");
		System.out.println("1. for Inserting a data to database"); 
		System.out.println("2. Updating the salary"); 
		
		EmploymentService employmentService = context.getBean("employmentService", EmploymentService.class);
		UserRegistrationService userRegistrationService = context.getBean("userRegistrationService", UserRegistrationService.class);
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Insert into data base");
			UserRegistration user = new UserRegistration("SANKETH", "REDDY", "sanketh@gmail.com", "sanketh123", 0);
			Employment employment = new Employment("GOVERNMENT", 900000, user);
  
			System.out.println(user); 
			System.out.println(employment);
			String userRegistrationMsg = userRegistrationService.checkEmail(user);
			
			if (userRegistrationMsg.equals("No Email Exists")) {
				String employmentMsg = employmentService.addUsers(employment);
				System.out.println(employmentMsg);
			} else {
				System.out.println(userRegistrationMsg);
			}
			break; 
		case 2:
			System.out.println("Updating the salary");   
			
			break;
			
			
		}

	}

}
